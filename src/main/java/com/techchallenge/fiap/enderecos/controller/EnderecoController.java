package com.techchallenge.fiap.enderecos.controller;

import com.techchallenge.fiap.enderecos.controller.dto.*;
import com.techchallenge.fiap.enderecos.services.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoResponse> create(@RequestBody @Valid EnderecoRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> list(EnderecoFilters filters) {
        return ResponseEntity.ok(service.findAll(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> update(@PathVariable Long id,
                                                   @RequestBody @Valid EnderecoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
