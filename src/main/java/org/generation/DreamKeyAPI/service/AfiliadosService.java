package org.generation.DreamKeyAPI.service;

import java.util.List;
import java.util.Optional;

import org.generation.DreamKeyAPI.model.Afiliados;
import org.generation.DreamKeyAPI.repository.AfiliadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliadosService {

	private final AfiliadosRepository afiliadosRepository;
	
	@Autowired 
	public AfiliadosService(AfiliadosRepository afiliadosRepository) {
		this.afiliadosRepository = afiliadosRepository;
	}//contructor 
	
	public List<Afiliados> getAfiliados() {
		return afiliadosRepository.findAll();
	}//getAfiliados

	public Afiliados getAfiliado(Long id) {
		return afiliadosRepository.findById(id).orElseThrow(
	()-> new IllegalArgumentException("El afiliado con el id[ " + id
			+ " ] no existe.")
				);
	}//getAfiliados
	
	public Afiliados deleteAfiliado(Long id) {
		Afiliados tmp = null;
		if(afiliadosRepository.existsById(id)) {
			tmp = afiliadosRepository.findById(id).get();
			afiliadosRepository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteAfiliados

	public Afiliados addAfiliados(Afiliados afiliados) {
		Optional<Afiliados> afil = afiliadosRepository.findByNombre(afiliados.getNombre());
		if(afil.isEmpty()) {
			afiliadosRepository.save(afiliados);
		}else {
			afiliados = null; //afil.get();
		}
		return afiliados;
	}//addAfiliados

	public Afiliados updateAfiliados(
			Long id,
			String nombre,
			String img,
			String descripcion,
			Double raiting, 
			String detalles,
			String servicio1,
			String servicio2,
			String servicio3,
			String img1,
			String img2,
			String img3) {

		Afiliados tmp = null;
		
			if (afiliadosRepository.existsById(id)) {
				Afiliados afiliados = afiliadosRepository.findById(id).get();
				if (nombre!=null) afiliados.setNombre(nombre);
				if (img!=null) afiliados.setImagen(img);
				if (descripcion!=null) afiliados.setDescripcion(descripcion);
				if (raiting!=null) afiliados.setRaiting(raiting);
				if (detalles!=null) afiliados.setDetalles(detalles);
				if (servicio1!=null) afiliados.setServicio1(servicio1);
				if (servicio2!=null) afiliados.setServicio2(servicio2);
				if (servicio3!=null) afiliados.setServicio3(servicio3);
				if (img1!=null) afiliados.setImg1(img1);
				if (img2!=null) afiliados.setImg2(img2);
				if (img3!=null) afiliados.setImg3(img3);
				afiliadosRepository.save(afiliados);
				tmp=afiliados;
			}//if
		
		return tmp;
	}//updateAfiliados

}//class AfiliadosService