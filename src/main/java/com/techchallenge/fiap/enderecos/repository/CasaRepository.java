package com.techchallenge.fiap.enderecos.repository;

import com.techchallenge.fiap.enderecos.dominio.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CasaRepository extends JpaRepository<Casa, Long>,
        JpaSpecificationExecutor<Casa> {

    @Query("SELECT c FROM Casa c WHERE c.endereco.id = :idEndereco")
    Casa findByEnderecoId(@Param("idEndereco") Long idEndereco);


}
