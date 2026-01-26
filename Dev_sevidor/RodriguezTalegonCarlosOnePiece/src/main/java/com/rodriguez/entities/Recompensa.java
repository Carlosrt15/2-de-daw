package com.rodriguez.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "recompensa")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal cantidad;

    private Boolean estaVigente;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstaVigente() {
        return estaVigente;
    }

    public void setEstaVigente(Boolean estaVigente) {
        this.estaVigente = estaVigente;
    }

    public Pirata getPirata() {
        return pirata;
    }

    public void setPirata(Pirata pirata) {
        this.pirata = pirata;
    }
}