package com.techchallenge.fiap.eletrodomesticos.controller;

import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoFilters;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoRequest;
import com.techchallenge.fiap.eletrodomesticos.controller.dto.EletrodomesticoResponse;
import com.techchallenge.fiap.eletrodomesticos.services.EletrodomesticoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    private final EletrodomesticoService service;

    @PostMapping
    public ResponseEntity<EletrodomesticoResponse> create(@RequestBody @Valid EletrodomesticoRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EletrodomesticoResponse>> list(EletrodomesticoFilters filters) {
        return ResponseEntity.ok(service.findAll(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EletrodomesticoResponse> update(@PathVariable Long id,
                                                          @RequestBody @Valid EletrodomesticoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
