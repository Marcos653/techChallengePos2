package com.techchallenge.fiap.enderecos.controller.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFilters {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
}
