package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.pessoas.controller.dto.*;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.repository.PessoaRepository;
import com.techchallenge.fiap.pessoas.specifications.PessoaFilterApplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final UsuarioService usuarioService;
    private final PessoaFilterApplier filterApplier;

    @Transactional
    public PessoaResponse save(PessoaRequest request) {
        var pessoa = Pessoa.of(request);

        pessoa.setUsuario(usuarioService.findUsuarioById(request.getUsuarioId()));
        repository.save(pessoa);

        return convertToResponse(pessoa);
    }

    public List<PessoaResponse> findAll(PessoaFilters filters) {
        return repository
                .findAll(filterApplier.apply(filters))
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<PessoaResponse> findById(Long id) {
        return Optional.of(convertToResponse(findPessoaById(id)));
    }

    @Transactional
    public PessoaResponse update(Long id, PessoaRequest request) {
        var existingPessoa = findPessoaById(id);

        updatePessoaFromRequest(request, existingPessoa);
        repository.save(existingPessoa);

        return convertToResponse(existingPessoa);
    }

    @Transactional
    public String deleteById(Long id) {
        repository.deleteById(findPessoaById(id).getId());
        return "Pessoa com ID " + id + " foi deletada com sucesso.";
    }

    private void updatePessoaFromRequest(PessoaRequest request, Pessoa pessoa) {
        copyProperties(request, pessoa, "id");
    }

    public Pessoa findPessoaById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com ID: " + id));
    }

    private PessoaResponse convertToResponse(Pessoa pessoa) {
        return PessoaResponse.of(pessoa);
    }
}
