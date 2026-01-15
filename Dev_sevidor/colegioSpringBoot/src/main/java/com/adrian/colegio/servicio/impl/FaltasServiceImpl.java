package com.adrian.colegio.servicio.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.colegio.dao.interfaces.IFaltasDAO;
import com.adrian.colegio.dtos.FaltaDTO;
import com.adrian.colegio.entities.FaltaEntity;
import com.adrian.colegio.servicio.interfaces.IFaltasService;

@Service
public class FaltasServiceImpl implements IFaltasService {

    @Autowired
    private IFaltasDAO faltasDAO;

    @Override
    public List<FaltaDTO> obtenerFaltas(Integer id, Integer idAlumno, LocalDate fecha) {
        return faltasDAO.obtenerFaltas(id, idAlumno, fecha);
    }

    @Override
    public int insertarFalta(FaltaEntity falta) {
        return faltasDAO.insertarFalta(falta);
    }

    @Override
    public int borrarFalta(int id) {
        return faltasDAO.borrarFalta(id);
    }

    @Override
    public int actualizarFalta(FaltaEntity falta) {
        return faltasDAO.actualizarFalta(falta);
    }
}
