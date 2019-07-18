/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.utilitarios;

/**
 *
 * @author Christian Carrera
 */
public class Item {

    private int id;
    private String description;
    private Float precio;

    public Item() {
    }
    
    
    public Item(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Item(int id, String description, Float precio) {
        this.id = id;
        this.description = description;
        this.precio = precio;
    }
    
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return description;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    
}
