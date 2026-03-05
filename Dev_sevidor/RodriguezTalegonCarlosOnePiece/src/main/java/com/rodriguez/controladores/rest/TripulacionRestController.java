package com.rodriguez.controladores.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodriguez.entities.Tripulacion;
import com.rodriguez.repositories.TripulacionRepository;

@RestController
@RequestMapping("/v1/tripulaciones")
public class TripulacionRestController {

    private final TripulacionRepository tripulacionRepository;

    public TripulacionRestController(TripulacionRepository tripulacionRepository) {
        this.tripulacionRepository = tripulacionRepository;
    }

    @GetMapping
    public List<Tripulacion> listar() {
        return tripulacionRepository.findAll();
    }
}