package com.techchallenge.eletrodomesticos.dominio;

import com.techchallenge.eletrodomesticos.controller.form.EletrodomesticoRequest;
import jakarta.persistence.*;
import lombok.*;

import static org.springframework.beans.BeanUtils.copyProperties;

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

    public static Eletrodomestico of(EletrodomesticoRequest request) {
        var response = new Eletrodomestico();
        copyProperties(request, response);
        return response;
    }
}
