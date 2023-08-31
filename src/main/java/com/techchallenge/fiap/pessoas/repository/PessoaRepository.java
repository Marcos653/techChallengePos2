package com.techchallenge.fiap.pessoas.repository;

import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>,
        JpaSpecificationExecutor<Pessoa> {



}
