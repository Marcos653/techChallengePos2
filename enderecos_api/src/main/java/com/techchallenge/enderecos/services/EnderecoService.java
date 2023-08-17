package com.techchallenge.enderecos.services;

import com.techchallenge.enderecos.controller.dto.EnderecoDTO;
import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.repository.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public EnderecoDTO buscaEnderecoDTOPorId(Long id) {
            Endereco endereco = repositorio.findById(id).orElse(null);
            if (endereco != null) {
                return toEnderecoDTO(endereco);
            }
            return null;
    }

    private EnderecoDTO toEnderecoDTO(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setRua(endereco.getRua());
        dto.setNumero(endereco.getNumero());
        dto.setBairro(endereco.getBairro());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        return dto;

    }

    public List<EnderecoDTO> buscarEnderecosDTOPorRua(String rua) {
        List<Endereco> enderecos = repositorio.findByRuaIgnoreCase(rua);
        return enderecos.stream()
                .map(this::toEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarEnderecosDTOPorBairro(String bairro) {
        List<Endereco> enderecos = repositorio.findByBairroIgnoreCase(bairro);
        return enderecos.stream()
                .map(this::toEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarEnderecosDTOPorCidade(String cidade) {
        List<Endereco> enderecos = repositorio.findByCidadeIgnoreCase(cidade);
        return enderecos.stream()
                .map(this::toEnderecoDTO)
                .collect(Collectors.toList());
    }

    public boolean deleteEnderecoPorId(Long id) {
        Optional<Endereco> enderecoOptional = repositorio.findById(id);

        if (enderecoOptional.isPresent()) {
            repositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizaEndereco(Long id, EnderecoDTO enderecoDTO) {
        Optional<Endereco> enderecoOptional = repositorio.findById(id);

        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            endereco.setRua(enderecoDTO.getRua());
            endereco.setNumero(enderecoDTO.getNumero());
            endereco.setBairro(enderecoDTO.getBairro());
            endereco.setCidade(enderecoDTO.getCidade());
            endereco.setEstado(enderecoDTO.getEstado());
            repositorio.save(endereco);
            return true;
        } else {
            return false;
        }
    }
}
