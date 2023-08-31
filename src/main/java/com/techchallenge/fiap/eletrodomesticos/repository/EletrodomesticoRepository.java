package com.techchallenge.fiap.eletrodomesticos.repository;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long>,
        JpaSpecificationExecutor<Eletrodomestico> {

    @Query("SELECT e FROM Eletrodomestico e WHERE e.casa.idCasa = :casaId")
    List<Eletrodomestico> findByCasaId(@Param("casaId") Long casaId);
}
