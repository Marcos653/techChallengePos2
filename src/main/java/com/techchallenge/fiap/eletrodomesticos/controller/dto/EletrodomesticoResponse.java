package com.techchallenge.fiap.eletrodomesticos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.eletrodomesticos.dominio.Tensao;
import lombok.*;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoResponse {

    private Long id;
    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;
    private Long casaId;

    public static EletrodomesticoResponse of(Eletrodomestico request) {
        var response = new EletrodomesticoResponse();
        copyProperties(request, response);

        if (request.getCasa() != null) {
            response.setCasaId(request.getCasa().getId());
        }

        return response;
    }

    public static List<EletrodomesticoResponse> of(List<Eletrodomestico> eletrodomesticos) {
        return eletrodomesticos
                .stream()
                .map(EletrodomesticoResponse::of)
                .toList();
    }
}
