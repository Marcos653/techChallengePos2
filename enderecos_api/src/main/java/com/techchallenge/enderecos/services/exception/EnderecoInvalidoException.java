package com.techchallenge.enderecos.services.exception;

public class EnderecoInvalidoException extends RuntimeException {

    public EnderecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
