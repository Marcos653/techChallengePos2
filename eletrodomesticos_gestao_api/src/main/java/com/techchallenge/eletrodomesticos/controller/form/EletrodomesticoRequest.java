package com.techchallenge.eletrodomesticos.controller.form;

import com.techchallenge.eletrodomesticos.dominio.Tensao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "Marca é obrigatório")
    private String marca;

    @NotNull(message = "Tensão é obrigatório")
    private Tensao tensao;

    @NotNull(message = "Potência é obrigatório")
    @Min(value = 1, message = "Potência deve ser positiva")
    private Integer potencia;

    @NotNull(message = "Tempo de Uso é obrigatório")
    @PositiveOrZero(message = "Tempo de Uso não pode ser negativo")
    private Double tempoDeUso;

    @NotNull
    private Long pessoaId;
}
