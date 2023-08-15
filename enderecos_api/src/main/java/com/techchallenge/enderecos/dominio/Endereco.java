package com.techchallenge.enderecos.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"idEndereco"})
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private MockUsuario mockUsuario;

    @OneToMany(mappedBy = "endereco")
    private Set<EletrodomesticoEnderecoPessoa> eletrodomesticosDaCasa = new HashSet<>();


    public Endereco(String rua, Integer numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

}
