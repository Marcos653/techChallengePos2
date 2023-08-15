package com.techchallenge.eletrodomesticos.dominio;

public enum Tensao {

    V110("110 Volts"),
    V220("220 Volts");

    private final String descricao;

    Tensao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
