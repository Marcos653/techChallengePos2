package com.techchallenge.fiap.enderecos.controller;

import com.techchallenge.fiap.enderecos.controller.dto.CasaRequest;
import com.techchallenge.fiap.enderecos.controller.dto.CasaResponse;
import com.techchallenge.fiap.enderecos.services.CasaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/casas")
public class CasaController {

    private final CasaService service;

    @PostMapping
    public ResponseEntity<CasaResponse> create(@RequestBody @Valid CasaRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CasaResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasaResponse> update(@PathVariable Long id,
                                               @RequestBody @Valid CasaRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
