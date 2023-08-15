package com.techchallenge.enderecos.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_eletrodomesticos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockEletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEletrodomestico;

    private String nome;
    private String modelo;
    private String marca;
    private String tensao;
    private Integer potencia;

    @OneToMany(mappedBy = "eletrodomestico")
    private Set<EletrodomesticoEnderecoPessoa> eletrodomesticosDaCasa = new HashSet<>();

}
