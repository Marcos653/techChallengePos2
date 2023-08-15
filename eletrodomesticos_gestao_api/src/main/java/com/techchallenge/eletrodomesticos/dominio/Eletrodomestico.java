package com.techchallenge.eletrodomesticos.dominio;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eletrodomesticos")
public class Eletrodomestico {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Enumerated(EnumType.STRING)
    @Column(name = "tensao")
    private Tensao tensao;
    @Column(name = "potencia")
    private Integer potencia;
    @Column(name = "tempo_de_uso")
    private Double tempoDeUso;
    @Column(name = "pessoa_id")
    private Long pessoaId;

    public Double getConsumoEnergetico() {
        return this.potencia * this.tempoDeUso;
    }
}
