package com.techchallenge.fiap.eletrodomesticos.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEletrodomesticoRequest {

    @NotNull(message = "Pessoa ID é obrigatório")
    private Long pessoaId;

    @NotNull(message = "Eletrodoméstico ID é obrigatório")
    private Long eletrodomesticoId;

    @NotNull(message = "Tempo de Uso é obrigatório")
    @PositiveOrZero(message = "Tempo de Uso não pode ser negativo")
    private Double tempoDeUso;
}
