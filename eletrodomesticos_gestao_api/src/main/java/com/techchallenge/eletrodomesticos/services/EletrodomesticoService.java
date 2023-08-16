package com.techchallenge.eletrodomesticos.services;

import com.techchallenge.eletrodomesticos.controller.form.EletrodomesticoRequest;
import com.techchallenge.eletrodomesticos.controller.form.EletrodomesticoResponse;
import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.dominio.mocks.PessoaStub;
import com.techchallenge.eletrodomesticos.repository.EletrodomesticoRepository;
import com.techchallenge.eletrodomesticos.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository eletrodomesticoRepository;
    private final PessoaRepository pessoaRepository;

    @Transactional
    public EletrodomesticoResponse save(EletrodomesticoRequest request) {
        var eletrodomestico = Eletrodomestico.of(request);
        eletrodomesticoRepository.save(eletrodomestico);
        return createResponseWithPessoa(eletrodomestico);
    }

    public List<EletrodomesticoResponse> findAll() {
        return eletrodomesticoRepository.findAll()
                .stream()
                .map(EletrodomesticoResponse::of)
                .collect(Collectors.toList());
    }

    public Optional<EletrodomesticoResponse> findById(Long id) {
        return eletrodomesticoRepository.findById(id)
                .map(EletrodomesticoResponse::of);
    }

    @Transactional
    public void deleteById(Long id) {
        eletrodomesticoRepository.deleteById(id);
    }

    public List<EletrodomesticoResponse> findByPessoaId(Long id) {
        return eletrodomesticoRepository.findByPessoaId(id)
                .stream()
                .map(EletrodomesticoResponse::of)
                .collect(Collectors.toList());
    }

    public Double getConsumoEnergetico(Long id) {
        var eletrodomestico = eletrodomesticoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Eletrodomestico não encontrado"));
        return eletrodomestico.getConsumoEnergetico();
    }

    private EletrodomesticoResponse createResponseWithPessoa(Eletrodomestico request) {
        var response = EletrodomesticoResponse.of(request);
        var pessoa = findPessoaById(request.getPessoaId());
        response.setPessoa(pessoa);
        return response;
    }

    public PessoaStub findPessoaById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
    }
}
