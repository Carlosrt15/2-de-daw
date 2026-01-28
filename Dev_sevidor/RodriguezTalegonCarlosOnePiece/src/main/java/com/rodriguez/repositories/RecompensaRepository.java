package com.rodriguez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rodriguez.entities.Recompensa;

import java.util.List;

public interface RecompensaRepository extends JpaRepository<Recompensa, Integer> {

    @Query("""
        SELECT r FROM Recompensa r
        WHERE (:vigente IS NULL OR r.estaVigente = :vigente)
    """)
    List<Recompensa> buscarRecompensas(
            @Param("vigente") Boolean vigente
    );

    @Query("""
        SELECT r FROM Recompensa r
        WHERE r.pirata.id = :idPirata
          AND r.estaVigente = true
    """)
    Recompensa findRecompensaVigentePorPirata(
            @Param("idPirata") Integer idPirata
    );

    @Modifying
    @Transactional
    @Query("""
        UPDATE Recompensa r
        SET r.estaVigente = false
        WHERE r.pirata.id = :idPirata
          AND r.estaVigente = true
    """)
    void desactivarRecompensasVigentes(
            @Param("idPirata") Integer idPirata
    );

    @Modifying
    @Transactional
    @Query("""
        UPDATE Recompensa r
        SET r.estaVigente = false
        WHERE r.id = :idRecompensa
    """)
    void eliminarRecompensa(
            @Param("idRecompensa") Integer idRecompensa
    );
}
