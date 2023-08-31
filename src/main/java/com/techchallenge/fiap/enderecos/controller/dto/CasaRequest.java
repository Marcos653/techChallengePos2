package com.techchallenge.fiap.enderecos.controller.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasaRequest {

    @NotNull(message = "ID do Endereço é obrigatório")
    private Long idEndereco;


    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();


}

