package com.adrian.colegio.servicio.interfaces;

import java.time.LocalDate;
import java.util.List;
import com.adrian.colegio.dtos.MatriculacionDTO;
import com.adrian.colegio.entities.MatriculacionEntity;

public interface IMatriculacionesService {

    List<MatriculacionDTO> buscarMatriculaciones(
        String nombreAsignatura,
        String nombreAlumno,
        LocalDate fecha,
        Integer activo
    );

    int insertarMatriculacion(MatriculacionEntity m);
    int actualizarMatriculacion(MatriculacionEntity m);
    int borrarMatriculacion(int id);
}
