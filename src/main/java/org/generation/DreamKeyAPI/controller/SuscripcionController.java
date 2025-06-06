package org.generation.DreamKeyAPI.controller;

import java.time.LocalDate;
import java.util.List;

import org.generation.DreamKeyAPI.model.Suscripcion;
import org.generation.DreamKeyAPI.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/dreamkey/suscripciones")
public class SuscripcionController {
	
	private final SuscripcionService suscripcionService;

    @Autowired
    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

	
    @GetMapping
    public List<Suscripcion> getSuscripciones() {
        return suscripcionService.getSuscripciones();
    }

	
    @GetMapping(path="{susId}")
    public Suscripcion getSuscripcion(@PathVariable("susId") Long id) {
        return suscripcionService.getSuscripcion(id);
    }

    @DeleteMapping(path="{susId}")
    public Suscripcion deleteSuscripcion(@PathVariable("susId") Long id) {
        return suscripcionService.deleteSuscripcion(id);
    }
	
    @PostMapping
    public Suscripcion addSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.addSuscripcion(suscripcion);
    }
	
    @PutMapping(path="{susId}")
    public Suscripcion updateSuscripcion(
            @PathVariable("susId") Long id,
            @RequestParam(required=false) LocalDate fechaSuscripcion,
            @RequestParam(required=false) LocalDate fechaPagoSuscripcion,
            @RequestParam(required=false) Boolean suscripcionActiva
    ) {
        return suscripcionService.updateSuscripcion(id, fechaSuscripcion, fechaPagoSuscripcion, suscripcionActiva);
    }
    
    @PutMapping(path="{susId}/renovar")
    public Suscripcion renovarSuscripcion(@PathVariable("susId") Long id) {
        return suscripcionService.renovarSuscripcion(id);
    }

}

