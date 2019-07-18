/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.beans;

/**
 *
 * @author uno
 */
public class RutaMantenimientoBeans {
    
    private Integer id_ruta;
    private String ciudad_destino;
    private String ciudad_origen;
    private String descripcion;
    private Float valor;
    private Character estado;

    public RutaMantenimientoBeans() {
    	
    }
    
    

    public RutaMantenimientoBeans(String ciudadOrigen, String ciudaddDestino, String descripcion, float valor) {
        this.ciudad_origen = ciudadOrigen;
        this.ciudad_destino = ciudaddDestino;
        this.descripcion = descripcion;
        this.valor = valor;
    }



	public String getCiudad_destino() {
		return ciudad_destino;
	}



	public void setCiudad_destino(String ciudad_destino) {
		this.ciudad_destino = ciudad_destino;
	}



	public String getCiudad_origen() {
		return ciudad_origen;
	}



	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Float getValor() {
		return valor;
	}



	public void setValor(Float valor) {
		this.valor = valor;
	}

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Integer getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Integer id_ruta) {
        this.id_ruta = id_ruta;
    }
    
    
           
    
    
    
}
