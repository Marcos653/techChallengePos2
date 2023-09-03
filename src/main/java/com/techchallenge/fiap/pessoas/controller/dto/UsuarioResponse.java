package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Usuario;
import lombok.*;

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
