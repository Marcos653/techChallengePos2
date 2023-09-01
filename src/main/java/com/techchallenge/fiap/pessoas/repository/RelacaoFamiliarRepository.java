package com.techchallenge.fiap.pessoas.repository;

import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelacaoFamiliarRepository extends JpaRepository<RelacaoFamiliar, Long> {

    @Query("SELECT r FROM RelacaoFamiliar r WHERE r.pessoa1.id = :parentId" +
            " AND (r.parentesco = 'PAI' OR r.parentesco = 'MAE')")
    List<RelacaoFamiliar> findSiblingsByParentId(@Param("parentId") Long parentId);
}
