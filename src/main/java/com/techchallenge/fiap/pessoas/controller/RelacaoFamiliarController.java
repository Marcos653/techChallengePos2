package com.techchallenge.fiap.pessoas.controller;

import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarRequest;
import com.techchallenge.fiap.pessoas.controller.dto.RelacaoFamiliarResponse;
import com.techchallenge.fiap.pessoas.services.RelacaoFamiliarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relacoes-familiares")
public class RelacaoFamiliarController {

    private final RelacaoFamiliarService service;

    @PostMapping
    public ResponseEntity<RelacaoFamiliarResponse> create(@RequestBody @Valid RelacaoFamiliarRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RelacaoFamiliarResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelacaoFamiliarResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
