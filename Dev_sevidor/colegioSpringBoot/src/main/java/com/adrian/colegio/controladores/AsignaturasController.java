package com.adrian.colegio.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.dtos.AsignaturaDTO;
import com.adrian.colegio.servicio.interfaces.IAsignaturasService;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturasController {

    @Autowired
    IAsignaturasService asignaturasService;

    @GetMapping("/listadoAsignaturas")
    public String formularioListado() {
        return "asignaturas/listadoAsignaturas";
    }

    @PostMapping("/listadoAsignaturas")
    public String listadoAsignaturas(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "curso", required = false) Integer curso,
            @RequestParam(value = "activo", required = false) Integer activo,
            ModelMap model) {

        int act = activo != null ? 1 : 0;

        ArrayList<AsignaturaDTO> lista =
                asignaturasService.obtenerAsignaturas(id, nombre, curso, act);

        model.addAttribute("lista", lista);
        return "asignaturas/listadoAsignaturas";
    }

    @PostMapping("/insertarAsignatura")
    public String insertarAsignatura(
            @RequestParam("id") int id,
            @RequestParam("nombre") String nombre,
            @RequestParam("curso") int curso,
            @RequestParam("tasa") double tasa,
            @RequestParam(value = "activo", required = false) Integer activo,
            ModelMap model) {

        int act = activo != null ? 1 : 0;
        int resultado = asignaturasService.insertarAsignatura(id, nombre, curso, tasa, act);
        model.addAttribute("resultado", resultado);

        return "asignaturas/insertarAsignatura";
    }

    @PostMapping("/borrarAsignatura")
    public String borrarAsignatura(@RequestParam("id") int id, ModelMap model) {
        int resultado = asignaturasService.borrarAsignatura(id);
        model.addAttribute("resultado", resultado);
        return "asignaturas/borrarAsignatura";
    }
}
