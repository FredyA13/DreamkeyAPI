package org.generation.DreamKeyAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="afiliados")
public class Afiliados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAfiliados", unique = true, nullable=false)
	private Long id;
	
	@Column(name="nombreAfiliados", nullable=false)
	private String nombre;
	
	@Column(name="imgAfiliados", nullable=false)
	private String imagen;
	
	@Column(name="descripcionAfiliados", nullable=false)
	private String descripcion;
	
	@Column(name="ratingAfiliados", nullable=false)
	private Double raiting;
	
	@Column(name="detallesAfiliados", nullable=false)
	private String detalles;
	
	@Column(name="serviciosAfiliados1", nullable=false)
	private String servicio1;
	
	@Column(name="serviciosAfiliados2", nullable=false)
	private String servicio2;
	
	@Column(name="serviciosAfiliados3", nullable=false)
	private String servicio3;
	
	@Column(name="imgAfiliados1", nullable=false)
	private String img1;
	
	@Column(name="imgAfiliados2", nullable=false)
	private String img2;
	
	@Column(name="imgAfiliados3", nullable=false)
	private String img3;
	
	//private static Long total = Long.valueOf(0);
	
	public Afiliados(String nombre, String imagen, String descripcion, Double raiting, String detalles,
			String servicio1, String servicio2, String servicio3, String img1, String img2, String img3) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.raiting = raiting;
		this.detalles = detalles;
		this.servicio1 = servicio1;
		this.servicio2 = servicio2;
		this.servicio3 = servicio3;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		//Afiliados.total++;
		//this.id = Afiliados.total;
	}//afiliados
	
	public Afiliados() {
		//Afiliados.total++;
		//this.id = Afiliados.total;
	}//constructor vacío

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public Double getRaiting() {
		return raiting;
	}//getRaiting

	public void setRaiting(Double raiting) {
		this.raiting = raiting;
	}//setRaiting

	public String getDetalles() {
		return detalles;
	}//getDetalles

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}//setDetalles

	public String getServicio1() {
		return servicio1;
	}//getServicio1

	public void setServicio1(String servicio1) {
		this.servicio1 = servicio1;
	}//setServicio1

	public String getServicio2() {
		return servicio2;
	}//getServicio2

	public void setServicio2(String servicio2) {
		this.servicio2 = servicio2;
	}//setServicio2

	public String getServicio3() {
		return servicio3;
	}//getServicio3

	public void setServicio3(String servicio3) {
		this.servicio3 = servicio3;
	}//setServicio3

	public String getImg1() {
		return img1;
	}//getImg1

	public void setImg1(String img1) {
		this.img1 = img1;
	}//setImg1

	public String getImg2() {
		return img2;
	}//getImg2

	public void setImg2(String img2) {
		this.img2 = img2;
	}//setImg2

	public String getImg3() {
		return img3;
	}//getImg3

	public void setImg3(String img3) {
		this.img3 = img3;
	}//setImg3

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Afiliados [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
				+ ", raiting=" + raiting + ", detalles=" + detalles + ", servicio1=" + servicio1 + ", servicio2="
				+ servicio2 + ", servicio3=" + servicio3 + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + "]";
	}//toString
	
	
}//Afiliados
