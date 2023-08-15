package com.techchallenge.enderecos.repository;

import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.dominio.MockUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<MockUsuario, Long> {
    List<MockUsuario> findByEnderecos(Endereco endereco);

}