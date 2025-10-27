package com.example.demo.service;

public class Carta {
    private String nombre;
    private double coste;
    private double dano;
    private double vida;

    public Carta(String nombre, double coste, double dano, double vida) {
        this.nombre = nombre;
        this.coste = coste;
        this.dano = dano;
        this.vida = vida;
    }

    public String getNombre() { return nombre; }
    public double getCoste() { return coste; }
    public double getDano() { return dano; }
    public double getVida() { return vida; }

    public double getIndiceFuerza() {
        return (dano * vida) / coste;
    }
}