package com.adrian.colegio.dtos;

import java.time.LocalDate;

public class FaltaDTO {

    private int idFalta;
    private int idAlumno;
    private String nombreAlumno;
    private String nombreAsignatura;
    private LocalDate fecha;
    private int justificada;

    public FaltaDTO(
            int idFalta,
            int idAlumno,
            String nombreAlumno,
            String nombreAsignatura,
            LocalDate fecha,
            int justificada) {

        this.idFalta = idFalta;
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.nombreAsignatura = nombreAsignatura;
        this.fecha = fecha;
        this.justificada = justificada;
    }

    public FaltaDTO() {}

	public int getIdFalta() {
		return idFalta;
	}

	public void setIdFalta(int idFalta) {
		this.idFalta = idFalta;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
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

    // getters y setters
	
}
