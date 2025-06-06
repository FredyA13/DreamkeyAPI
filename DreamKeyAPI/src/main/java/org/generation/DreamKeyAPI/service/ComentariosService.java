package org.generation.DreamKeyAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.generation.DreamKeyAPI.model.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

	private final List<Comentarios> lista= new ArrayList<Comentarios>();
	
	
	@Autowired 
	public ComentariosService() {
		lista.add(new Comentarios("Primer Comentario"));
		lista.add(new Comentarios("Segundo Comentario"));
		lista.add(new Comentarios("Comentario"));
		lista.add(new Comentarios("Comentario"));
	}
	

	public List<Comentarios> getComentarios() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Comentarios getComentarios(Long id) {
		
		Comentarios tmp = null;
		
		for (Comentarios comentarios : lista) {
			if (comentarios.getId()==id) {
				tmp=comentarios;
				break;
			}
		}
		
		return tmp;
	}
	
	
	public Comentarios deleteComentarios(Long id) {
		// TODO Auto-generated method stub
		Comentarios tmp = null;
		for (Comentarios comentarios : lista) {
			if (comentarios.getId()==id) {
				tmp=comentarios;
				lista.remove(comentarios);
				break;
			}
		}
		
		return tmp;
	}

	public Comentarios addComentarios(Comentarios comentarios) {
		// TODO Auto-generated method stub
		lista.add(comentarios);
		return comentarios;
	}

	public Comentarios updateComentarios(
			
			Long id,
			String comentarioAux) 
		{
		// TODO Auto-generated method stub
		

		Comentarios tmp = null;
		
		for (Comentarios comentarios : lista) {
			
			if (comentarios.getId()==id) {
				if (comentarioAux!=null) {comentarios.setComentarios(comentarioAux);}
				tmp=comentarios;
				break;
				
			}
		}return tmp;
		
	}

}