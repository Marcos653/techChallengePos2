package com.techchallenge.fiap.pessoas.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "relacao_familiares")
public class RelacaoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_familiar_id")
    private GrupoFamiliar grupoFamiliar;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentesco")
    private Parentesco parentesco;
}
