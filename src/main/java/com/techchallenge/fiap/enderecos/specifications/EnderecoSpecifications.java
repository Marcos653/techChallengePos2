package com.techchallenge.fiap.enderecos.specifications;

import com.techchallenge.fiap.enderecos.dominio.Endereco;
import org.springframework.data.jpa.domain.Specification;

public class EnderecoSpecifications {

    public static Specification<Endereco> byRua(String rua) {
        return (root, query, criteriaBuilder)
                -> rua == null ? null : criteriaBuilder.like(root.get("rua"), "%" + rua + "%");
    }

    public static Specification<Endereco> byNumero(Integer numero) {
        return (root, query, criteriaBuilder)
                -> numero == null ? null : criteriaBuilder.equal(root.get("numero"), numero);
    }

    public static Specification<Endereco> byBairro(String bairro) {
        return (root, query, criteriaBuilder)
                -> bairro == null ? null : criteriaBuilder.like(root.get("bairro"), "%" + bairro + "%");
    }

    public static Specification<Endereco> byCidade(String cidade) {
        return (root, query, criteriaBuilder)
                -> cidade == null ? null : criteriaBuilder.like(root.get("cidade"), "%" + cidade + "%");
    }

    public static Specification<Endereco> byEstado(String estado) {
        return (root, query, criteriaBuilder)
                -> estado == null ? null : criteriaBuilder.like(root.get("estado"), "%" + estado + "%");
    }
}
