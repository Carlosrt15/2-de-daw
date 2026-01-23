package com.adrian.colegio.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.adrian.colegio.entities.*;
import com.adrian.colegio.servicio.interfaces.IMatriculacionesService;

@Controller
@RequestMapping("/matriculaciones")
public class MatriculacionesController {

    @Autowired
    private IMatriculacionesService service;

    // LISTADO
    @GetMapping("/listadoMatriculaciones")
    public String verListado() {
        return "matriculaciones/listadoMatriculaciones";
    }

    @PostMapping("/listadoMatriculaciones")
    public String listar(
            @RequestParam(required = false) String nombreAsignatura,
            @RequestParam(required = false) String nombreAlumno,
            @RequestParam(required = false) String fecha,
            @RequestParam(required = false) Integer activo,
            Model model) {

        LocalDate f = (fecha == null || fecha.isEmpty()) ? null : LocalDate.parse(fecha);

        model.addAttribute("lista",
            service.buscarMatriculaciones(
                nombreAsignatura,
                nombreAlumno,
                f,
                activo
            )
        );

        return "matriculaciones/listadoMatriculaciones";
    }

    // INSERTAR
    @GetMapping("/insertarMatriculacion")
    public String verInsertar() {
        return "matriculaciones/insertarMatriculacion";
    }

    @PostMapping("/insertarMatriculacion")
    public String insertar(
            @RequestParam int alumno,
            @RequestParam int asignatura,
            @RequestParam(required = false) String fecha,
            Model model) {

        MatriculacionEntity m = new MatriculacionEntity();
        m.setActivo(1);
        m.setFecha((fecha == null || fecha.isEmpty()) ? LocalDate.now() : LocalDate.parse(fecha));

        AlumnoEntity a = new AlumnoEntity();
        a.setId(alumno);
        m.setAlumno(a);

        AsignaturaEntity as = new AsignaturaEntity();
        as.setId(asignatura);
        m.setAsignatura(as);

        model.addAttribute("resultado", service.insertarMatriculacion(m));
        return "matriculaciones/insertarMatriculacion";
    }

    // BORRAR (DESACTIVAR)
    @GetMapping("/borrarMatriculaciones")
    public String verBorrar(Model model) {
        model.addAttribute("lista",
            service.buscarMatriculaciones(null, null, null, 1)
        );
        return "matriculaciones/borrarMatriculaciones";
    }

    @PostMapping("/borrarMatriculacion")
    public String borrar(@RequestParam int id, Model model) {
        model.addAttribute("resultado", service.borrarMatriculacion(id));
        model.addAttribute("lista",
            service.buscarMatriculaciones(null, null, null, 1)
        );
        return "matriculaciones/borrarMatriculaciones";
    }
}
