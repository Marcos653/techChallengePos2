package com.techchallenge.eletrodomesticos.specifications;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.dominio.Tensao;
import org.springframework.data.jpa.domain.Specification;

public class EletrodomesticoSpecifications {

    public static Specification<Eletrodomestico> byNome(String nome) {
        return (root, query, criteriaBuilder)
                -> nome == null ? null : criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Eletrodomestico> byModelo(String modelo) {
        return (root, query, criteriaBuilder)
                -> modelo == null ? null : criteriaBuilder.like(root.get("modelo"), "%" + modelo + "%");
    }

    public static Specification<Eletrodomestico> byMarca(String marca) {
        return (root, query, criteriaBuilder)
                -> marca == null ? null : criteriaBuilder.like(root.get("marca"), "%" + marca + "%");
    }

    public static Specification<Eletrodomestico> byTensao(Tensao tensao) {
        return (root, query, criteriaBuilder)
                -> tensao == null ? null : criteriaBuilder.equal(root.get("tensao"), tensao);
    }

    public static Specification<Eletrodomestico> byPotencia(Integer potencia) {
        return (root, query, criteriaBuilder)
                -> potencia == null ? null : criteriaBuilder.equal(root.get("potencia"), potencia);
    }

    public static Specification<Eletrodomestico> byTempoDeUso(Double tempoDeUso) {
        return (root, query, criteriaBuilder)
                -> tempoDeUso == null ? null : criteriaBuilder.equal(root.get("tempoDeUso"), tempoDeUso);
    }

    public static Specification<Eletrodomestico> byPessoaId(Long pessoaId) {
        return (root, query, criteriaBuilder)
                -> pessoaId == null ? null : criteriaBuilder.equal(root.get("pessoa").get("id"), pessoaId);
    }

}
