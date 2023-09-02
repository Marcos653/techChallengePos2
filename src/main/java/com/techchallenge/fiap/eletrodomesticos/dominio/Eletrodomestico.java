package com.techchallenge.fiap.eletrodomesticos.dominio;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static Eletrodomestico of(EletrodomesticoRequest request) {
        var response = new Eletrodomestico();
        copyProperties(request, response);
        return response;
    }
}
