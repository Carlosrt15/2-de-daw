package com.example.demo.service;

import com.example.demo.repository.JugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

    private final JugadorRepository repo;

    public JugadorService(JugadorRepository repo) {
        this.repo = repo;
    }

    public int contarCartas(String nombre) {
        return repo.obtenerCartas(nombre).size();
    }
}
