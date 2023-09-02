package com.techchallenge.fiap.eletrodomesticos.repository;

import com.techchallenge.fiap.eletrodomesticos.dominio.PessoaEletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEletrodomesticoRepository extends JpaRepository<PessoaEletrodomestico, Long> {
}
