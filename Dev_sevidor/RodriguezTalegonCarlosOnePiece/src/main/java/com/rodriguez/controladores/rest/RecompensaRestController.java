package com.rodriguez.controladores.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodriguez.entities.Recompensa;
import com.rodriguez.repositories.RecompensaRepository;

@RestController
@RequestMapping("/v1/recompensas")
public class RecompensaRestController {

    private final RecompensaRepository recompensaRepository;

    public RecompensaRestController(RecompensaRepository recompensaRepository) {
        this.recompensaRepository = recompensaRepository;
    }

    @GetMapping
    public List<Recompensa> listar() {
        return recompensaRepository.findAll();
    }
}