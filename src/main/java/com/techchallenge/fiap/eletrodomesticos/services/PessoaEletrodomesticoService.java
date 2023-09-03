package com.techchallenge.fiap.eletrodomesticos.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.PessoaEletrodomesticoRequest;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.PessoaEletrodomesticoResponse;
import com.techchallenge.fiap.eletrodomesticos.dominio.PessoaEletrodomestico;
import com.techchallenge.fiap.eletrodomesticos.repository.PessoaEletrodomesticoRepository;
import com.techchallenge.fiap.pessoas.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaEletrodomesticoService {

    private final PessoaEletrodomesticoRepository repository;
    private final PessoaService pessoaService;
    private final EletrodomesticoService eletrodomesticoService;

    @Transactional
    public PessoaEletrodomesticoResponse save(PessoaEletrodomesticoRequest request) {
        var entity = createEntityFromRequest(request);
        repository.save(entity);

        return convertToResponse(entity);
    }

    public List<PessoaEletrodomesticoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<PessoaEletrodomesticoResponse> findById(Long id) {
        return Optional.of(convertToResponse(findPessoaEletrodomesticoById(id)));
    }

    @Transactional
    public PessoaEletrodomesticoResponse update(Long id, PessoaEletrodomesticoRequest request) {
        var existingEntity = findPessoaEletrodomesticoById(id);

        updateEntityFromRequest(existingEntity, request);
        repository.save(existingEntity);

        return convertToResponse(existingEntity);
    }

    @Transactional
    public String deleteById(Long id) {
        repository.deleteById(findPessoaEletrodomesticoById(id).getId());
        return "Pessoa eletrodomestico com ID " + id + " foi deletado com sucesso.";
    }

    public Double getConsumoEnergetico(Long id) {
        return findPessoaEletrodomesticoById(id).getConsumoEnergetico();
    }

    private PessoaEletrodomestico createEntityFromRequest(PessoaEletrodomesticoRequest request) {
        var pessoa = pessoaService.findPessoaById(request.getPessoaId());
        var eletrodomestico = eletrodomesticoService.findEletrodomesticoById(request.getEletrodomesticoId());
        var pessoaEletrodomestico = PessoaEletrodomestico.of(request);

        pessoaEletrodomestico.setPessoa(pessoa);
        pessoaEletrodomestico.setEletrodomestico(eletrodomestico);

        return pessoaEletrodomestico;
    }

    private void updateEntityFromRequest(PessoaEletrodomestico entity, PessoaEletrodomesticoRequest request) {
        var pessoa = pessoaService.findPessoaById(request.getPessoaId());
        var eletrodomestico = eletrodomesticoService.findEletrodomesticoById(request.getEletrodomesticoId());

        entity.setPessoa(pessoa);
        entity.setEletrodomestico(eletrodomestico);
        entity.setTempoDeUso(request.getTempoDeUso());
    }

    private PessoaEletrodomestico findPessoaEletrodomesticoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa eletrodomestico não encontrado com ID: " + id));
    }

    private PessoaEletrodomesticoResponse convertToResponse(PessoaEletrodomestico entity) {
        return PessoaEletrodomesticoResponse.of(entity);
    }
}
