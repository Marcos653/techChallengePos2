package com.techchallenge.fiap.enderecos.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long idCasa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;


    @ManyToMany(mappedBy = "casas", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas = new ArrayList<>();

    @OneToMany(mappedBy = "casa")
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
