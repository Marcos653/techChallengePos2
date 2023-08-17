package com.techchallenge.enderecos.services;

import com.techchallenge.enderecos.dominio.MockUsuario;
import org.springframework.stereotype.Service;

import java.util.random.*;

@Service
public class AuthService {

    public MockUsuario obterUsuarioLogado() {
        MockUsuario usuarioMock = new MockUsuario();

        RandomGenerator random1 = RandomGenerator.of("Random");
        long mockId = random1.nextLong();

        usuarioMock.setIdUsuario(mockId);
        usuarioMock.setNome("Usuário Mock");

        return usuarioMock;
    }
}
