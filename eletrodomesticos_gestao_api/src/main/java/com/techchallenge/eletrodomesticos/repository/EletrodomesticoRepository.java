package com.techchallenge.eletrodomesticos.repository;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long>,
        JpaSpecificationExecutor<Eletrodomestico> {

    List<Eletrodomestico> findByPessoaId(Long usuarioId);
}
