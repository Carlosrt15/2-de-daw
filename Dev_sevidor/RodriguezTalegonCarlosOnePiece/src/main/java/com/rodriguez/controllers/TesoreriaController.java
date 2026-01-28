package com.rodriguez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodriguez.repositories.TesoreriaMarinaRepository;

@Controller
@RequestMapping("/tesoreria")
public class TesoreriaController {

    private final TesoreriaMarinaRepository tesoreriaMarinaRepository;

    public TesoreriaController(TesoreriaMarinaRepository tesoreriaMarinaRepository) {
        this.tesoreriaMarinaRepository = tesoreriaMarinaRepository;
    }

    
    
    @GetMapping("/listadoOperaciones")
    public String listadoOperaciones(Model model) {
        model.addAttribute("lista", tesoreriaMarinaRepository.findAll());
        return "tesoreria/listadoOperaciones";
    }
}