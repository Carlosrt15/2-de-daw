package com.adrian.colegio.servicio.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IMatriculacionesDAO;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@Service
public class MatriculacionesServiceImpl implements IMatriculacionesService {

    @Autowired
    private IMatriculacionesDAO dao;

    @Override
    public List<MatriculacionDTO> buscarMatriculaciones(
            String nombreAsignatura,
            String nombreAlumno,
            LocalDate fecha,
            Integer activo) {

        return dao.buscarMatriculaciones(
            nombreAsignatura,
            nombreAlumno,
            fecha,
            activo
        );
    }

    @Override
    public int insertarMatriculacion(MatriculacionEntity m) {
        return dao.insertarMatriculacion(m);
    }

    @Override
    public int actualizarMatriculacion(MatriculacionEntity m) {
        return dao.actualizarMatriculacion(m);
    }

    @Override
    public int borrarMatriculacion(int id) {
        return dao.borrarMatriculacion(id);
    }
}
