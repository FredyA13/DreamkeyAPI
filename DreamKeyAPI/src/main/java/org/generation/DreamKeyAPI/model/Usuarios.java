package org.generation.DreamKeyAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario", unique=true, nullable=false)
	private Long id;
	
	@Column(name="nombreUsuario", nullable=false)
	private String nombre;
	
	@Column(name="telefonoUsuario", nullable=false)
	private String telefono;
	
	@Column(name="correoUsuario", nullable=false)
	private String correo;
	
	@Column(name="contraseñaUsuario", nullable=false)
	private String contraseña;
	
	//private static Long total=Long.valueOf(0);

	//constructor de usuarios
	public Usuarios(String nombre, String telefono, String correo, String contraseña) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contraseña = contraseña;
		//Usuarios.total++;
		//this.id=Usuarios.total;
	}//constructor

	
	public Usuarios() {
		//Usuarios.total++;
		//this.id=Usuarios.total;
	}//constructor vacios
	
	
	//getters y setters
	public Long getId() {
		return id;
	}//getId

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getCorreo() {
		return correo;
	}//getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getContraseña() {
		return contraseña;
	}//getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//setContraseña


	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + id + ", nombreUsuario=" + nombre + ", telefonoUsuario="
				+ telefono + ", correoUsuario=" + correo + ", contraseñaUsuario=" + contraseña
				+ "]";
	}
	
	//toString()
	
	
	


	
	
	
	
	

}