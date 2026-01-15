package com.adrian.colegio.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.colegio.entities.AlumnoEntity;
import com.adrian.colegio.entities.AsignaturaEntity;
import com.adrian.colegio.entities.FaltaEntity;
import com.adrian.colegio.servicio.interfaces.IFaltasService;

@Controller
@RequestMapping("/faltas")
public class FaltasController {

    @Autowired
    IFaltasService faltasService;

    // ========= LISTAR =========
    @GetMapping("/listadoFaltas")
    public String formularioListado() {
        return "faltas/listadoFaltas";
    }

    @PostMapping("/listadoFaltas")
    public String listadoFaltas(
            @RequestParam(required = false) Integer idAlumno,
            @RequestParam(required = false) String fecha,
            Model model) {

        LocalDate f = (fecha == null || fecha.isEmpty()) ? null : LocalDate.parse(fecha);

        model.addAttribute(
            "lista",
            faltasService.obtenerFaltas(null, idAlumno, f)
        );

        return "faltas/listadoFaltas";
    }

    // ========= INSERTAR =========
    @GetMapping("/insertarFalta")
    public String formularioInsertar() {
        return "faltas/insertarFalta";
    }

    @PostMapping("/insertarFalta")
    public String insertarFalta(
            @RequestParam int alumno,
            @RequestParam int asignatura,
            @RequestParam String fecha,
            @RequestParam(required = false) Integer justificada,
            Model model) {

        FaltaEntity f = new FaltaEntity();
        f.setFecha(LocalDate.parse(fecha));
        f.setJustificada(justificada != null ? 1 : 0);

        AlumnoEntity a = new AlumnoEntity();
        a.setId(alumno);
        f.setAlumno(a);

        AsignaturaEntity as = new AsignaturaEntity();
        as.setId(asignatura);
        f.setAsignatura(as);

        model.addAttribute("resultado", faltasService.insertarFalta(f));
        return "faltas/insertarFalta";
    }

    // ========= BORRAR =========
    @GetMapping("/formularioBorrarFaltas")
    public String formularioBorrarFaltas(Model model) {
        model.addAttribute(
            "lista",
            faltasService.obtenerFaltas(null, null, null)
        );
        return "faltas/borrarFaltas";
    }

    @PostMapping("/borrarFalta")
    public String borrar(@RequestParam int idFalta, Model model) {
        model.addAttribute("resultado", faltasService.borrarFalta(idFalta));
        return "faltas/borrarFaltas";
    }

    // ========= MODIFICAR =========
    @GetMapping("/formularioActualizarFaltas")
    public String formularioActualizarFaltas() {
        return "faltas/actualizarFaltas";
    }

    @PostMapping("/actualizarFalta")
    public String actualizar(
            @RequestParam int idFalta,
            @RequestParam String fecha,
            @RequestParam(required = false) Integer justificada,
            Model model) {

        FaltaEntity f = new FaltaEntity();
        f.setIdFaltas(idFalta);
        f.setFecha(LocalDate.parse(fecha));
        f.setJustificada(justificada != null ? 1 : 0);

        model.addAttribute("resultado", faltasService.actualizarFalta(f));
        return "faltas/actualizarFaltas";
    }
}
