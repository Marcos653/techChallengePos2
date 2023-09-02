package com.techchallenge.fiap.eletrodomesticos.controller;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.PessoaEletrodomesticoRequest;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.PessoaEletrodomesticoResponse;
import com.techchallenge.fiap.eletrodomesticos.services.PessoaEletrodomesticoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("pessoas-eletrodomesticos")
public class PessoaEletrodomesticoController {

    private final PessoaEletrodomesticoService service;

    @PostMapping
    public ResponseEntity<PessoaEletrodomesticoResponse> create(@RequestBody @Valid PessoaEletrodomesticoRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaEletrodomesticoResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEletrodomesticoResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaEletrodomesticoResponse> update(@PathVariable Long id,
                                                                @RequestBody @Valid PessoaEletrodomesticoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/consumo")
    public ResponseEntity<Double> getConsumo(@PathVariable Long id) {
        return ResponseEntity.ok(service.getConsumoEnergetico(id));
    }
}
