package com.rodriguez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rodriguez.entities.Reclutamiento;
import com.rodriguez.entities.Tripulacion;
import com.rodriguez.repositories.PirataRepository;
import com.rodriguez.repositories.ReclutamientoRepository;
import com.rodriguez.repositories.TripulacionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {

    private final TripulacionRepository tripulacionRepository;
    private final ReclutamientoRepository reclutamientoRepository;
    private final PirataRepository pirataRepository;

    public TripulacionController(
            TripulacionRepository tripulacionRepository,
            ReclutamientoRepository reclutamientoRepository,
            PirataRepository pirataRepository
    ) {
        this.tripulacionRepository = tripulacionRepository;
        this.reclutamientoRepository = reclutamientoRepository;
        this.pirataRepository = pirataRepository;
    }

    // =========================
    // INSERTAR TRIPULACIÓN
    // =========================
    @GetMapping("/insertarTripulacion")
    public String insertarTripulacion() {
        return "tripulaciones/insertarTripulacion";
    }

    @PostMapping("/insertarTripulacion")
    public String insertarTripulacionPost(
            @RequestParam String nombre,
            @RequestParam String barco,
            @RequestParam(required = false) Integer estaActiva,
            Model model
    ) {
        Tripulacion t = new Tripulacion();
        t.setNombre(nombre);
        t.setBarco(barco);
        t.setEstaActiva(estaActiva != null);

        Tripulacion guardada = tripulacionRepository.save(t);
        model.addAttribute("resultado", guardada.getId());
        return "tripulaciones/insertarTripulacion";
    }

    // =========================
    // LISTADO TRIPULACIONES
    // =========================
    @GetMapping("/listadoTripulaciones")
    public String listadoTripulaciones() {
        return "tripulaciones/listadoTripulaciones";
    }

    @PostMapping("/listadoTripulaciones")
    public String filtrarTripulaciones(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String barco,
            @RequestParam(required = false) Integer estaActiva,
            Model model
    ) {
        List<Tripulacion> lista = tripulacionRepository.buscarTripulaciones(
                nombre,
                barco,
                estaActiva != null
        );

        // Añadir número de miembros actuales
        lista.forEach(t -> {
            Long num = tripulacionRepository.contarMiembrosActuales(t.getId());
            t.setNumeroMiembros(num);
        });

        model.addAttribute("lista", lista);
        return "tripulaciones/listadoTripulaciones";
    }

    // =========================
    // DETALLES TRIPULACIÓN
   
    @GetMapping("/detallesTripulacion")
    public String detallesTripulacion(
            @RequestParam Long id,
            Model model
    ) {
        Tripulacion tripulacion = tripulacionRepository.findById(id).orElse(null);

        if (tripulacion == null) {
            return "redirect:/tripulaciones/listadoTripulaciones";
        }

        List<Reclutamiento> reclutamientos =
                reclutamientoRepository.findMiembrosActualesPorTripulacion(id);

        model.addAttribute("tripulacion", tripulacion);
        model.addAttribute("miembros", reclutamientos);
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());

        return "tripulaciones/detallesTripulacion";
    }

    
    // ELIMINAR MIEMBRO
    // =========================
    @PostMapping("/eliminarMiembro")
    public String eliminarMiembro(
            @RequestParam Integer idPirata,
            @RequestParam Long idTripulacion
    ) {
        reclutamientoRepository.desactivarReclutamientosDelPirata(idPirata);
        return "redirect:/tripulaciones/detallesTripulacion?id=" + idTripulacion;
    }

   
    // AGREGAR MIEMBRO
    // =========================
    @PostMapping("/agregarMiembro")
    public String agregarMiembro(
            @RequestParam Integer idPirata,
            @RequestParam Long idTripulacion,
            @RequestParam String rol
    ) {
        // Desactivar reclutamiento previo si existe
        reclutamientoRepository.desactivarReclutamientosDelPirata(idPirata);

        Reclutamiento r = new Reclutamiento();
        r.setPirata(pirataRepository.findById(idPirata).orElse(null));
        r.setTripulacion(tripulacionRepository.findById(idTripulacion).orElse(null));
        r.setRol(rol);
        r.setEsMiembroActual(true);

        reclutamientoRepository.save(r);

        return "redirect:/tripulaciones/detallesTripulacion?id=" + idTripulacion;
    }

    // =========================
    // FORMULARIO ACTUALIZAR
    
    @GetMapping("/formularioActualizarTripulaciones")
    public String formularioActualizarTripulaciones() {
    	return "tripulaciones/actualizarTripulaciones";

    }

    @PostMapping("/formularioActualizarTripulaciones")
    public String buscarActualizarTripulaciones(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer estaActiva,
            Model model
    ) {
        List<Tripulacion> lista = new ArrayList<>();

        if (id != null) {
            tripulacionRepository.findById(id).ifPresent(lista::add);
        } else {
            lista = tripulacionRepository.buscarTripulaciones(
                    nombre,
                    null,
                    estaActiva != null
            );
        }

        model.addAttribute("lista", lista);
        return "tripulaciones/actualizarTripulaciones";

    }

    @PostMapping("/actualizarTripulacion")
    public String actualizarTripulacion(
            @RequestParam Long id,
            @RequestParam String nombre,
            @RequestParam String barco,
            @RequestParam(required = false) Integer estaActiva,
            Model model
    ) {
        Tripulacion t = tripulacionRepository.findById(id).orElse(null);
        if (t != null) {
            t.setNombre(nombre);
            t.setBarco(barco);
            t.setEstaActiva(estaActiva != null);
            tripulacionRepository.save(t);
            model.addAttribute("resultado", id);
        }
        return "tripulaciones/actualizarTripulaciones";

    }

    
    @GetMapping("/formularioBorrarTripulaciones")
    public String formularioBorrarTripulaciones() {
    	return "tripulaciones/borrarTripulaciones";

    }

    @PostMapping("/formularioBorrarTripulaciones")
    public String buscarBorrarTripulaciones(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nombre,
            Model model
    ) {
        List<Tripulacion> lista = new ArrayList<>();

        if (id != null) {
            tripulacionRepository.findById(id).ifPresent(lista::add);
        } else {
            lista = tripulacionRepository.buscarTripulaciones(nombre, null, null);
        }

        model.addAttribute("lista", lista);
        return "tripulaciones/borrarTripulaciones";

    }

    @PostMapping("/borrarTripulacion")
    public String borrarTripulacion(
            @RequestParam Long id,
            Model model
    ) {
        Tripulacion t = tripulacionRepository.findById(id).orElse(null);
        if (t != null) {
            t.setEstaActiva(false);
            tripulacionRepository.save(t);
            model.addAttribute("resultado", id);
        }
        return "tripulaciones/borrarTripulaciones";

    }
}