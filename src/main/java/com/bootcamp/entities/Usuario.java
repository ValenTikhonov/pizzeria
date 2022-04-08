package com.bootcamp.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 3L;

    @Id // para que sea persistente y primary key y autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key
    private long id;
    private String email;
    private String nombre;
    private String apellidoPr;
    private String apellidoSg;
    private String contrasena;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "usuario") // mappedBy clave forranea
    private List<Comentario>comentarios;

    public Usuario() {
    }

    public Usuario(long id, String email, String nombre, String apellidoPr, String apellidoSg, String contrasena,
            List<Comentario> comentarios) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellidoPr = apellidoPr;
        this.apellidoSg = apellidoSg;
        this.contrasena = contrasena;
        this.comentarios = comentarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPr() {
        return apellidoPr;
    }

    public void setApellidoPr(String apellidoPr) {
        this.apellidoPr = apellidoPr;
    }

    public String getApellidoSg() {
        return apellidoSg;
    }

    public void setApellidoSg(String apellidoSg) {
        this.apellidoSg = apellidoSg;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    
}