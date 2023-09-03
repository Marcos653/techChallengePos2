package com.techchallenge.fiap.eletrodomesticos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.dominio.Tensao;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoFilters {

    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;
}
