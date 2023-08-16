package com.techchallenge.eletrodomesticos.controller.form;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.dominio.Tensao;
import com.techchallenge.eletrodomesticos.dominio.mocks.PessoaStub;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoResponse {

    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;
    private Double tempoDeUso;
    private PessoaStub pessoa;

    public static EletrodomesticoResponse of(Eletrodomestico request) {
        var response = new EletrodomesticoResponse();
        copyProperties(request, response);
        return response;
    }
}
