package com.techchallenge.eletrodomesticos.dominio.mocks;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoas")
public class PessoaStub {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "parentesco")
    @Enumerated(EnumType.STRING)
    private Parentesco parentesco;
    @Column(name = "idade")
    private Integer idade;
    @OneToMany
    @JoinColumn(name="pessoa_id", referencedColumnName="id")
    private List<Eletrodomestico> eletrodomesticos;

    public PessoaStub(Long id, String nome, LocalDate dataNascimento, Sexo sexo, Parentesco parentesco, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
        this.idade = idade;
    }
}
