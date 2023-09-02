package com.techchallenge.fiap.eletrodomesticos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.dominio.PessoaEletrodomestico;
import com.techchallenge.fiap.pessoas.controller.dto.PessoaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEletrodomesticoResponse {

    private Long id;
    private PessoaResponse pessoa;
    private EletrodomesticoResponse eletrodomestico;
    private Double tempoDeUso;
    private Double consumoEnergetico;

    public static PessoaEletrodomesticoResponse of(PessoaEletrodomestico entity) {
        var response = new PessoaEletrodomesticoResponse();
        copyProperties(entity, response);
        response.setPessoa(PessoaResponse.of(entity.getPessoa()));
        response.setEletrodomestico((EletrodomesticoResponse.of(entity.getEletrodomestico())));
        return response;
    }
}
