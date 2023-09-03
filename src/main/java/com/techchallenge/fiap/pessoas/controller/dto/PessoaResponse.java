package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    private Long usuarioId;

    public static PessoaResponse of(Pessoa request) {
        var response = new PessoaResponse();
        copyProperties(request, response);
        response.setUsuarioId(request.getUsuario().getId());
        return response;
    }

    public static List<PessoaResponse> of(List<Pessoa> pessoas) {
        return pessoas
                .stream()
                .map(PessoaResponse::of)
                .toList();
    }
}
