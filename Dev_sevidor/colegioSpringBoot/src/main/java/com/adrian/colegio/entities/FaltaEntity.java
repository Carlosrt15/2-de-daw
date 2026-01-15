package com.adrian.colegio.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "faltas")
public class FaltaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfaltas")
    private int idFaltas;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "justificada")
    private int justificada;

    @ManyToOne
    @JoinColumn(name = "alumno")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "asignatura")
    private AsignaturaEntity asignatura;

    public FaltaEntity() {}

    public int getIdFaltas() {
        return idFaltas;
    }

    public void setIdFaltas(int idFaltas) {
        this.idFaltas = idFaltas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getJustificada() {
        return justificada;
    }

    public void setJustificada(int justificada) {
        this.justificada = justificada;
    }

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

    public AsignaturaEntity getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaEntity asignatura) {
        this.asignatura = asignatura;
    }
}
