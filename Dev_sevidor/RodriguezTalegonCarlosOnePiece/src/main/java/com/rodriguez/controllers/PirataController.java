package com.rodriguez.controllers;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rodriguez.entities.Pirata;
import com.rodriguez.repositories.IslaRepository;
import com.rodriguez.repositories.PirataRepository;
import com.rodriguez.repositories.ReclutamientoRepository;

@Controller
@RequestMapping("/piratas")
public class PirataController {

    private final PirataRepository pirataRepository;
    private final IslaRepository islaRepository;
    private final ReclutamientoRepository reclutamientoRepository;

    public PirataController(
            PirataRepository pirataRepository,
            IslaRepository islaRepository,
            ReclutamientoRepository reclutamientoRepository
    ) {
        this.pirataRepository = pirataRepository;
        this.islaRepository = islaRepository;
        this.reclutamientoRepository = reclutamientoRepository;
    }

    // INSERTAR
    @GetMapping("/insertarPirata")
    public String mostrarInsertarPirata(Model model) {
        model.addAttribute("desplegableIslas", islaRepository.findAll());
        return "piratas/insertarPirata";
    }

    @PostMapping("/insertarPirata")
    public String insertarPirata(
            @RequestParam String nombre,
            @RequestParam(required = false) String frutaDiablo,
            @RequestParam String fechaNacimiento,
            @RequestParam Integer islas,
            @RequestParam(required = false) Integer activo,
            Model model
    ) {
        Pirata p = new Pirata();
        p.setNombre(nombre);
        p.setFrutaDelDiablo(frutaDiablo != null && frutaDiablo.isBlank() ? null : frutaDiablo);
        p.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        p.setIsla(islaRepository.findById(islas).orElse(null));
        p.setEstaActivo(activo != null);

        pirataRepository.save(p);
        model.addAttribute("resultado", p.getId());
        model.addAttribute("desplegableIslas", islaRepository.findAll());
        return "piratas/insertarPirata";
    }

    // LISTADO
    @GetMapping("/listadoPiratas")
    public String listadoPiratas() {
        return "piratas/listadoPiratas";
    }

    @PostMapping("/listadoPiratas")
    public String filtrarPiratas(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String frutaDiablo,
            @RequestParam(required = false) Integer activo,
            Model model
    ) {
        model.addAttribute("lista",
                pirataRepository.buscarPiratas(id, nombre, frutaDiablo, activo != null));
        return "piratas/listadoPiratas";
    }

    // ACTUALIZAR
    @GetMapping("/formularioActualizarPiratas")
    public String formularioActualizarPiratas() {
        return "piratas/actualizarPiratas";
    }

    @PostMapping("/formularioActualizarPiratas")
    public String buscarActualizar(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String frutaDiablo,
            @RequestParam(required = false) Integer activo,
            Model model
    ) {
        model.addAttribute("lista",
                pirataRepository.buscarPiratas(id, nombre, frutaDiablo, activo != null));
        model.addAttribute("desplegableIslas", islaRepository.findAll());
        return "piratas/actualizarPiratas";
    }

    @PostMapping("/actualizarPirata")
    public String actualizarPirata(
            @RequestParam Integer id,
            @RequestParam String nombre,
            @RequestParam(required = false) String frutaDiablo,
            @RequestParam String fechaNacimiento,
            @RequestParam Integer isla,
            @RequestParam(required = false) Integer activo,
            Model model
    ) {
        Pirata p = pirataRepository.findById(id).orElse(null);
        if (p != null) {
            p.setNombre(nombre);
            p.setFrutaDelDiablo(frutaDiablo != null && frutaDiablo.isBlank() ? null : frutaDiablo);
            p.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
            p.setIsla(islaRepository.findById(isla).orElse(null));
            p.setEstaActivo(activo != null);
            pirataRepository.save(p);
            model.addAttribute("resultado", id);
        }
        model.addAttribute("desplegableIslas", islaRepository.findAll());
        return "piratas/actualizarPiratas";
    }

    // BORRAR
    @GetMapping("/formularioBorrarPiratas")
    public String formularioBorrarPiratas() {
        return "piratas/borrarPiratas";
    }

    @PostMapping("/formularioBorrarPiratas")
    public String buscarBorrar(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            Model model
    ) {
        model.addAttribute("lista",
                pirataRepository.buscarPiratas(id, nombre, null, null));
        return "piratas/borrarPiratas";
    }

    @PostMapping("/borrarPirata")
    public String borrarPirata(@RequestParam Integer id, Model model) {
        Pirata p = pirataRepository.findById(id).orElse(null);
        if (p != null) {
            p.setEstaActivo(false);
            pirataRepository.save(p);
            reclutamientoRepository.desactivarReclutamientosDelPirata(id);
            model.addAttribute("resultado", id);
        }
        return "piratas/borrarPiratas";
    }
}
