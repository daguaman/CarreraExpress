package edu.incae.mba.carrera_express.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.incae.mba.carrera_express.DAO.UsuarioDao;
import edu.incae.mba.carrera_express.beans.UsuarioBeans;

public class UsuarioController {
	
	UsuarioDao usuarioD;
	
	public UsuarioController(){
		
		usuarioD= new UsuarioDao();
	}
        
        public UsuarioBeans controllerMostrarCamposUsuario(String cedula)
	{
		return usuarioD.mostrarCamposUsuario(cedula);
	}
	
	public boolean verificarDatos(UsuarioBeans  usuario){
		
		if(usuario.getUser().equals("")){
			JOptionPane.showMessageDialog(null,"El campo usuario no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		if(usuario.getClave().equals("")){
			JOptionPane.showMessageDialog(null,"El campo clave no debe estar en blanco ","Error",0,new ImageIcon("imagenes/btn_sair.png"));
			return false;
		}
		
		usuarioD.registrarUsuario(usuario);
		
		return true;
		
	}
        
        public Integer controlloreDoLogin(UsuarioBeans usr)
        {
            return usuarioD.doLogin(usr);
        }

}
