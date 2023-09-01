package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.pessoas.controller.dto.UsuarioRequest;
import com.techchallenge.fiap.pessoas.controller.dto.UsuarioResponse;
import com.techchallenge.fiap.pessoas.dominio.Usuario;
import com.techchallenge.fiap.pessoas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    @Transactional
    public UsuarioResponse save(UsuarioRequest request) {
        var usuario = Usuario.of(request);
        repository.save(usuario);

        return UsuarioResponse.of(usuario);
    }

    public List<UsuarioResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(UsuarioResponse::of)
                .toList();
    }

    public Optional<UsuarioResponse> findById(Long id) {
        return Optional.of(UsuarioResponse.of(findUsuarioById(id)));
    }

    @Transactional
    public UsuarioResponse update(Long id, UsuarioRequest request) {
        var existingUsuario = findUsuarioById(id);

        updateUsuarioFromRequest(request, existingUsuario);
        repository.save(existingUsuario);

        return UsuarioResponse.of(existingUsuario);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(findUsuarioById(id).getId());
    }

    private void updateUsuarioFromRequest(UsuarioRequest request, Usuario usuario) {
        copyProperties(request, usuario, "id");
    }

    public Usuario findUsuarioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado com ID: " + id));
    }
}
