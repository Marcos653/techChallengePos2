package com.techchallenge.enderecos.services;

public class EnderecoInvalidoException extends RuntimeException {

    public EnderecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
