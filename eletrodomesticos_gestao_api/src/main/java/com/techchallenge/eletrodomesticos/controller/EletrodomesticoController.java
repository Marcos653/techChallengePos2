package com.techchallenge.eletrodomesticos.controller;

import com.techchallenge.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.eletrodomesticos.services.EletrodomesticoService;
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
    public ResponseEntity<Eletrodomestico> create(@RequestBody Eletrodomestico eletrodomestico) {
        Eletrodomestico saved = service.save(eletrodomestico);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Eletrodomestico>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eletrodomestico> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eletrodomestico> update(@PathVariable Long id, @RequestBody Eletrodomestico eletrodomestico) {
        Eletrodomestico updated = service.save(eletrodomestico);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/consumo")
    public ResponseEntity<Double> getConsumo(@PathVariable Long id) {
        Double consumo = service.getConsumoEnergetico(id);
        return ResponseEntity.ok(consumo);
    }

    @GetMapping("/usuario/{usuario_id}")
    public ResponseEntity<List<Eletrodomestico>> getByUsuario(@PathVariable("usuario_id") Long usuarioId) {
        return ResponseEntity.ok(service.findByPessoaId(usuarioId));
    }
}

