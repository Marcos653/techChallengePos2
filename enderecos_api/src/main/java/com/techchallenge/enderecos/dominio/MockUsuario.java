package com.techchallenge.enderecos.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MockUsuario {

    @Id
    private Long idUsuario;
    private String nome;

    @OneToMany(mappedBy = "mockUsuario")
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "mockUsuario")
    private Set<MockPessoa> pessoas = new HashSet<>();
}
