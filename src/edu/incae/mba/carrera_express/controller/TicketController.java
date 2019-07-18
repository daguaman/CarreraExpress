/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.controller;

import edu.incae.mba.carrera_express.DAO.TicketsDao;
import edu.incae.mba.carrera_express.beans.ClienteBeans;
import edu.incae.mba.carrera_express.beans.PersonaBeans;
import edu.incae.mba.carrera_express.beans.TicketBeans;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Carrera
 */
public class TicketController {
    
    TicketsDao ticketsDao;

    public TicketController() {
        this.ticketsDao= new TicketsDao();
    }   
    
    public boolean verificarDatos(ClienteBeans cliente,TicketBeans ticket){
        if(cliente.getCedula().equals("")){
                                          JOptionPane.showMessageDialog(null,"El campo cedula no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        
        if(cliente.getNombres().equals("")){
                                          JOptionPane.showMessageDialog(null,"El campo Nombres no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        
        if(cliente.getApellidos().equals("")){
                                          JOptionPane.showMessageDialog(null,"El campo Apellido no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        if(cliente.getFk_tipo()==null){
                                          JOptionPane.showMessageDialog(null,"El campo Tipo Pasajero no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        
        if(ticket.getFk_ruta()==null){
                                          JOptionPane.showMessageDialog(null,"El campo Ruta no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                     }
        
        if(ticket.getFecha_viaje()!=null){
                                          JOptionPane.showMessageDialog(null,"El campo Fecha de viaje no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        if(ticket.getTotal()==null || ticket.getTotal()==0.0f){
                                          JOptionPane.showMessageDialog(null,"El campo Total no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
                                          return false;
                                        }
        
        return true;                                
    
    }
    
    public Integer registrarCliente(ClienteBeans cliente)
    {
        return this.ticketsDao.registrarCliente(cliente);
    }
    
    public String registrar(TicketBeans p_ticket){
        return this.ticketsDao.registrarTicket(p_ticket);
    }
    
}
