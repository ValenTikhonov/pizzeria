package com.bootcamp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;

@Entity
public class Pizza implements Serializable { // serializar a un objeto de java

    public static final long serialVersionUID = 2L;

    @Id // para que sea persistente y primary key y autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key
    private long id;

    private String nombre;

    private String foto;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")  // relaciona primary key con forregn key Como tenemos que manipular primero//La tabla hija y luego padre // hijo Producto padre Presentacion
    private List<Ingrediente> ingredientes;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Comentario> comentarios;

    private double precio;

    public Pizza() {
    }

    public Pizza(long id, String nombre, String foto, List<Ingrediente> ingredientes, List<Comentario> comentarios,
            double precio) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.comentarios = comentarios;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

}
