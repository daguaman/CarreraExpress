/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 *
 * @author Christian Carrera
 */
public class TicketBeans {
   
  private Integer id; 
  private Integer fk_cedula;
  private Integer fk_tipo;
  private Integer fk_ruta;
  private java.sql.Date fecha_viaje;
  private GregorianCalendar calendar;
  private Boolean ida_vuelta;
  private Float total;
  private java.sql.Timestamp fecha_ingreso;
  private Integer fk_user_system;
  private Character estado;
  private String codigo;
  private Float dscto_edad;

  public TicketBeans() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFk_cedula() {
        return fk_cedula;
    }

    public void setFk_cedula(Integer fk_cedula) {
        this.fk_cedula = fk_cedula;
    }

    public Integer getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(Integer fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    public Integer getFk_ruta() {
        return fk_ruta;
    }

    public void setFk_ruta(Integer fk_ruta) {
        this.fk_ruta = fk_ruta;
    }

    public Date getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(Date fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public Boolean getIda_vuelta() {
        return ida_vuelta;
    }

    public void setIda_vuelta(Boolean ida_vuelta) {
        this.ida_vuelta = ida_vuelta;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Timestamp getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Timestamp fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getFk_user_system() {
        return fk_user_system;
    }

    public void setFk_user_system(Integer fk_user_system) {
        this.fk_user_system = fk_user_system;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }

    public Float getDscto_edad() {
        return dscto_edad;
    }

    public void setDscto_edad(Float dscto_edad) {
        this.dscto_edad = dscto_edad;
    }
    
    

    @Override
    public String toString() {
        return "TicketBeans{" + "fk_tipo=" + fk_tipo + ", fk_ruta=" + fk_ruta + ", fecha_viaje=" + fecha_viaje + ", calendar=" + calendar + ", ida_vuelta=" + ida_vuelta + ", total=" + total + ", fecha_ingreso=" + fecha_ingreso + ", fk_user_system=" + fk_user_system + '}';
    }
    
    
    
      
}
