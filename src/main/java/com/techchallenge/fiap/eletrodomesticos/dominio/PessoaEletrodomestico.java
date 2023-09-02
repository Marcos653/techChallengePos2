package com.techchallenge.fiap.eletrodomesticos.dominio;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.PessoaEletrodomesticoRequest;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoas_eletrodomesticos")
public class PessoaEletrodomestico {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eletrodomestico_id")
    private Eletrodomestico eletrodomestico;

    @Column(name = "tempo_de_uso")
    private Double tempoDeUso;

    public Double getConsumoEnergetico() {
        return this.eletrodomestico.getPotencia() * this.tempoDeUso;
    }

    public static PessoaEletrodomestico of(PessoaEletrodomesticoRequest request) {
        var response = new PessoaEletrodomestico();
        copyProperties(request, response);
        return response;
    }
}
