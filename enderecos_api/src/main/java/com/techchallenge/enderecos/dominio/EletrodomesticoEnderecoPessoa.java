package com.techchallenge.enderecos.dominio;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_eletrodomestico_endereco_pessoa")
public class EletrodomesticoEnderecoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEletrodomestico")
    private MockEletrodomestico eletrodomestico;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private MockPessoa pessoa;

}
