package com.techchallenge.fiap.eletrodomesticos.services;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoFilters;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoRequest;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoResponse;
import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.eletrodomesticos.repository.EletrodomesticoRepository;
import com.techchallenge.fiap.eletrodomesticos.specifications.EletrodomesticoFilterApplier;
import com.techchallenge.fiap.pessoas.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository repository;
    private final EletrodomesticoFilterApplier filterApplier;
    private final PessoaService pessoaService;

    @Transactional
    public EletrodomesticoResponse save(EletrodomesticoRequest request) {
        var eletrodomestico = Eletrodomestico.of(request);

        repository.save(eletrodomestico);

        return convertToResponse(eletrodomestico);
    }

    public List<EletrodomesticoResponse> findAll(EletrodomesticoFilters filters) {
        return repository
                .findAll(filterApplier.apply(filters))
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<EletrodomesticoResponse> findById(Long id) {
        return Optional.of(convertToResponse(findEletrodomesticoById(id)));
    }

    @Transactional
    public EletrodomesticoResponse update(Long id, EletrodomesticoRequest request) {
        var existingEletrodomestico = findEletrodomesticoById(id);

        updateEletrodomesticoFromRequest(request, existingEletrodomestico);
        repository.save(existingEletrodomestico);

        return convertToResponse(existingEletrodomestico);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(findEletrodomesticoById(id).getId());
    }

    public Eletrodomestico findEletrodomesticoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Eletrodomestico não encontrado com ID: " + id));
    }

    private void updateEletrodomesticoFromRequest(EletrodomesticoRequest request, Eletrodomestico eletrodomestico) {
        copyProperties(request, eletrodomestico, "id");
    }

    private EletrodomesticoResponse convertToResponse(Eletrodomestico eletrodomestico) {
        return EletrodomesticoResponse.of(eletrodomestico);
    }
}
