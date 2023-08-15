package com.techchallenge.eletrodomesticos.services;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.repository.EletrodomesticoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EletrodomesticoService {

    private final EletrodomesticoRepository repository;

    @Transactional
    public Eletrodomestico save(Eletrodomestico eletrodomestico) {
        return repository.save(eletrodomestico);
    }

    public List<Eletrodomestico> findAll() {
        return repository.findAll();
    }

    public Optional<Eletrodomestico> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Eletrodomestico> findByPessoaId(Long usuarioId) {
        return repository.findByPessoaId(usuarioId);
    }

    public Double getConsumoEnergetico(Long id) {
        return findById(id).map(Eletrodomestico::getConsumoEnergetico).orElse(0.0);
    }
}
