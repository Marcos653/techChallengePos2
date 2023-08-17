package com.techchallenge.eletrodomesticos.services;

import com.techchallenge.eletrodomesticos.controller.dto.EletrodomesticoRequest;
import com.techchallenge.eletrodomesticos.controller.dto.EletrodomesticoResponse;
import com.techchallenge.eletrodomesticos.controller.exception.NotFoundException;
import com.techchallenge.eletrodomesticos.controller.exception.ValidationException;
import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.dominio.Tensao;
import com.techchallenge.eletrodomesticos.dominio.mocks.PessoaStub;
import com.techchallenge.eletrodomesticos.repository.EletrodomesticoRepository;
import com.techchallenge.eletrodomesticos.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository eletrodomesticoRepository;
    private final PessoaRepository pessoaRepository;

    @Transactional
    public EletrodomesticoResponse save(EletrodomesticoRequest request) {
        var eletrodomestico = Eletrodomestico.of(request);

        eletrodomestico.setPessoa(findPessoaById(request.getPessoaId()));
        eletrodomesticoRepository.save(eletrodomestico);

        return convertToResponse(eletrodomestico);
    }

    public List<EletrodomesticoResponse> findAll() {
        return eletrodomesticoRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<EletrodomesticoResponse> findById(Long id) {
        return Optional.of(convertToResponse(findEletrodomesticoById(id)));
    }

    public EletrodomesticoResponse update(Long id, EletrodomesticoRequest request) {
        var existingEletrodomestico = findEletrodomesticoById(id);

        updateEletrodomesticoFromRequest(request, existingEletrodomestico);
        eletrodomesticoRepository.save(existingEletrodomestico);

        return convertToResponse(existingEletrodomestico);
    }

    @Transactional
    public void deleteById(Long id) {
        eletrodomesticoRepository.deleteById(id);
    }

    public List<EletrodomesticoResponse> findByPessoaId(Long id) {
        return eletrodomesticoRepository.findByPessoaId(id)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Double getConsumoEnergetico(Long id) {
        return findEletrodomesticoById(id).getConsumoEnergetico();
    }

    private Eletrodomestico findEletrodomesticoById(Long id) {
        return eletrodomesticoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Eletrodomestico não encontrado com ID: " + id));
    }

    private void updateEletrodomesticoFromRequest(EletrodomesticoRequest request, Eletrodomestico eletrodomestico) {
        copyProperties(request, eletrodomestico, "id");
        eletrodomestico.setPessoa(findPessoaById(request.getPessoaId()));
    }

    private EletrodomesticoResponse convertToResponse(Eletrodomestico eletrodomestico) {
        return EletrodomesticoResponse.of(eletrodomestico);
    }

    private PessoaStub findPessoaById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }
}
