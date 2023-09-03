package com.techchallenge.fiap.enderecos.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasaRequest {

    @NotNull(message = "ID do endereço é obrigatório")
    private Long enderecoId;

    @NotNull(message = "A lista de IDs de pessoas não pode ser nula")
    @NotEmpty(message = "A lista de IDs de pessoas não pode estar vazia")
    private List<Long> pessoaIds;

    @NotNull(message = "A lista de IDs de eletrodomésticos não pode ser nula")
    @NotEmpty(message = "A lista de IDs de eletrodomésticos não pode estar vazia")
    private List<Long> eletrodomesticoIds;
}
