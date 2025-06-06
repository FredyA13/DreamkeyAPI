package org.generation.DreamKeyAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Membresias")
public class Membresias {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idMembresias", unique=true, nullable=false)
    private Long id;
    @Column(name="nombreMembresias",nullable=false)
    private String nombre;
    @Column(name="precioMembresia",nullable=false)
    private Double precio;
    @Column(name="categoriaMembresia",nullable=false)
    private String categoria;
    @Column(name="urlImagenMembresia",nullable=false)
    private String imagen;
    @Column(name="descripcionMembresia",nullable=false)
    private String descripcion;

    public Membresias() {
    }

    public Membresias(String nombre, Double precio, String categoria, String imagen, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	@Override
	public String toString() {
		return "Membresias [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio()
				+ ", getCategoria()=" + getCategoria() + ", getImagen()=" + getImagen() + ", getDescripcion()="
				+ getDescripcion() + "]";
	}
}

