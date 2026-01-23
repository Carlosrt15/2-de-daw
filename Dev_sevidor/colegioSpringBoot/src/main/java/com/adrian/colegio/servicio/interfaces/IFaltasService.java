package com.adrian.colegio.servicio.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.adrian.colegio.dtos.FaltaDTO;
import com.adrian.colegio.entities.FaltaEntity;

public interface IFaltasService {

    List<FaltaDTO> obtenerFaltas(Integer idAlumno, LocalDate fecha);

    int insertarFalta(FaltaEntity falta);

    int borrarFalta(int idFalta);
}
