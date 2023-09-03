package com.techchallenge.fiap.enderecos.dominio;

import com.techchallenge.fiap.enderecos.controller.dto.EnderecoRequest;
import jakarta.persistence.*;
import lombok.*;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    public static Endereco of(EnderecoRequest request) {
        var endereco = new Endereco();
        copyProperties(request, endereco);
        return endereco;
    }
}
