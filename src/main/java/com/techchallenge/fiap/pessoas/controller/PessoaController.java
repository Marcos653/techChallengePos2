package com.techchallenge.fiap.pessoas.controller;

import com.techchallenge.fiap.pessoas.controller.dto.*;
import com.techchallenge.fiap.pessoas.services.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody @Valid PessoaRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> list(PessoaFilters filters) {
        return ResponseEntity.ok(service.findAll(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> update(@PathVariable Long id,
                                                 @RequestBody @Valid PessoaRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
