package com.rodriguez.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pirata")
public class Pirata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String frutaDelDiablo;

    private LocalDate fechaNacimiento;

    private Boolean estaActivo;

    @ManyToOne
    @JoinColumn(name = "isla_id")
    private Isla isla;

    @OneToMany(mappedBy = "pirata")
    private List<Reclutamiento> reclutamientos;

    @OneToMany(mappedBy = "pirata")
    private List<Recompensa> recompensas;

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

    public String getFrutaDelDiablo() {
        return frutaDelDiablo;
    }

    public void setFrutaDelDiablo(String frutaDelDiablo) {
        this.frutaDelDiablo = frutaDelDiablo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public Isla getIsla() {
        return isla;
    }

    public void setIsla(Isla isla) {
        this.isla = isla;
    }

    public List<Reclutamiento> getReclutamientos() {
        return reclutamientos;
    }

    public void setReclutamientos(List<Reclutamiento> reclutamientos) {
        this.reclutamientos = reclutamientos;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(List<Recompensa> recompensas) {
        this.recompensas = recompensas;
    }
}