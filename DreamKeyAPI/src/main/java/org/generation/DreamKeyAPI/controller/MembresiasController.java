package org.generation.DreamKeyAPI.controller;

import java.util.List;

import org.generation.DreamKeyAPI.model.Membresias;
import org.generation.DreamKeyAPI.service.MembresiasService;
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
@RequestMapping(path="/api/dreamkey/membresias")
public class MembresiasController {
	
	private final MembresiasService membresiasServices;

	@Autowired
	public MembresiasController(MembresiasService membresiasServices) {
		super();
		this.membresiasServices = membresiasServices;
	}
	

	@GetMapping
	public List<Membresias> getMembresias(){
		return membresiasServices.getMembresias();
	}
	
	@GetMapping(path="{memId}")
	public Membresias getMembresias(@PathVariable ("memId") Long id) {
		return membresiasServices.getMembresia(id);
	}
	
	@DeleteMapping(path="{memId}")
	public Membresias deleteMembresias(@PathVariable ("memId") Long id) {
		return membresiasServices.deleteMembresias(id);
	}
	
	@PostMapping
	public Membresias addMembresias(@RequestBody Membresias membresia) {
		return membresiasServices.addMembresias(membresia);
	}
	
	@PutMapping(path="{memId}")
	public Membresias updateMembresia(@PathVariable ("memId") Long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) Double precio,
			@RequestParam(required=false) String categoria,
			@RequestParam(required=false) String imagen,
			@RequestParam(required=false) String descripcion
			) {
		
		return membresiasServices.updateMembresias(id,nombre,precio,categoria,imagen,descripcion);
	}
}
