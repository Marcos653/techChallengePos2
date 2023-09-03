package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarRequest;
import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarResponse;
import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import com.techchallenge.fiap.pessoas.repository.RelacaoFamiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelacaoFamiliarService {

    private final RelacaoFamiliarRepository repository;
    private final RelacaoFamiliarInferencia inferencia;
    private final PessoaService pessoaService;

    @Transactional
    public RelacaoFamiliarResponse save(RelacaoFamiliarRequest request) {
        var relacao = RelacaoFamiliar.of(request);

        relacao.setPessoa1(pessoaService.findPessoaById(request.getPessoa1Id()));
        relacao.setPessoa2(pessoaService.findPessoaById(request.getPessoa2Id()));
        inferencia.inferRelationships(request);
        repository.save(relacao);

        return RelacaoFamiliarResponse.of(relacao);
    }

    public List<RelacaoFamiliarResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(RelacaoFamiliarResponse::of)
                .toList();
    }

    public Optional<RelacaoFamiliarResponse> findById(Long id) {
        return Optional.of(RelacaoFamiliarResponse.of(findRelacaoById(id)));
    }

    @Transactional
    public String deleteById(Long id) {
        repository.deleteById(findRelacaoById(id).getId());
        return "Relação familiar com ID " + id + " foi deletado com sucesso.";
    }

    public RelacaoFamiliar findRelacaoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Relação familiar não encontrada com ID: " + id));
    }
}
