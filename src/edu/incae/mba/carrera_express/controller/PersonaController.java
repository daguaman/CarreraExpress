package edu.incae.mba.carrera_express.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.incae.mba.carrera_express.DAO.PersonaDao;
import edu.incae.mba.carrera_express.beans.PersonaBeans;
import edu.incae.mba.carrera_express.beans.UsuarioBeans;

public class PersonaController {
	
	PersonaDao personaD;
	
	
	public PersonaController(){		
		
		personaD= new PersonaDao();		
		
	}
	
	
	public boolean verificarDatos(PersonaBeans persona,UsuarioBeans usuario){
		if(persona.getNombres().equals("")){
			JOptionPane.showMessageDialog(null,"El campo nombre no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		
		if(persona.getApellidos().equals("")){
			JOptionPane.showMessageDialog(null,"El campo apellido no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		if(persona.getCedula().equals("")){
			JOptionPane.showMessageDialog(null,"El campo cedula no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
                if(usuario.getUser().equals("")){
			JOptionPane.showMessageDialog(null,"El campo usuario no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
                
                if(usuario.getClave().equals("")){
			JOptionPane.showMessageDialog(null,"El campo clave no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
                
                
		personaD.registrarPersona(persona,usuario);
		
		return true;
		
	}
	
	public String controlasCodigo(){
		return personaD.proximaPersona();
	}
	
	public PersonaBeans controllerMostrarCamposPersona(String cedula)
	{
		return personaD.mostrarCamposPersona(cedula);
	}
	
	public String controllerEliminarPersona(String cedula)
	{
		return this.personaD.eliminarPersona(cedula);
	}
	
}
