/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.beans;

/**
 *
 * @author Christian Carrera
 */
public class ClienteBeans {
    private String cedula;
    private String nombres;
    private String apellidos;
    private Integer fk_tipo;
    private Integer fk_id_persona;

    public ClienteBeans() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(Integer fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    public Integer getFk_id_persona() {
        return fk_id_persona;
    }

    public void setFk_id_persona(Integer fk_id_persona) {
        this.fk_id_persona = fk_id_persona;
    }

    @Override
    public String toString() {
        return "ClienteBeans{" + "cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fk_tipo=" + fk_tipo + '}';
    }
    
    
    
    
}
