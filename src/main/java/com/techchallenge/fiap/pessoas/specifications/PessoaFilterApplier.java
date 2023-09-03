package com.techchallenge.fiap.pessoas.specifications;

import com.techchallenge.fiap.pessoas.controller.dto.PessoaFilters;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PessoaFilterApplier {

    public Specification<Pessoa> apply(PessoaFilters filtro) {
        return Specification
                .where(PessoaSpecifications.byNome(filtro.getNome()))
                .and(PessoaSpecifications.byDataNascimento(filtro.getDataNascimento()))
                .and(PessoaSpecifications.bySexo(filtro.getSexo()))
                .and(PessoaSpecifications.byParentesco(filtro.getParentesco()));
    }
}
