package com.techchallenge.fiap.enderecos.controller.dto;

import com.techchallenge.fiap.enderecos.dominio.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {

    private Long id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Long casa;

    public static EnderecoResponse of(Endereco request) {
        var response = new EnderecoResponse();
        copyProperties(request, response);
        response.setCasa(request.getCasa().getIdCasa());
        return response;
    }
}

