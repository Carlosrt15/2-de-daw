package com.rodriguez.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tripulacion")
public class Tripulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String barco;

    private Boolean estaActiva;

    @OneToMany(mappedBy = "tripulacion")
    private List<Reclutamiento> reclutamientos;

    // Campo calculado (NO existe en BD)
    @Transient
    private Long numeroMiembros;

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarco() {
        return barco;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }

    public Boolean getEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(Boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public List<Reclutamiento> getReclutamientos() {
        return reclutamientos;
    }

    public void setReclutamientos(List<Reclutamiento> reclutamientos) {
        this.reclutamientos = reclutamientos;
    }

    public Long getNumeroMiembros() {
        return numeroMiembros;
    }

    public void setNumeroMiembros(Long numeroMiembros) {
        this.numeroMiembros = numeroMiembros;
    }
}
