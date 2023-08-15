package com.techchallenge.enderecos.services;

import com.techchallenge.enderecos.controller.dto.EnderecoDTO;
import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.repository.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepositorio repositorio;

    public void salvarEndereco(Endereco endereco) {
        repositorio.save(endereco);
    }

    public List<Endereco> buscaTodosEnderecos() {
        return repositorio.findAll();
    }

    public Endereco buscaEnderecoPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Endereco> buscarEnderecosPorRua(String rua) {
        return repositorio.findByRuaIgnoreCase(rua);
    }

    public List<Endereco> buscarEnderecosPorBairro(String bairro) {
        return repositorio.findByBairroIgnoreCase(bairro);
    }

    public List<Endereco> buscarEnderecosPorCidade(String cidade) {
        return repositorio.findByCidadeIgnoreCase(cidade);
    }
}
