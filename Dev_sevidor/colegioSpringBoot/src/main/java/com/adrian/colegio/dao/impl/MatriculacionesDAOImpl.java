package com.adrian.colegio.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IMatriculacionesDAO;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;
import com.adrian.colegio.repositorios.MatriculacionRepository;

@Repository
public class MatriculacionesDAOImpl implements IMatriculacionesDAO {

    @Autowired
    private MatriculacionRepository repo;

    @Override
    public List<MatriculacionDTO> buscarMatriculaciones(
            String nombreAsignatura,
            String nombreAlumno,
            LocalDate fecha,
            Integer activo) {

        return repo.buscarMatriculaciones(
            nombreAsignatura,
            nombreAlumno,
            fecha,
            activo
        );
    }

    @Override
    public int insertarMatriculacion(MatriculacionEntity m) {
        repo.save(m);
        return 1;
    }

    @Override
    public int actualizarMatriculacion(MatriculacionEntity m) {
        repo.save(m);
        return 1;
    }

  
    @Override
    public int borrarMatriculacion(int id) {
        MatriculacionEntity m = repo.findById(id).orElse(null);
        if (m == null) return 0;
        m.setActivo(0);
        repo.save(m);
        return 1;
    }
}
