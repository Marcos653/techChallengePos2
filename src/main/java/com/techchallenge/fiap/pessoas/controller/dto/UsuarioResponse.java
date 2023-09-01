package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;

    public static UsuarioResponse of(Usuario usuario) {
        var response = new UsuarioResponse();
        copyProperties(usuario, response);
        return response;
    }
}
