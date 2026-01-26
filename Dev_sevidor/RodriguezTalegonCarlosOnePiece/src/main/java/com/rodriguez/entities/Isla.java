package com.rodriguez.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "isla")
public class Isla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "isla")
    private List<Pirata> piratas;

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

    public List<Pirata> getPiratas() {
        return piratas;
    }

    public void setPiratas(List<Pirata> piratas) {
        this.piratas = piratas;
    }
}
