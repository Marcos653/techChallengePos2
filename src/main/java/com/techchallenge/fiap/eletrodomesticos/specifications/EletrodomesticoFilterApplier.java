package com.techchallenge.fiap.eletrodomesticos.specifications;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoFilters;
import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EletrodomesticoFilterApplier {

    public Specification<Eletrodomestico> apply(EletrodomesticoFilters filtro) {
        return Specification
                .where(EletrodomesticoSpecifications.byNome(filtro.getNome()))
                .and(EletrodomesticoSpecifications.byModelo(filtro.getModelo()))
                .and(EletrodomesticoSpecifications.byMarca(filtro.getMarca()))
                .and(EletrodomesticoSpecifications.byTensao(filtro.getTensao()))
                .and(EletrodomesticoSpecifications.byPotencia(filtro.getPotencia()));
    }
}
