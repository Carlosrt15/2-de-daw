package com.rodriguez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rodriguez.entities.Tripulacion;

import java.util.List;

public interface TripulacionRepository extends JpaRepository<Tripulacion, Long> {

    @Query("""
        SELECT t FROM Tripulacion t
        WHERE (:nombre IS NULL OR LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
          AND (:barco IS NULL OR LOWER(t.barco) LIKE LOWER(CONCAT('%', :barco, '%')))
          AND (:activa IS NULL OR t.estaActiva = :activa)
    """)
    List<Tripulacion> buscarTripulaciones(
            @Param("nombre") String nombre,
            @Param("barco") String barco,
            @Param("activa") Boolean activa
    );

    @Query("""
        SELECT COUNT(r)
        FROM Reclutamiento r
        WHERE r.tripulacion.id = :idTripulacion
          AND r.esMiembroActual = true
    """)
    Long contarMiembrosActuales(@Param("idTripulacion") Long idTripulacion);
}