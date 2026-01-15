package com.adrian.colegio.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adrian.colegio.dao.interfaces.IFaltasDAO;
import com.adrian.colegio.dtos.FaltaDTO;
import com.adrian.colegio.entities.FaltaEntity;
import com.adrian.colegio.repositorios.FaltaRepository;

@Repository
public class FaltasDAOImpl implements IFaltasDAO {

    @Autowired
    private FaltaRepository faltaRepository;

    @Override
    public List<FaltaDTO> obtenerFaltas(Integer id, Integer idAlumno, LocalDate fecha) {
        return faltaRepository.buscarFaltas(id, idAlumno, fecha);
    }

    @Override
    public int insertarFalta(FaltaEntity falta) {
        faltaRepository.save(falta);
        return 1;
    }

    @Override
    public int borrarFalta(int id) {
        faltaRepository.deleteById(id);
        return 1;
    }

    @Override
    public int actualizarFalta(FaltaEntity falta) {
        faltaRepository.save(falta);
        return 1;
    }
}
