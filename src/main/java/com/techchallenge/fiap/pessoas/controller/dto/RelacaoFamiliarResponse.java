package com.techchallenge.fiap.pessoas.controller.dto;

import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelacaoFamiliarResponse {

    private Long id;
    private Long pessoa1Id;
    private Long pessoa2Id;
    private Parentesco parentesco;

    public static RelacaoFamiliarResponse of(RelacaoFamiliar relacao) {
        var response = new RelacaoFamiliarResponse();
        copyProperties(relacao, response);
        response.setPessoa1Id(relacao.getPessoa1().getId());
        response.setPessoa2Id(relacao.getPessoa2().getId());
        return response;
    }
}
