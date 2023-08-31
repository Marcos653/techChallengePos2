package com.techchallenge.fiap.enderecos.dominio;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Getter
    @ManyToMany(mappedBy = "casas", cascade = CascadeType.PERSIST)
    private List<Pessoa> pessoas = new ArrayList<>();

    @OneToMany(mappedBy = "casa")
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
