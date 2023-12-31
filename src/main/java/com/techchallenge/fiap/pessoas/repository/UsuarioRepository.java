package com.techchallenge.fiap.pessoas.repository;

import com.techchallenge.fiap.pessoas.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
