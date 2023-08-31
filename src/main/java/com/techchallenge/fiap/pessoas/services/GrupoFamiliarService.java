package com.techchallenge.fiap.pessoas.services;


import com.techchallenge.fiap.pessoas.dominio.GrupoFamiliar;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.repository.GrupoFamiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoFamiliarService {

    private final GrupoFamiliarRepository repository;

    public GrupoFamiliar verifyOrCreateGroup(Pessoa pessoa) {
        var grupoOptional = repository.findById(pessoa.getId());

        if (grupoOptional.isPresent()) {
            return grupoOptional.get();
        } else {
            var grupo = new GrupoFamiliar();
            repository.save(grupo);
            return grupo;
        }
    }
}
