package edu.incae.mba.carrera_express.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsertDemo {
	
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
			
			//3.- Insertando un registro en la tabla 
			System.out.println("Inserting a new Person to database");
			
			int rowsAffected= myStmt.executeUpdate("INSERT INTO "
													+"  `persona`( "
													+"  `nombre`, "
													+"  `apellidos`, "
													+"  `cedula`"
													+"  )"
												   +"	VALUES( "
												   +"	  'Heide', "
												   +"	  'Jaramillo', "
												   +"	  '0924766496'"
												   +  ""
												  +	"  )");
			
			//4.- Insertando un registro en la tabla 
			
			myRs=myStmt.executeQuery("Select * from persona");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("nombre")+" , "+ myRs.getString("apellidos"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
