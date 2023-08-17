package com.techchallenge.eletrodomesticos.controller;

import com.techchallenge.eletrodomesticos.controller.form.EletrodomesticoRequest;
import com.techchallenge.eletrodomesticos.controller.form.EletrodomesticoResponse;
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
    public ResponseEntity<EletrodomesticoResponse> create(@RequestBody EletrodomesticoRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EletrodomesticoResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EletrodomesticoResponse> update(@PathVariable Long id,
                                                          @RequestBody EletrodomesticoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/consumo")
    public ResponseEntity<Double> getConsumo(@PathVariable Long id) {
        var consumo = service.getConsumoEnergetico(id);
        return ResponseEntity.ok(consumo);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<EletrodomesticoResponse>> getByUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByPessoaId(id));
    }
}

