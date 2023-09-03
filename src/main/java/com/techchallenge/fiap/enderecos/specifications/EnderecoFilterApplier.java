package com.techchallenge.fiap.enderecos.specifications;

import com.techchallenge.fiap.enderecos.controller.dto.EnderecoFilters;
import com.techchallenge.fiap.enderecos.dominio.Endereco;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EnderecoFilterApplier {

    public Specification<Endereco> apply(EnderecoFilters filtro) {
        return Specification
                .where(EnderecoSpecifications.byRua(filtro.getRua()))
                .and(EnderecoSpecifications.byNumero(filtro.getNumero()))
                .and(EnderecoSpecifications.byBairro(filtro.getBairro()))
                .and(EnderecoSpecifications.byCidade(filtro.getCidade()))
                .and(EnderecoSpecifications.byEstado(filtro.getEstado()));
    }
}
