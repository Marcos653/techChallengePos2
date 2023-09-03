package com.techchallenge.fiap.pessoas.specifications;

import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class PessoaSpecifications {

    public static Specification<Pessoa> byNome(String nome) {
        return (root, query, criteriaBuilder)
                -> nome == null ? null : criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Pessoa> byDataNascimento(LocalDate dataNascimento) {
        return (root, query, criteriaBuilder)
                -> dataNascimento == null ? null : criteriaBuilder.equal(root.get("dataNascimento"), dataNascimento);
    }

    public static Specification<Pessoa> bySexo(Sexo sexo) {
        return (root, query, criteriaBuilder)
                -> sexo == null ? null : criteriaBuilder.equal(root.get("sexo"), sexo);
    }

    public static Specification<Pessoa> byParentesco(Parentesco parentesco) {
        return (root, query, criteriaBuilder)
                -> parentesco == null ? null : criteriaBuilder.equal(root.get("parentesco"), parentesco);
    }
}
