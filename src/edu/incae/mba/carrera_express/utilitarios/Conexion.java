package edu.incae.mba.carrera_express.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexion {

	private final String URL="jdbc:mysql://localhost:3306/carrera_express?zeroDateTimeBehavior=convertToNull";
	private final String Driver="";
	private final String Usuario="root";
	private final String Clave="";
	private static Connection Con;

    public Conexion() {
    		try {
				Con=DriverManager.getConnection(URL,Usuario,Clave);
				Con.setAutoCommit(false);
				//JOptionPane.showMessageDialog(null,"Conexion Exitosa","Conectado",1);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error en la conexion en la base de datos","Error",0);
			}
    }
	
    public static Connection getConnection(){
    	if(Con==null)
    	{
    		new Conexion();
    	}
    	return Con;
    }        
        
	public static void enlazarConexion(){
		try {
			 if(!Con.isClosed())
			 {
				 Con.close();	 
			 
			 }			
			
		} catch (SQLException e) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
	
}
