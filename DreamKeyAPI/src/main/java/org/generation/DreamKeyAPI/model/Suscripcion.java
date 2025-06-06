package org.generation.DreamKeyAPI.model;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSuscripcion", unique = true, nullable = false)
    private Long idSuscripcion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaSuscripcion", nullable = false)
    private LocalDate fechaSuscripcion = LocalDate.now();

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaPagoSuscripcion", nullable = false)
    private LocalDate fechaPagoSuscripcion = LocalDate.now().plusDays(30);

    @Column(name = "suscripcionActiva", nullable = false)
    private Boolean suscripcionActiva;

    @ManyToOne
    @JoinColumn(name = "idMembresias_fk", nullable = false)
    private Membresias membresia;

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario", nullable = false)
    private Usuarios usuario;

    // Constructores
    public Suscripcion() {
    }

    public Suscripcion(
            LocalDate fechaSuscripcion,
            LocalDate fechaPagoSuscripcion,
            Boolean suscripcionActiva,
            Membresias membresia,
            Usuarios usuario) {
        this.fechaSuscripcion = fechaSuscripcion;
        this.fechaPagoSuscripcion = fechaPagoSuscripcion;
        this.suscripcionActiva = suscripcionActiva;
        this.membresia = membresia;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return idSuscripcion;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public LocalDate getFechaPagoSuscripcion() {
        return fechaPagoSuscripcion;
    }

    public void setFechaPagoSuscripcion(LocalDate fechaPagoSuscripcion) {
        this.fechaPagoSuscripcion = fechaPagoSuscripcion;
    }

    public Boolean getSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(Boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }

    public Membresias getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresias membresia) {
        this.membresia = membresia;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    // Método para renovar la suscripción
    public void renovarSuscripcion() {
        if (LocalDate.now().isAfter(fechaPagoSuscripcion) || LocalDate.now().isEqual(fechaPagoSuscripcion)) {
            this.fechaSuscripcion = LocalDate.now();
            this.fechaPagoSuscripcion = fechaSuscripcion.plusDays(30);
            this.suscripcionActiva = true;
        }
    }

    @Override
    public String toString() {
        return "Suscripcion [id=" + idSuscripcion + ", fechaSuscripcion=" + fechaSuscripcion
                + ", fechaPagoSuscripcion=" + fechaPagoSuscripcion + ", suscripcionActiva=" + suscripcionActiva
                + ", membresia=" + membresia + ", usuario=" + usuario + "]";
    }
}


