package com.rodriguez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rodriguez.entities.Reclutamiento;

import java.util.List;

public interface ReclutamientoRepository extends JpaRepository<Reclutamiento, Integer> {

    @Query("""
        SELECT r FROM Reclutamiento r
        WHERE r.tripulacion.id = :idTripulacion
          AND r.esMiembroActual = true
    """)
    List<Reclutamiento> findMiembrosActualesPorTripulacion(
            @Param("idTripulacion") Long idTripulacion
    );

    @Query("""
        SELECT r FROM Reclutamiento r
        WHERE r.pirata.id = :idPirata
          AND r.esMiembroActual = true
    """)
    Reclutamiento findReclutamientoActivoPorPirata(
            @Param("idPirata") Integer idPirata
    );

    @Modifying
    @Transactional
    @Query("""
        UPDATE Reclutamiento r
        SET r.esMiembroActual = false
        WHERE r.pirata.id = :idPirata
          AND r.esMiembroActual = true
    """)
    void desactivarReclutamientosDelPirata(
            @Param("idPirata") Integer idPirata
    );

    @Modifying
    @Transactional
    @Query("""
        UPDATE Reclutamiento r
        SET r.esMiembroActual = false
        WHERE r.id = :idReclutamiento
    """)
    void eliminarMiembro(
            @Param("idReclutamiento") Integer idReclutamiento
    );
}