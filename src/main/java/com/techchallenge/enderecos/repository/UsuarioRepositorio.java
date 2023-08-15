package com.techchallenge.enderecos.repository;

import com.techchallenge.enderecos.dominio.Endereco;
import com.techchallenge.enderecos.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEnderecos(Endereco endereco);

}