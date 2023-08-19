package com.techchallenge.eletrodomesticos.controller.dto;

import com.techchallenge.eletrodomesticos.dominio.Tensao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoFilters {

    private Long id;
    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;
    private Double tempoDeUso;
    private Long pessoaId;
}
