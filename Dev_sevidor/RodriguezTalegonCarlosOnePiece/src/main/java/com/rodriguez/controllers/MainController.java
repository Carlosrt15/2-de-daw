package com.rodriguez.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    // Página de login personalizada
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Página principal tras login
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails userDetails,
                       Model model) {

        if (userDetails != null) {
            model.addAttribute("usuario", userDetails.getUsername());
            model.addAttribute("rol",
                    userDetails.getAuthorities().iterator().next().getAuthority());
        }

        return "index";
    }

    // Página acceso denegado
    @GetMapping("/accesoDenegado")
    public String accesoDenegado() {
        return "accesoDenegado";
    }
}