package com.adrian.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IAsignaturasDAO;
import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.repositorios.AsignaturasRepository;

@Repository
public class AsignaturasDAOImpl implements IAsignaturasDAO {

    @Autowired
    AsignaturasRepository asignaturasRepository;

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturas(Integer id, String nombre, Integer curso, Integer activo) {
        return asignaturasRepository.buscarAsignaturas(id, nombre, curso, activo);
    }

    @Override
    public int insertarAsignatura(int id, String nombre, int curso, double tasa, int activo) {
        AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa, activo);
        asignaturasRepository.save(asignatura);
        return asignatura.getId();
    }

    @Override
    public int actualizarAsignatura(int id, String nombre, int curso, double tasa, int activo) {
        AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa, activo);
        asignaturasRepository.save(asignatura);
        return asignatura.getId();
    }

    @Override
    public int borrarAsignatura(int id) {
        AsignaturaEntity asignatura = asignaturasRepository.findById(id).get();
        asignatura.setActivo(0); // BORRADO LÓGICO
        asignaturasRepository.save(asignatura);
        return asignatura.getId();
    }
}
