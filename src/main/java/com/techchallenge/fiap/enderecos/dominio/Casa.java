package com.techchallenge.fiap.enderecos.dominio;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    private Long idCasa;

    @OneToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "Casa_Pessoa",
            joinColumns = @JoinColumn(name = "idCasa"),
            inverseJoinColumns = @JoinColumn(name = "idPessoa"))
    private List<Pessoa> pessoas = new ArrayList<>();

    @OneToMany(mappedBy = "casa")
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();


}
