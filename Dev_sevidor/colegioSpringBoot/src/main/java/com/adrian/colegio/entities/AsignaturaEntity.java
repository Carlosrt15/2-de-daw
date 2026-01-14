package com.adrian.colegio.entities;

import jakarta.persistence.Id;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class AsignaturaEntity {

    @Id
    private Integer id;

    private String nombre;
    private Integer curso;
    private Double tasa;
    private Integer activo;

    public AsignaturaEntity() {}

    public AsignaturaEntity(Integer id, String nombre, Integer curso, Double tasa, Integer activo) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.tasa = tasa;
        this.activo = activo;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

    
}
