package com.rodriguez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodriguez.entities.Pirata;
import com.rodriguez.repositories.PirataRepository;

@Controller
@RequestMapping("/capturas")
public class CapturaController {

    @Autowired
    private PirataRepository pirataRepository;

    // FORMULARIO REGISTRAR CAPTURA
    @GetMapping("/registrarCaptura")
    public String registrarCaptura(Model model) {
        List<Pirata> piratasActivos = pirataRepository.findPiratasActivos();
        model.addAttribute("piratasActivos", piratasActivos);
        return "capturas/registrarCaptura";
    }

   
    @GetMapping("/listadoCapturas")
    public String listadoCapturas() {
        return "capturas/listadoCapturas";
    }


    @PostMapping("/listadoCapturas")
    public String listadoCapturasPost() {
        return "capturas/listadoCapturas";
    }
}
