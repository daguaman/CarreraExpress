/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.DAO;

import edu.incae.mba.carrera_express.beans.TipoPasajeroBeans;
import edu.incae.mba.carrera_express.utilitarios.Conexion;
import edu.incae.mba.carrera_express.utilitarios.Item;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Carrera
 */
public class TipoPasajeroDao {
    
    TipoPasajeroBeans tipoPasajeroBeans;
    
    public TipoPasajeroDao() {
        tipoPasajeroBeans= new TipoPasajeroBeans();
    }
    
    public String eliminarTipo(Integer id)
    {
         CallableStatement myStm = null;
         String mensaje="";
        try {
            myStm = Conexion.getConnection().prepareCall("{call sp_eliminar_tipo(?,?)}");
            
            myStm.setInt(1, id);
            myStm.registerOutParameter(2, Types.VARCHAR);
           

            myStm.execute();
            Conexion.getConnection().commit();

            String theResult = myStm.getString(2);
            return theResult;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public TipoPasajeroBeans mostrarCamposTipoPasajaro(Integer id) {
        try {
            String SQLSelecion = "SELECT `tipo`.`id`, `tipo`.`tipo`, `tipo`.`descripcion`, `tipo`.`porcentaje`, `tipo`.`estado` FROM `tipo` WHERE `tipo`.`id` = ?";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLSelecion);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                tipoPasajeroBeans.setId(rs.getInt("id"));
                tipoPasajeroBeans.setTipo(rs.getString("tipo"));
                tipoPasajeroBeans.setDescripion(rs.getString("descripcion"));
                tipoPasajeroBeans.setPorcentaje(rs.getFloat("porcentaje"));
                tipoPasajeroBeans.setEstado(rs.getString("estado").charAt(0));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar persona", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return tipoPasajeroBeans;

    }
    
    public void registrarTipoPasajero(TipoPasajeroBeans tipoPasajero)
    { 
    	String SQL="";
        PreparedStatement st= null;
    	try {
    		
            //Estoy es el SQL de la base de la tabla
            if(tipoPasajero.getId()!=null){
                SQL="UPDATE `tipo` SET `tipo` = ?, `descripcion` = ?, `porcentaje` = ? WHERE `tipo`.`id` = ? AND `tipo`.`estado`='A'";
                st=Conexion.getConnection().prepareStatement(SQL);
		    st.setString(1, tipoPasajero.getTipo());
		    st.setString(2, tipoPasajero.getDescripion());
                    st.setDouble(3, tipoPasajero.getPorcentaje());
                    st.setInt(4, tipoPasajero.getId());
                
            }else{
               SQL ="INSERT INTO `tipo`(`tipo`, `descripcion`, `porcentaje`) VALUES(?, ?, ?) ";
                st=Conexion.getConnection().prepareStatement(SQL);
		    st.setString(1, tipoPasajero.getTipo());
		    st.setString(2, tipoPasajero.getDescripion());
                    st.setDouble(3, tipoPasajero.getPorcentaje());
            }
            	    st.execute();
		    Conexion.getConnection().commit();
		    JOptionPane.showMessageDialog(null,"Se ha ingresado al tipo de pasajero","Exito",1,new ImageIcon("imagenes/ok.png"));
		    
    	
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,e,"Error",0,new ImageIcon("imagenes/btn_sair.png"));
			Logger.getLogger(TipoPasajeroDao.class.getName()).log(Level.SEVERE, null,e);
		}
    }

    public List<Object> buscarTipo(String string, JButton btn_eliminar) {
        try {
            String SQLSelection = "SELECT * FROM `tipo` WHERE `tipo`.`estado` = 'A'";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rowValues.add(new Object[]{rs.getInt("id"),rs.getString("tipo"), rs.getString("descripcion"), rs.getString("porcentaje"), btn_eliminar});
            }

            return rowValues;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar Tipo", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return null;
    }
    
    /**
      * Con esta funcion se llenara el combo de Rutas en la seccion de tickets
      * @return 
      */
     public Vector obtenerModeloCombo()
     {
         Vector model=new Vector();
         
         try {
             
            String SQLSelection = "SELECT `v1_combo_tipo_pasajero`.`id`, `v1_combo_tipo_pasajero`.`tipo`,`v1_combo_tipo_pasajero`.`porcentaje` FROM `v1_combo_tipo_pasajero`";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                   model.add(new Item(rs.getInt("id"), rs.getString("tipo"),rs.getFloat("porcentaje")));                
            }

            return model;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar en la vista tipo", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
         return null;
     }
    
}
