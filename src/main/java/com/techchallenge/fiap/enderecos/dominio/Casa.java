package com.techchallenge.fiap.enderecos.dominio;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.enderecos.controller.dto.CasaRequest;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pessoa_casa",
            joinColumns = @JoinColumn(name = "casa_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
    private List<Pessoa> pessoas = new ArrayList<>();

    @OneToMany(mappedBy = "casa", fetch = FetchType.LAZY)
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public void addEletrodomestico(Eletrodomestico eletrodomestico) {
        eletrodomesticos.add(eletrodomestico);
        eletrodomestico.setCasa(this);
    }

    public void removeEletrodomestico(Eletrodomestico eletrodomestico) {
        eletrodomesticos.remove(eletrodomestico);
        eletrodomestico.setCasa(null);
    }

    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        pessoa.getCasas().add(this);
    }

    public void removePessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
        pessoa.getCasas().remove(this);
    }

    public static Casa of(CasaRequest request) {
        var casa = new Casa();
        copyProperties(request, casa);
        return casa;
    }
}
