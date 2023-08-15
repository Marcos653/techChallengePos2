package com.techchallenge.enderecos.repository;

import com.techchallenge.enderecos.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

    List<Endereco> findByRuaIgnoreCase(String rua);
    List<Endereco> findByBairroIgnoreCase(String bairro);
    List<Endereco> findByCidadeIgnoreCase(String cidade);


}
