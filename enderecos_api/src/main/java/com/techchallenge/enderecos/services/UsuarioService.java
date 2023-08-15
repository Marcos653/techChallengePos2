package com.techchallenge.enderecos.services;

import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.dominio.Usuario;
import com.techchallenge.enderecos.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> buscarUsuariosPorEndereco(Endereco endereco) {
        return usuarioRepositorio.findByEnderecos(endereco);
    }
}
