package com.techchallenge.enderecos.controller;

import com.techchallenge.enderecos.controller.dto.EnderecoDTO;
import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.services.EnderecoInvalidoException;
import com.techchallenge.enderecos.services.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> cadastrarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        try {
            Endereco endereco = enderecoDTO.toEndereco();
            enderecoService.salvarEndereco(endereco);

            return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
        } catch (EnderecoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscaEnderecoPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscaEnderecoPorId(id);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Endereco>> buscaEnderecos(@RequestParam(required = false) String rua,
                                                          @RequestParam(required = false) String bairro,
                                                          @RequestParam(required = false) String cidade) {
        List<Endereco> enderecos = new ArrayList<>();

        if (rua != null) {
            enderecos.addAll(enderecoService.buscarEnderecosPorRua(rua));
        }
        if (bairro != null) {
            enderecos.addAll(enderecoService.buscarEnderecosPorBairro(bairro));
        }
        if (cidade != null) {
            enderecos.addAll(enderecoService.buscarEnderecosPorCidade(cidade));
        }

        return ResponseEntity.ok(enderecos);
    }
}
