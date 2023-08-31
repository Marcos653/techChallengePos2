package com.techchallenge.fiap.pessoas.dominio;

import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.pessoas.controller.dto.PessoaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Casa_Pessoa",
            joinColumns = @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_casa", referencedColumnName = "id_casa"))
    private List<Casa> casas = new ArrayList<>();


    public static Pessoa of(PessoaRequest request) {
        var response = new Pessoa();
        copyProperties(request, response);
        return response;
    }
}
