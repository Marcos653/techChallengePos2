package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Sexo;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatório")
    private LocalDate dataNascimento;

    @NotNull(message = "Sexo é obrigatório")
    private Sexo sexo;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;
}
