package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarRequest;
import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import com.techchallenge.fiap.pessoas.dominio.Sexo;
import com.techchallenge.fiap.pessoas.repository.RelacaoFamiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.techchallenge.fiap.pessoas.dominio.Parentesco.MAE;
import static com.techchallenge.fiap.pessoas.dominio.Parentesco.PAI;

@Component
@RequiredArgsConstructor
public class RelacaoFamiliarInferencia {

    private final RelacaoFamiliarRepository repository;
    private final PessoaService pessoaService;

    public void inferRelationships(RelacaoFamiliarRequest request) {
        var person1Id = request.getPessoa1Id();
        var person2Id = request.getPessoa2Id();
        var relationshipType = request.getParentesco();

        if (relationshipType == MAE || relationshipType == PAI) {
            inferSiblings(person1Id, person2Id);
        }
    }

    private void inferSiblings(Long parentId, Long newChildId) {
        var siblings = repository.findSiblingsByParentId(parentId);
        var newChild = pessoaService.findPessoaById(newChildId);

        siblings.forEach(filho -> {
            var filhoExistente = filho.getPessoa2();
            saveRelationship(filhoExistente, newChild);
            saveRelationship(newChild, filhoExistente);
        });
    }

    private void saveRelationship(Pessoa pessoa1, Pessoa pessoa2) {
        var relationship = new RelacaoFamiliar();

        relationship.setPessoa1(pessoa1);
        relationship.setPessoa2(pessoa2);
        relationship.setParentesco(genderedSibling(pessoa1.getSexo()));
        repository.save(relationship);
    }

    private Parentesco genderedSibling(Sexo sexo) {
        return sexo == Sexo.FEMININO ? Parentesco.IRMA : Parentesco.IRMAO;
    }
}
