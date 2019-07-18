package edu.incae.mba.carrera_express.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.incae.mba.carrera_express.beans.PersonaBeans;
import edu.incae.mba.carrera_express.beans.UsuarioBeans;
import edu.incae.mba.carrera_express.utilitarios.Conexion;
import java.sql.CallableStatement;
import java.sql.Types;

public class PersonaDao {

    PersonaBeans personaBeans;

    public PersonaDao() {
        personaBeans = new PersonaBeans();
    }

    public String eliminarPersona(String cedula) {

        CallableStatement myStm = null;
        try {
            myStm = Conexion.getConnection().prepareCall("{call sp_eliminar_personas(?)}");

            myStm.registerOutParameter(1, Types.VARCHAR);
            myStm.setString(1, cedula);

            myStm.execute();
            Conexion.getConnection().commit();

            String theResult = myStm.getString(1);
            return theResult;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
        return null;

    }

    public void registrarPersona(PersonaBeans persona, UsuarioBeans usuario) {
        CallableStatement myStm = null;
        try {

            myStm = Conexion.getConnection().prepareCall("{call sp_ingresar_personas(?,?,?,?,?)}");
            myStm.setString(1, persona.getNombres());
            myStm.setString(2, persona.getApellidos());
            myStm.setString(3, persona.getCedula());
            myStm.setString(4, usuario.getUser());
            myStm.setString(5, usuario.getClave());
            /*
                String SQLInsertion="INSERT INTO persona (nombre,apellidos,cedula) VALUES (?,?,?) "; 
    		
                PreparedStatement st=Conexion.getConnection().prepareStatement(SQLInsertion);
		    st.setString(1, persona.getNombres());
		    st.setString(2, persona.getApellidos());
		    st.setString(3,persona.getCedula());
		    
		    st.execute();
             */
            myStm.execute();
            Conexion.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Se ha ingresado a la Persona", "Exito", 1, new ImageIcon("imagenes/ok.png"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String proximaPersona() {

        try {
            String SQLSelection = "Select * from persona where estado='A' order by persona_id desc limit 1";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("persona_id")) + 1) + "";
            } else {
                return "1";
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            return "0";
        }

    }//fin del metodo Proxima Persona

    public List<Object> buscarPersona(String busqueda, JButton btn_eliminar) {
        try {
            String SQLSelection = "SELECT * FROM `persona` WHERE `estado` = 'A' AND `persona`.`persona_id` NOT IN (SELECT `pasajero`.`personaid_fk` FROM `pasajero`) ORDER BY `persona_id`";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rowValues.add(new Object[]{rs.getString("nombre"), rs.getString("apellidos"), rs.getString("cedula"), "", btn_eliminar});
            }

            return rowValues;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar persona", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return null;

    }

    public PersonaBeans mostrarCamposPersona(String cedula) {
        try {
            String SQLSelecion = "Select * from persona WHERE persona.cedula = ?";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLSelecion);
            st.setString(1, cedula);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                personaBeans.setPersonaId(rs.getInt("persona_id"));
                personaBeans.setNombres(rs.getString("nombre"));
                personaBeans.setApellidos(rs.getString("apellidos"));
                personaBeans.setCedula(rs.getString("cedula"));
                personaBeans.setEstado(rs.getString("estado").charAt(0));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar persona", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return personaBeans;

    }

}
