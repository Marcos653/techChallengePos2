package com.techchallenge.enderecos.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private MockUsuario mockUsuario;

    private String nome;
    private String parentesco;
    private String sexo;
    private Integer idade;

    @Column(name = "data_Nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private Set<EletrodomesticoEnderecoPessoa> eletrodomesticosDaCasa = new HashSet<>();

}
