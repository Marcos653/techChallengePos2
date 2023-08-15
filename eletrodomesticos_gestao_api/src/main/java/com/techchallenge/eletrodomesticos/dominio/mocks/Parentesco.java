package com.techchallenge.eletrodomesticos.dominio.mocks;

import lombok.Getter;

@Getter
public enum Parentesco {

    PAI("Pai"),
    MAE("Mãe"),
    FILHO("Filho"),
    FILHA("Filha"),
    IRMAO("Irmão"),
    IRMA("Irmã"),
    AVOS("Avós"),
    TIO("Tio"),
    TIA("Tia"),
    PRIMO("Primo"),
    PRIMA("Prima"),
    SOBRINHO("Sobrinho"),
    SOBRINHA("Sobrinha"),
    OUTRO("Outro");

    private final String descricao;

    Parentesco(String descricao) {
        this.descricao = descricao;
    }
}
