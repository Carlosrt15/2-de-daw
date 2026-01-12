package com.adrian.colegio.servicio.interfaces;

import java.util.ArrayList;

import com.adrian.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasService {

    ArrayList<AsignaturaDTO> obtenerAsignaturas(
            Integer id, String nombre, Integer curso, Integer activo);

    int insertarAsignatura(int id, String nombre, int curso, double tasa, int activo);

    int actualizarAsignatura(int id, String nombre, int curso, double tasa, int activo);

    int borrarAsignatura(int id);
}
