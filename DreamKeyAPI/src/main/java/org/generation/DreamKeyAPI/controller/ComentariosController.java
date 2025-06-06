package org.generation.DreamKeyAPI.controller;

import java.util.List;

import org.generation.DreamKeyAPI.model.Comentarios;
import org.generation.DreamKeyAPI.service.ComentariosService;
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
@RequestMapping(path="/api/dreamkey/comentarios")
public class ComentariosController {
	
	private final ComentariosService comentariosServices;

	@Autowired
	public ComentariosController(ComentariosService comentarioServices) {
		super();
		this.comentariosServices = comentarioServices;
	}
	
	

	@GetMapping
	public List<Comentarios> getComentarios(){
		return comentariosServices.getComentarios();
	}
	
	@GetMapping(path="{comId}")
	public Comentarios getMembresias(@PathVariable ("comId") Long id) {
		return comentariosServices.getComentarios(id);
	}
	
	@DeleteMapping(path="{comId}")
	public Comentarios deleComentarios(@PathVariable ("comId") Long id) {
		return comentariosServices.deleteComentarios(id);
	}
	
	@PostMapping
	public Comentarios adComentarios(@RequestBody Comentarios comentarios) {
		return comentariosServices.addComentarios(comentarios);
	}
	
	@PutMapping(path="{comId}")
	public Comentarios updateComentarios(@PathVariable ("comId") Long id,
			@RequestParam(required=false) String comentario_aux
			) {
		
		return comentariosServices.updateComentarios(id,comentario_aux);
		
	}




}

