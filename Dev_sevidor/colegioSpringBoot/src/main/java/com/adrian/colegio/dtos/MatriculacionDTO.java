package com.adrian.colegio.dtos;

import java.time.LocalDate;

public class MatriculacionDTO {

    private Integer id;
    private Integer idAlumno;
    private String nombreAlumno;
    private Integer idAsignatura;
    private String nombreAsignatura;
    private LocalDate fecha;
    private Integer activo;

    public MatriculacionDTO(
            Integer id,
            Integer idAlumno,
            String nombreAlumno,
            Integer idAsignatura,
            String nombreAsignatura,
            LocalDate fecha,
            Integer activo) {

        this.id = id;
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.fecha = fecha;
        this.activo = activo;
    }

    public Integer getId() { return id; }
    public Integer getIdAlumno() { return idAlumno; }
    public String getNombreAlumno() { return nombreAlumno; }
    public Integer getIdAsignatura() { return idAsignatura; }
    public String getNombreAsignatura() { return nombreAsignatura; }
    public LocalDate getFecha() { return fecha; }
    public Integer getActivo() { return activo; }
}
