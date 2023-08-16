package com.techchallenge.eletrodomesticos.repository;

import com.techchallenge.eletrodomesticos.dominio.mocks.PessoaStub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaStub, Long> {
}
