package com.techchallenge.fiap.enderecos.repository;

import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.enderecos.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>,
        JpaSpecificationExecutor<Endereco> {

    @Query("SELECT e FROM Endereco e WHERE e.casa.id = :idCasa")
    Endereco findByCasaId(@Param("idCasa") Long idCasa);
}
