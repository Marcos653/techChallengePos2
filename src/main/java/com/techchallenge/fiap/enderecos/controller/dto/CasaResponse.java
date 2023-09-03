package com.techchallenge.fiap.enderecos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoResponse;
import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.pessoas.controller.dto.PessoaResponse;
import lombok.*;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasaResponse {

    private Long id;
    private EnderecoResponse endereco;
    private List<PessoaResponse> pessoas;
    private List<EletrodomesticoResponse> eletrodomesticos;

    public static CasaResponse of(Casa casa) {
        var response = new CasaResponse();

        copyProperties(casa, response);
        response.setEndereco(EnderecoResponse.of(casa.getEndereco()));
        response.setPessoas(PessoaResponse.of(casa.getPessoas()));
        response.setEletrodomesticos(EletrodomesticoResponse.of(casa.getEletrodomesticos()));

        return response;
    }
}
