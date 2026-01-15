package com.adrian.colegio.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.adrian.colegio.dtos.FaltaDTO;
import com.adrian.colegio.entities.FaltaEntity;

public interface IFaltasDAO {

    List<FaltaDTO> obtenerFaltas(Integer id, Integer idAlumno, LocalDate fecha);

    int insertarFalta(FaltaEntity falta);

    int borrarFalta(int id);

    int actualizarFalta(FaltaEntity falta);
}
