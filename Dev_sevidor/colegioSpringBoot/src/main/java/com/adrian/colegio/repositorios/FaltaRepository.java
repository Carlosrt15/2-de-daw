package com.adrian.colegio.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.FaltaDTO;
import com.adrian.colegio.entities.FaltaEntity;

public interface FaltaRepository extends CrudRepository<FaltaEntity, Integer> {

    @Query("""
        SELECT new com.adrian.colegio.dtos.FaltaDTO(
            f.idFaltas,
            f.alumno.id,
            f.alumno.nombre,
            f.asignatura.nombre,
            f.fecha,
            f.justificada
        )
        FROM FaltaEntity f
        WHERE (:idAlumno IS NULL OR f.alumno.id = :idAlumno)
          AND (:fecha IS NULL OR f.fecha = :fecha)
    """)
    List<FaltaDTO> buscarFaltas(
        @Param("idAlumno") Integer idAlumno,
        @Param("fecha") LocalDate fecha
    );
}
