package com.bootcamp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Ingrediente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    
    @Id  // para que sea persistente y primary key y autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key
    private long id;
    @NotEmpty(message = "El campo nombre no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres" )
    private String nombre;
    private double precio;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)  // Relacion muchos productos con una representacion //
// se hacen consultas personalizadaz, xk es de tipo lazy
    @NotNull(message = "El producto tiene que tener una presentación")
    private List<Pizza> pizza;

    public Ingrediente() {
    }

    public Ingrediente(long id,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres") String nombre,
            double precio, @NotNull(message = "El producto tiene que tener una presentación") List<Pizza> pizza) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.pizza = pizza;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    
    
}
