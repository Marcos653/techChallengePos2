package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelacaoFamiliarRequest {

    @NotNull(message = "ID da pessoa 1 é obrigatório")
    private Long pessoa1Id;

    @NotNull(message = "ID da pessoa 2 é obrigatório")
    private Long pessoa2Id;

    @NotNull(message = "Parentesco é obrigatório")
    private Parentesco parentesco;
}
