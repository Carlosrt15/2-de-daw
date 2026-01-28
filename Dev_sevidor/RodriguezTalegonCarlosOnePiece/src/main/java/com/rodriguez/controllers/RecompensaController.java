package com.rodriguez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rodriguez.entities.Pirata;
import com.rodriguez.entities.Recompensa;
import com.rodriguez.entities.TesoreriaMarina;
import com.rodriguez.repositories.PirataRepository;
import com.rodriguez.repositories.ReclutamientoRepository;
import com.rodriguez.repositories.RecompensaRepository;
import com.rodriguez.repositories.TesoreriaMarinaRepository;
import com.rodriguez.repositories.TripulacionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/recompensas")
public class RecompensaController {

    private final RecompensaRepository recompensaRepository;
    private final PirataRepository pirataRepository;
    private final TesoreriaMarinaRepository tesoreriaMarinaRepository;
    private final ReclutamientoRepository reclutamientoRepository;
    private final TripulacionRepository tripulacionRepository;

    public RecompensaController(
            RecompensaRepository recompensaRepository,
            PirataRepository pirataRepository,
            TesoreriaMarinaRepository tesoreriaMarinaRepository,
            ReclutamientoRepository reclutamientoRepository,
            TripulacionRepository tripulacionRepository
    ) {
        this.recompensaRepository = recompensaRepository;
        this.pirataRepository = pirataRepository;
        this.tesoreriaMarinaRepository = tesoreriaMarinaRepository;
        this.reclutamientoRepository = reclutamientoRepository;
        this.tripulacionRepository = tripulacionRepository;
    }

    
    @GetMapping("/emitirRecompensa")
    public String emitirRecompensa(Model model) {
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
        return "recompensas/emitirRecompensa";
    }

    @PostMapping("/emitirRecompensa")
    @Transactional
    public String emitirRecompensaPost(
            @RequestParam Integer idPirata,
            @RequestParam BigDecimal cantidad,
            Model model
    ) {
        if (cantidad.compareTo(BigDecimal.ZERO) <= 0) {
            model.addAttribute("error", "La cantidad debe ser mayor que 0");
            model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
            return "recompensas/emitirRecompensa";
        }

        Pirata pirata = pirataRepository.findById(idPirata).orElse(null);
        if (pirata == null) {
            model.addAttribute("error", "Pirata no encontrado");
            model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
            return "recompensas/emitirRecompensa";
        }

        
        recompensaRepository.desactivarRecompensasVigentes(idPirata);

        // Crear nueva recompensa
        Recompensa recompensa = new Recompensa();
        recompensa.setPirata(pirata);
        recompensa.setCantidad(cantidad);
        recompensa.setEstaVigente(true);
        recompensaRepository.save(recompensa);

        
        TesoreriaMarina tm = new TesoreriaMarina();
        tm.setTipoOperacion("EMISION RECOMPENSA");
        tm.setImporte(BigDecimal.valueOf(-10000));
        tm.setFechaTransaccion(LocalDateTime.now());
        tesoreriaMarinaRepository.save(tm);

        model.addAttribute("resultado", recompensa.getId());
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
        return "recompensas/emitirRecompensa";
    }

  
    @GetMapping("/listadoRecompensas")
    public String listadoRecompensas(Model model) {
        model.addAttribute("tripulacionesActivas",
                tripulacionRepository.buscarTripulaciones(null, null, true));
        return "recompensas/listadoRecompensas";
    }

    @PostMapping("/listadoRecompensas")
    public String filtrarRecompensas(
            @RequestParam(required = false) String nombrePirata,
            @RequestParam(required = false) Long idTripulacion,
            @RequestParam(required = false) BigDecimal cantidad,
            @RequestParam(required = false) Integer estaVigente,
            Model model
    ) {
        List<Recompensa> lista = recompensaRepository.findAll();

      
        lista.removeIf(r -> nombrePirata != null && !r.getPirata().getNombre().toLowerCase().contains(nombrePirata.toLowerCase()));
        lista.removeIf(r -> cantidad != null && r.getCantidad().compareTo(cantidad) < 0);
        lista.removeIf(r -> estaVigente != null && !r.getEstaVigente());
        lista.removeIf(r -> idTripulacion != null &&
                reclutamientoRepository.findReclutamientoActivoPorPirata(r.getPirata().getId()) != null &&
                !reclutamientoRepository.findReclutamientoActivoPorPirata(r.getPirata().getId())
                        .getTripulacion().getId().equals(idTripulacion)
        );

        model.addAttribute("lista", lista);
        model.addAttribute("tripulacionesActivas",
                tripulacionRepository.buscarTripulaciones(null, null, true));
        return "recompensas/listadoRecompensas";
    }

   
    @GetMapping("/formularioActualizarRecompensas")
    public String formularioActualizarRecompensas(Model model) {
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
        return "recompensas/actualizarRecompensas";

    }

    @PostMapping("/formularioActualizarRecompensas")
    public String buscarActualizarRecompensas(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombrePirata,
            @RequestParam(required = false) Integer estaVigente,
            Model model
    ) {
        List<Recompensa> lista = recompensaRepository.findAll();

        lista.removeIf(r -> id != null && !r.getId().equals(id));
        lista.removeIf(r -> nombrePirata != null &&
                !r.getPirata().getNombre().toLowerCase().contains(nombrePirata.toLowerCase()));
        lista.removeIf(r -> estaVigente != null && !r.getEstaVigente());

        model.addAttribute("lista", lista);
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
        return "recompensas/actualizarRecompensas";

    }

    @PostMapping("/actualizarRecompensa")
    public String actualizarRecompensa(
            @RequestParam Integer id,
            @RequestParam Integer idPirata,
            @RequestParam BigDecimal cantidad,
            @RequestParam(required = false) Integer estaVigente,
            Model model
    ) {
        Recompensa r = recompensaRepository.findById(id).orElse(null);
        if (r != null) {
            r.setPirata(pirataRepository.findById(idPirata).orElse(null));
            r.setCantidad(cantidad);
            r.setEstaVigente(estaVigente != null);
            recompensaRepository.save(r);
            model.addAttribute("resultado", id);
        }
        model.addAttribute("piratasActivos", pirataRepository.findPiratasActivos());
        return "recompensas/actualizarRecompensas";

    }

   
    @GetMapping("/formularioBorrarRecompensas")
    public String formularioBorrarRecompensas() {
    	return "recompensas/borrarRecompensas";

    }

    @PostMapping("/formularioBorrarRecompensas")
    public String buscarBorrarRecompensas(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombrePirata,
            Model model
    ) {
        List<Recompensa> lista = recompensaRepository.findAll();

        lista.removeIf(r -> id != null && !r.getId().equals(id));
        lista.removeIf(r -> nombrePirata != null &&
                !r.getPirata().getNombre().toLowerCase().contains(nombrePirata.toLowerCase()));

        model.addAttribute("lista", lista);
        return "recompensas/borrarRecompensas";

    }

    @PostMapping("/borrarRecompensa")
    public String borrarRecompensa(
            @RequestParam Integer id,
            Model model
    ) {
        recompensaRepository.eliminarRecompensa(id);
        model.addAttribute("resultado", id);
        return "recompensas/borrarRecompensas";

    }
}