package org.generation.DreamKeyAPI.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.generation.DreamKeyAPI.model.Membresias;
import org.generation.DreamKeyAPI.repository.MembresiasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MembresiasService {

    private final MembresiasRepository membresiasRepository;

    @Autowired
    public MembresiasService(MembresiasRepository membresiasRepository) {
        this.membresiasRepository = membresiasRepository;
    }

    public List<Membresias> getMembresias() {
        return membresiasRepository.findAll();
    }

    public Membresias getMembresia(Long id) {
        return membresiasRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(
            		"La membresía con el id ["
            		+ id
            		+ "] no existe")
        );
    }

    public Membresias deleteMembresias(Long id) {
        Membresias tmp = null;
        if (membresiasRepository.existsById(id)) {
            tmp = membresiasRepository.findById(id).get(); 
            membresiasRepository.deleteById(id);
        }
        return tmp; // Retorna la membresía borrada o null si no se encontró
    }

    public Membresias addMembresias(Membresias membresia) {
        Optional<Membresias> user = membresiasRepository.findByNombre(membresia.getNombre());
        if (user.isEmpty()) {
            return membresiasRepository.save(membresia);
        } else {
            return null; // Indica que ya existe una membresía con ese nombre
        }
    }
@Transactional 
    public Membresias updateMembresias(
            Long id,
            String nombre,
            Double precio,
            String categoria,
            String imagen,
            String descripcion) {

        // Primero, verifica si la membresía existe
        Membresias mem = membresiasRepository.findById(id)
                          .orElseThrow(() -> 
                          new IllegalArgumentException("La membresía con el id ["
                          + id
                          + "] no existe para actualizar."));

        // Aplica las actualizaciones solo si los parámetros no son nulos y son diferentes
        if (nombre != null && !nombre.isEmpty() && !nombre.equals(mem.getNombre())) {
        	
            Optional<Membresias> existingMembresia = membresiasRepository.findByNombre(nombre);
            
            if (existingMembresia.isPresent() && !existingMembresia.get().getId().equals(id)) {
            	
                throw new IllegalStateException("Ya existe una membresía con el nombre: " + nombre);
            
            }
            
            mem.setNombre(nombre);
            
        }

        if (precio != null && precio >= 0 && !precio.equals(mem.getPrecio())) { // Agregado precio >= 0
            mem.setPrecio(precio);
        }

        if (categoria != null && !categoria.isEmpty() && !categoria.equals(mem.getCategoria())) {
            mem.setCategoria(categoria);
        }

        if (imagen != null && !imagen.isEmpty() && !imagen.equals(mem.getImagen())) {
            mem.setImagen(imagen);
        }

        if (descripcion != null && !descripcion.isEmpty() && !descripcion.equals(mem.getDescripcion())) {
            mem.setDescripcion(descripcion);
        }

        return mem;
    }
}	
