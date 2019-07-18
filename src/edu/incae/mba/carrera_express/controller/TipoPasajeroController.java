/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.controller;

import edu.incae.mba.carrera_express.DAO.TipoPasajeroDao;
import edu.incae.mba.carrera_express.beans.TipoPasajeroBeans;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author uno
 */
public class TipoPasajeroController {
       TipoPasajeroDao tipoPasajeroD;

    public TipoPasajeroController() {
        tipoPasajeroD= new TipoPasajeroDao();
    }
    
    public boolean verificarDatos (TipoPasajeroBeans   tipoPasajeroB){
                if(tipoPasajeroB.getTipo().equals("")){
			JOptionPane.showMessageDialog(null,"El campo tipo de pasajero no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		
		if(tipoPasajeroB.getDescripion().equals("")){
			JOptionPane.showMessageDialog(null,"El campo descripción no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
                
                tipoPasajeroD.registrarTipoPasajero(tipoPasajeroB);
                
                return true;               
        
    }
    
    
    public String controllerEliminarTipo(Integer id)
	{
		return this.tipoPasajeroD.eliminarTipo(id);
	}
    
    public TipoPasajeroBeans controllerMostrarTipos(Integer id)
    {
        return tipoPasajeroD.mostrarCamposTipoPasajaro(id);
    }
 
    /**
      * En esta function el controller llama al DAO que se encarga de traer un Vector para llenar el combo 
      * @return 
      */
     public Vector controllerLlenarCombo()
     {
         return this.tipoPasajeroD.obtenerModeloCombo();
     }
    
}
