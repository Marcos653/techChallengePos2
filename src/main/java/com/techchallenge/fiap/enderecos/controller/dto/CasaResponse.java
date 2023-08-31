package com.techchallenge.fiap.enderecos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoResponse;
import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.enderecos.dominio.Endereco;
import com.techchallenge.fiap.pessoas.controller.dto.PessoaResponse;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasaResponse {

    private Long idCasa;
    private EnderecoResponse endereco;
    private List<PessoaResponse> pessoas = new ArrayList<>();
    private List<EletrodomesticoResponse> eletrodomesticos = new ArrayList<>();

    public static CasaResponse of(Casa casa) {
        var response = new CasaResponse();
        response.setIdCasa(casa.getIdCasa());

        //response.setEndereco(EnderecoResponse.of(casa.getEndereco()));

        response.setPessoas(casa.getPessoas().stream()
                .map(PessoaResponse::of)
                .collect(Collectors.toList()));

        response.setEletrodomesticos((casa.getEletrodomesticos().stream()
                .map(EletrodomesticoResponse:: of)
                .collect((Collectors.toList()))));

        return response;
    }
}

