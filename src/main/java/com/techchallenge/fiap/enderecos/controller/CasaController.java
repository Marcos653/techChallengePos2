package com.techchallenge.fiap.enderecos.controller;

import com.techchallenge.fiap.enderecos.dominio.Casa;
import com.techchallenge.fiap.enderecos.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casas")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @PostMapping
    public ResponseEntity<Casa> criarCasa(@RequestBody Casa casa) {
        Casa novaCasa = casaService.criarCasa(casa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCasa);
    }

    @GetMapping
    public ResponseEntity<List<Casa>> listarCasas() {
        List<Casa> casas = casaService.listarCasas();
        return ResponseEntity.ok(casas);
    }

}

