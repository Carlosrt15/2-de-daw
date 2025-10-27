package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CartaService;

@Controller
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularIndice(@RequestParam String nombreCarta, Model model) {
        String resultado = cartaService.calcularIndice(nombreCarta);
        model.addAttribute("resultado", resultado);
        return "resultado";
    }
}