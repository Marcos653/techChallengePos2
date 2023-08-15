package com.techchallenge.enderecos.dominio;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;

    @OneToMany(mappedBy = "usuario")
    private Set<Endereco> enderecos = new HashSet<>();
}
