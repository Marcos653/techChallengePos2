package com.techchallenge.fiap.pessoas.controller.dto;



import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    @NotNull(message = "Parentesco é obrigatório")
    private Parentesco parentesco;

    private List<Long> casaIds = new ArrayList<>();

}
