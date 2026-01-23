package com.adrian.colegio.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;

public interface MatriculacionRepository extends JpaRepository<MatriculacionEntity, Integer> {

    @Query("""
        SELECT new com.adrian.colegio.dtos.MatriculacionDTO(
            m.id,
            m.alumno.id,
            m.alumno.nombre,
            m.asignatura.id,
            m.asignatura.nombre,
            m.fecha,
            m.activo
        )
        FROM MatriculacionEntity m
        WHERE (:nombreAsignatura IS NULL OR m.asignatura.nombre LIKE %:nombreAsignatura%)
          AND (:nombreAlumno IS NULL OR m.alumno.nombre LIKE %:nombreAlumno%)
          AND (:fecha IS NULL OR m.fecha >= :fecha)
          AND (:activo IS NULL OR m.activo = :activo)
    """)
    List<MatriculacionDTO> buscarMatriculaciones(
        @Param("nombreAsignatura") String nombreAsignatura,
        @Param("nombreAlumno") String nombreAlumno,
        @Param("fecha") LocalDate fecha,
        @Param("activo") Integer activo
    );
}
