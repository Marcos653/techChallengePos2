package com.techchallenge.fiap.enderecos.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.eletrodomesticos.services.EletrodomesticoService;
import com.techchallenge.fiap.enderecos.controller.dto.CasaRequest;
import com.techchallenge.fiap.enderecos.controller.dto.CasaResponse;
import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.enderecos.repository.CasaRepository;
import com.techchallenge.fiap.pessoas.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class CasaService {

    private final CasaRepository repository;
    private final EnderecoService enderecoService;
    private final PessoaService pessoaService;
    private final EletrodomesticoService eletrodomesticoService;

    @Transactional
    public CasaResponse save(CasaRequest request) {
        var casa = Casa.of(request);

        casa.setEndereco(enderecoService.findEnderecoById(request.getEnderecoId()));
        ofNullable(request.getPessoaIds())
                .ifPresent(pessoaIds -> addPessoasToCasa(pessoaIds, casa));
        ofNullable(request.getEletrodomesticoIds())
                .ifPresent(eletrodomesticoIds -> addEletrodomesticosToCasa(eletrodomesticoIds, casa));

        repository.save(casa);

        return convertToResponse(casa);
    }

    public List<CasaResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<CasaResponse> findById(Long id) {
        return Optional.of(convertToResponse(findCasaById(id)));
    }

    @Transactional
    public CasaResponse update(Long id, CasaRequest request) {
        var existingCasa = findCasaById(id);

        updateCasaFromRequest(request, existingCasa);
        updatePessoasInCasa(request.getPessoaIds(), existingCasa);
        updateEletrodomesticosInCasa(request.getEletrodomesticoIds(), existingCasa);

        repository.save(existingCasa);

        return convertToResponse(existingCasa);
    }

    @Transactional
    public String deleteById(Long id) {
        var casa = findCasaById(id);

        var pessoasTemp = new ArrayList<>(casa.getPessoas());
        var eletrodomesticosTemp = new ArrayList<>(casa.getEletrodomesticos());

        pessoasTemp.forEach(casa::removePessoa);
        eletrodomesticosTemp.forEach(casa::removeEletrodomestico);

        repository.deleteById(id);

        return "Casa com ID " + id + " foi deletada com sucesso.";
    }

    private Casa findCasaById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Casa não encontrada com ID: " + id));
    }

    private void updateCasaFromRequest(CasaRequest request, Casa casa) {
        copyProperties(request, casa, "id");
        casa.setEndereco(enderecoService.findEnderecoById(request.getEnderecoId()));
    }

    private void updatePessoasInCasa(List<Long> newPessoaIds, Casa casa) {
        casa.getPessoas().clear();

        ofNullable(newPessoaIds)
                .ifPresent(pessoaIds
                        -> pessoaIds.forEach(pessoaId -> {
                    var pessoa = pessoaService.findPessoaById(pessoaId);
                    casa.addPessoa(pessoa);
                }));
    }

    private void updateEletrodomesticosInCasa(List<Long> newEletrodomesticoIds, Casa casa) {
        casa.getEletrodomesticos().clear();

        ofNullable(newEletrodomesticoIds)
                .ifPresent(eletrodomesticoIds
                        -> eletrodomesticoIds.forEach(eletrodomesticoId -> {
                    var eletrodomestico = eletrodomesticoService.findEletrodomesticoById(eletrodomesticoId);
                    casa.addEletrodomestico(eletrodomestico);
                }));
    }

    private void addPessoasToCasa(List<Long> pessoaIds, Casa casa) {
        pessoaIds.forEach(pessoaId -> {
            var pessoa = pessoaService.findPessoaById(pessoaId);
            casa.addPessoa(pessoa);
        });
    }

    private void addEletrodomesticosToCasa(List<Long> eletrodomesticoIds, Casa casa) {
        eletrodomesticoIds.forEach(eletrodomesticoId -> {
            var eletrodomestico = eletrodomesticoService.findEletrodomesticoById(eletrodomesticoId);
            casa.addEletrodomestico(eletrodomestico);
        });
    }

    private CasaResponse convertToResponse(Casa casa) {
        return CasaResponse.of(casa);
    }
}
