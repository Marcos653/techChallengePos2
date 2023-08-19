package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;
    private Integer idade;

    public static PessoaResponse of(Pessoa request) {
        var response = new PessoaResponse();
        copyProperties(request, response);
        return response;
    }
}
