package com.rodriguez.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reclutamiento")
public class Reclutamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rol;

    private Boolean esMiembroActual;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private Tripulacion tripulacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEsMiembroActual() {
        return esMiembroActual;
    }

    public void setEsMiembroActual(Boolean esMiembroActual) {
        this.esMiembroActual = esMiembroActual;
    }

    public Pirata getPirata() {
        return pirata;
    }

    public void setPirata(Pirata pirata) {
        this.pirata = pirata;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }
}