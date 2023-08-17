package com.techchallenge.enderecos.controller;

import com.techchallenge.enderecos.controller.dto.EnderecoDTO;
import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.dominio.MockUsuario;
import com.techchallenge.enderecos.services.AuthService;
import com.techchallenge.enderecos.services.exception.EnderecoInvalidoException;
import com.techchallenge.enderecos.services.EnderecoService;
import com.techchallenge.enderecos.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final AuthService authService;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        try {
            MockUsuario usuarioLogado = authService.obterUsuarioLogado();
            usuarioService.salvarUsuario(usuarioLogado);
            Endereco endereco = enderecoDTO.toEndereco();
            endereco.setMockUsuario(usuarioLogado);
            enderecoService.salvarEndereco(endereco);

            return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
        } catch (EnderecoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscaEnderecoPorId(@PathVariable Long id) {
        EnderecoDTO enderecoDTO = enderecoService.buscaEnderecoDTOPorId(id);

        if (enderecoDTO != null) {
            return ResponseEntity.ok(enderecoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EnderecoDTO>> buscaEnderecos(@RequestParam(required = false) String rua,
                                                          @RequestParam(required = false) String bairro,
                                                          @RequestParam(required = false) String cidade) {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        if (rua != null) {
            enderecosDTO.addAll(enderecoService.buscarEnderecosDTOPorRua(rua));
        }
        if (bairro != null) {
            enderecosDTO.addAll(enderecoService.buscarEnderecosDTOPorBairro(bairro));
        }
        if (cidade != null) {
            enderecosDTO.addAll(enderecoService.buscarEnderecosDTOPorCidade(cidade));
        }

        return ResponseEntity.ok(enderecosDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable Long id) {
        boolean deleted = enderecoService.deleteEnderecoPorId(id);

        if (deleted) {
            return ResponseEntity.ok("Endereco ID: " + id + " excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizaEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoDTO enderecoDTO) {

        boolean atualizado = enderecoService.atualizaEndereco(id, enderecoDTO);

        if (atualizado) {
            return ResponseEntity.ok("Endereço ID: " + id + " atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
