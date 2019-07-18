/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.controller;

import edu.incae.mba.carrera_express.DAO.RutaMantenimientosDao;
import edu.incae.mba.carrera_express.beans.RutaMantenimientoBeans;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author uno
 */
public class RutaMantemientoController {
       RutaMantenimientosDao rutaMantemientoD;

    public RutaMantemientoController() {
        rutaMantemientoD= new RutaMantenimientosDao();
    }
    
    public boolean verificarDatos (RutaMantenimientoBeans   rutaMantemientoB){
        if(rutaMantemientoB.getCiudad_origen().equals("")){
			JOptionPane.showMessageDialog(null,"El campo de origen no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		
		if(rutaMantemientoB.getCiudad_destino().equals("")){
			JOptionPane.showMessageDialog(null,"El campo de destino no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
               
                
                if(rutaMantemientoB.getDescripcion().equals("")){
			JOptionPane.showMessageDialog(null,"El campo de descripción no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
                
                if(rutaMantemientoB.getValor() < 0.0f){
			JOptionPane.showMessageDialog(null,"El campo de valor no puede tener valores negativos ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
                
                rutaMantemientoD.registrarRutaMantemiento(rutaMantemientoB);
                
                return true;               
        
    }//fin de Verificar Datos
    
     public RutaMantenimientoBeans controllerMostrarMantenimientos(Integer id)
    {
        return this.rutaMantemientoD.mostrarCampos(id);
    }
     
     public String controllerEliminarMantenimiento(Integer id)
	{
		return this.rutaMantemientoD.eliminar(id);
	}
    
     /**
      * En esta function el controller llama al DAO que se encarga de traer un Vector para llenar el combo 
      * @return 
      */
     public Vector controllerLlenarCombo()
     {
         return this.rutaMantemientoD.obtenerModeloCombo();
     }
}
