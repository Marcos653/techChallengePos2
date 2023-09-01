package com.techchallenge.fiap.pessoas.dominio;

import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarRequest;
import jakarta.persistence.*;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Entity
@Table(name = "relacao_familiares")
public class RelacaoFamiliar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa1_id")
    private Pessoa pessoa1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa2_id")
    private Pessoa pessoa2;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentesco")
    private Parentesco parentesco;

    public static RelacaoFamiliar of(RelacaoFamiliarRequest request) {
        var response = new RelacaoFamiliar();
        copyProperties(request, response);
        return response;
    }
}
