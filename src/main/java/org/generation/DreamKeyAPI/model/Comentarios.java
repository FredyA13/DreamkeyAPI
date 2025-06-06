package org.generation.DreamKeyAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="Comentario")
public class Comentarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String comentario;
	//private static Long total=Long.valueOf(0);
	public Comentarios(String comentario) {
		super();
		this.comentario = comentario;
		//Comentarios.total++;
		//this.id=Comentarios.total;
	}
	public Comentarios() {
		//Comentarios.total++;
		//this.id=Comentarios.total;
	}
	public String getComentarios() {
		return comentario;
	}
	public void setComentarios(String comentario) {
		this.comentario = comentario;
	}
	/*public static Long getTotal() {
		return total;
	} */
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", comentario=" + comentario + "]";
	}
	
	
	
	

	
	
}
