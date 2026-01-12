package com.adrian.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.adrian.colegio.dtos.AsignaturaDTO;

public interface AsignaturasRepository 
        extends CrudRepository<AsignaturaEntity, Integer> {

    @Query("""
        SELECT new com.adrian.colegio.dtos.AsignaturaDTO(
            a.id, a.nombre, a.curso, a.tasa, a.activo
        )
        FROM com.adrian.colegio.entities.AsignaturaEntity a
        WHERE (:id IS NULL OR a.id = :id)
        AND a.nombre LIKE CONCAT('%', :nombre, '%')
        AND (:curso IS NULL OR a.curso = :curso)
        AND a.activo = :activo
    """)
    ArrayList<AsignaturaDTO> buscarAsignaturas(
        @Param("id") Integer id,
        @Param("nombre") String nombre,
        @Param("curso") Integer curso,
        @Param("activo") Integer activo
    );
}
