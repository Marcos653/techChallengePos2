package com.techchallenge.fiap.enderecos.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.enderecos.repository.CasaRepository;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaService {

    @Autowired
    private CasaRepository casaRepository;

    public Casa criarCasa(Casa casa) {
        return casaRepository.save(casa);
    }

    public List<Casa> listarCasas() {
        return casaRepository.findAll();
    }

    public Casa findCasaById(Long id) {
        return casaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Casa não encontrada com ID: " + id));
    }
}
