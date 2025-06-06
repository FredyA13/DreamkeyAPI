package org.generation.DreamKeyAPI.service;

import java.time.LocalDate;
import java.util.List;

import org.generation.DreamKeyAPI.model.Suscripcion;
import org.generation.DreamKeyAPI.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;

    @Autowired
    public SuscripcionService(SuscripcionRepository suscripcionRepository) {
        this.suscripcionRepository = suscripcionRepository;
    }

    public List<Suscripcion> getSuscripciones() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion getSuscripcion(Long id) {
        return suscripcionRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("La suscripción con el id [" + id + "] no existe.")
        );
    }

    public Suscripcion deleteSuscripcion(Long id) {
        Suscripcion tmp = null;
        if (suscripcionRepository.existsById(id)) {
            tmp = suscripcionRepository.findById(id).get();
            suscripcionRepository.deleteById(id);
        }
        return tmp;
    }

    public Suscripcion addSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion updateSuscripcion(Long id, LocalDate fechaSuscripcion, LocalDate fechaPagoSuscripcion, Boolean suscripcionActiva) {
        Suscripcion tmp = null;
        if (suscripcionRepository.existsById(id)) {
            Suscripcion suscripcion = suscripcionRepository.findById(id).get();
            if (fechaSuscripcion != null) suscripcion.setFechaSuscripcion(fechaSuscripcion);
            if (fechaPagoSuscripcion != null) suscripcion.setFechaPagoSuscripcion(fechaPagoSuscripcion);
            if (suscripcionActiva != null) suscripcion.setSuscripcionActiva(suscripcionActiva);
            suscripcionRepository.save(suscripcion);
            tmp = suscripcion;
        }
        return tmp;
    }

    public Suscripcion renovarSuscripcion(Long id) {
        Suscripcion tmp = getSuscripcion(id);
        if (tmp != null) {
            tmp.renovarSuscripcion();
            suscripcionRepository.save(tmp);
        }
        return tmp;
    }
}

