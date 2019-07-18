package edu.incae.mba.carrera_express.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateDemo {

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
	
	private static void displayEmployee(Connection myConn, String firstName, String lastName) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select last_name, first_name, email from employees where last_name=? and first_name=?");

			myStmt.setString(1, lastName);
			myStmt.setString(2, firstName);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				String email = myRs.getString("email");
			
				System.out.printf("%s %s, %s\n", theFirstName, theLastName, email);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}	
}
