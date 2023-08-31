package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.pessoas.controller.dto.UsuarioResponse;
import com.techchallenge.fiap.pessoas.dominio.Usuario;
import com.techchallenge.fiap.pessoas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse criarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return convertToResponse(usuario);
    }

    public Optional<UsuarioResponse> findById(Long id) {
        return Optional.of(convertToResponse(findUsuarioById(id)));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        Usuario usuario = findUsuarioById(id);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado com ID: " + id));
    }

    private UsuarioResponse convertToResponse(Usuario usuario) {
        return UsuarioResponse.of(usuario);
    }
}
