package com.techchallenge.fiap.enderecos.repository;

import com.techchallenge.fiap.enderecos.dominio.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CasaRepository extends JpaRepository<Casa, Long>,
        JpaSpecificationExecutor<Casa> {
}
