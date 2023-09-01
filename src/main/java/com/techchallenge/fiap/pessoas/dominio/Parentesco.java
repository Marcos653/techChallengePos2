package com.techchallenge.fiap.pessoas.dominio;

import lombok.Getter;

@Getter
public enum Parentesco {

    PAI("Pai"),
    MAE("Mãe"),
    FILHO("Filho"),
    FILHA("Filha"),
    IRMAO("Irmão"),
    IRMA("Irmã"),
    OUTRO("Outro");

    private final String descricao;

    Parentesco(String descricao) {
        this.descricao = descricao;
    }
}
