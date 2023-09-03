package com.techchallenge.fiap.pessoas.dominio;

import com.techchallenge.fiap.pessoas.controller.dto.UsuarioRequest;
import jakarta.persistence.*;
import lombok.*;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public static Usuario of(UsuarioRequest request) {
        var response = new Usuario();
        copyProperties(request, response);
        return response;
    }
}
