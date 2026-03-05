package com.rodriguez.controladores.rest;

import com.rodriguez.entities.Pirata;
import com.rodriguez.repositories.PirataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/piratas")
public class PirataRestController {

    private final PirataRepository pirataRepository;

    public PirataRestController(PirataRepository pirataRepository) {
        this.pirataRepository = pirataRepository;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Pirata> listarPiratas() {
        return pirataRepository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Pirata buscarPorId(@PathVariable Integer id) {
        return pirataRepository.findById(id).orElse(null);
    }
}