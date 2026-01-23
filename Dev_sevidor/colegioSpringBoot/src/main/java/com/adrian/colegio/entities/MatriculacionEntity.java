package com.adrian.colegio.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private AsignaturaEntity asignatura;

    private LocalDate fecha;
    private Integer activo;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public AlumnoEntity getAlumno() { return alumno; }
    public void setAlumno(AlumnoEntity alumno) { this.alumno = alumno; }

    public AsignaturaEntity getAsignatura() { return asignatura; }
    public void setAsignatura(AsignaturaEntity asignatura) { this.asignatura = asignatura; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Integer getActivo() { return activo; }
    public void setActivo(Integer activo) { this.activo = activo; }
}
