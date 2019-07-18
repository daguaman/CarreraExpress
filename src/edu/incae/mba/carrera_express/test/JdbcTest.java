package edu.incae.mba.carrera_express.test;

import java.sql.*;


public class JdbcTest {

	public static void main(String[] args) {
		Connection myConn= null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		String dbUrl="jdbc:mysql://localhost:3306/carrera_express?zeroDateTimeBehavior=convertToNull";
		String user="root";
		String pass="";
		
		try {
			
			//1.- Obtener la conexion
			myConn=DriverManager.getConnection(dbUrl,user,pass);
			
			System.out.println("Conexion a la base de datos exitosa!");
			
			//2.- Crear un statement
			myStmt=myConn.createStatement();
			
			//3.-Ejecutar un query
			myRs= myStmt.executeQuery("Select * from persona");
			
			//4.- Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("nombre")+" , "+ myRs.getString("apellidos"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
