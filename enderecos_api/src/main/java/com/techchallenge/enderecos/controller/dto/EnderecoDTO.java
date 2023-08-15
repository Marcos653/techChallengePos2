package com.techchallenge.enderecos.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.enderecos.dominio.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO {

    @JsonProperty
    @NotBlank(message = "{rua.obrigatorio}")
    private String rua;
    @JsonProperty
    @NotNull(message = "{numero.obrigatorio}")
    private int numero;
    @JsonProperty
    @NotBlank(message = "{bairro.obrigatorio}")
    private String bairro;
    @JsonProperty
    @NotBlank(message = "{cidade.obrigatorio}")
    private String cidade;
    @NotBlank(message = "{estado.obrigatorio}")
    @JsonProperty
    private String estado;

    public EnderecoDTO(Endereco endereco) {
        this(endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

    public EnderecoDTO(String rua, Integer numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco toEndereco() {
        return new Endereco(rua, numero, bairro, cidade, estado);
    }
}
