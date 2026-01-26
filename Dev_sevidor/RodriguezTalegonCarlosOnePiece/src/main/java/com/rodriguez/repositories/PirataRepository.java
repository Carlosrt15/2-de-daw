package com.rodriguez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rodriguez.entities.Pirata;

import java.util.List;

public interface PirataRepository extends JpaRepository<Pirata, Integer> {

    @Query("""
        SELECT p FROM Pirata p
        WHERE (:id IS NULL OR p.id = :id)
          AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
          AND (:fruta IS NULL OR LOWER(p.frutaDelDiablo) LIKE LOWER(CONCAT('%', :fruta, '%')))
          AND (:activo IS NULL OR p.estaActivo = :activo)
    """)
    List<Pirata> buscarPiratas(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("fruta") String fruta,
            @Param("activo") Boolean activo
    );

    @Query("""
        SELECT p FROM Pirata p
        WHERE p.estaActivo = true
    """)
    List<Pirata> findPiratasActivos();
}
