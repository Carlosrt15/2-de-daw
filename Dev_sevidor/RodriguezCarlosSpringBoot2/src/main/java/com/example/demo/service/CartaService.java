package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CartaRepository;

@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    public String calcularIndice(String nombreCarta) {
        return cartaRepository.buscarPorNombre(nombreCarta)
                .map(carta -> String.format(
                        "La carta %s tiene un índice de fuerza de %.0f",
                        carta.getNombre(), carta.getIndiceFuerza()))
                .orElse("No se encontró la carta con ese nombre.");
    }
}
