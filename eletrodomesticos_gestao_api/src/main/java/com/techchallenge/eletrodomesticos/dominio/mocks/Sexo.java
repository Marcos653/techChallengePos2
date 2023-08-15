package com.techchallenge.eletrodomesticos.dominio.mocks;

import lombok.Getter;

@Getter
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIA("Não Binária");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }
}
