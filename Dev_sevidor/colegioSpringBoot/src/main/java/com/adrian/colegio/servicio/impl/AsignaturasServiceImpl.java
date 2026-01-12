package com.adrian.colegio.servicio.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IAsignaturasDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

@Service
public class AsignaturasServiceImpl implements IAsignaturasService {

    @Autowired
    IAsignaturasDAO asignaturasDAO;

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturas(
            Integer id, String nombre, Integer curso, Integer activo) {

        return asignaturasDAO.obtenerAsignaturas(id, nombre, curso, activo);
    }

    @Override
    public int insertarAsignatura(int id, String nombre, int curso, double tasa, int activo) {
        return asignaturasDAO.insertarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int actualizarAsignatura(int id, String nombre, int curso, double tasa, int activo) {
        return asignaturasDAO.actualizarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int borrarAsignatura(int id) {
        return asignaturasDAO.borrarAsignatura(id);
    }
}
