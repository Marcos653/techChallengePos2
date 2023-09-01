package com.techchallenge.fiap.pessoas.controller;

import com.techchallenge.fiap.pessoas.controller.dto.UsuarioRequest;
import com.techchallenge.fiap.pessoas.controller.dto.UsuarioResponse;
import com.techchallenge.fiap.pessoas.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@RequestBody @Valid UsuarioRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id,
                                                  @RequestBody @Valid UsuarioRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
