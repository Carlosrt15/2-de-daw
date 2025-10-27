package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.JugadorService;

@Controller
public class JugadorController {

    private final JugadorService service;
    public JugadorController(JugadorService service) { this.service = service; }

    @GetMapping("/")
    public String index() { return "index"; }

    @PostMapping("/resultado")
    public String resultado(@RequestParam String nombre, Model model) {
        int cantidad = service.contarCartas(nombre);
        model.addAttribute("mensaje", "El jugador " + nombre + " tiene " + cantidad + " cartas");
        return "resultado";
    }
}
