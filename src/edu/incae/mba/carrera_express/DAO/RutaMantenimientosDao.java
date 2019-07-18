/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.DAO;

import edu.incae.mba.carrera_express.beans.RutaMantenimientoBeans;
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
 * @author uno
 */
public class RutaMantenimientosDao {
    private RutaMantenimientoBeans rutaMantenimientoBeans;
    
    public RutaMantenimientosDao() {
        this.rutaMantenimientoBeans= new RutaMantenimientoBeans();
    }
    
    public void registrarRutaMantemiento (RutaMantenimientoBeans rt){
       CallableStatement myStm = null;
        try {
            if(rt.getId_ruta()==null)
            {
                rt.setId_ruta(-1);
            }
            
            myStm = Conexion.getConnection().prepareCall("{call sp_insertar_mantenimiento(?,?,?,?,?)}");
            myStm.setInt(1, rt.getId_ruta());
            myStm.setString(2, rt.getCiudad_destino());
            myStm.setString(3, rt.getCiudad_origen());
            myStm.setFloat(4, rt.getValor());
            myStm.setString(5, rt.getDescripcion());
           
            myStm.execute();
            Conexion.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Se ha ingresado el mantenimiento!", "Exito", 1, new ImageIcon("imagenes/ok.png"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            Logger.getLogger(RutaMantenimientosDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public RutaMantenimientoBeans mostrarCampos(Integer id){
        try {
            String SQLSelecion = "SELECT `rutamantemiento`.`id_ruta`, `rutamantemiento`.`ciudad_destino`, `rutamantemiento`.`ciudad_origen`, `rutamantemiento`.`valor`, `rutamantemiento`.`descripcion`, `rutamantemiento`.`estado` FROM `rutamantemiento` WHERE `rutamantemiento`.`id_ruta` = ?";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLSelecion);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                rutaMantenimientoBeans.setId_ruta(rs.getInt("id_ruta"));
                rutaMantenimientoBeans.setCiudad_destino(rs.getString("ciudad_destino"));
                rutaMantenimientoBeans.setCiudad_origen(rs.getString("ciudad_origen"));
                
                rutaMantenimientoBeans.setValor(rs.getFloat("valor"));                
                rutaMantenimientoBeans.setDescripcion(rs.getString("descripcion"));
                rutaMantenimientoBeans.setEstado(rs.getString("estado").charAt(0));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar Mantenimiento", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return rutaMantenimientoBeans;
    
    }
    
    public List<Object> buscarMantenimientos(String busqueda, JButton btn_eliminar) {
        try {
            String SQLSelection = "SELECT * FROM `rutamantemiento` WHERE `rutamantemiento`.`estado` = 'A'";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rowValues.add(new Object[]{rs.getInt("id_ruta"),rs.getString("ciudad_destino"), rs.getString("ciudad_origen"), rs.getFloat("valor"),rs.getString("descripcion") , btn_eliminar});
            }

            return rowValues;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar persona", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return null;

    }//fin de la funcion buscar mantenimientos
    
    
     public String eliminar(Integer id)
    {
         CallableStatement myStm = null;
         String mensaje="";
        try {
            myStm = Conexion.getConnection().prepareCall("{call sp_eliminar_mantenimiento(?,?)}");
            
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
     
     /**
      * Con esta funcion se llenara el combo de Rutas en la seccion de tickets
      * @return 
      */
     public Vector obtenerModeloCombo()
     {
         Vector model=new Vector();
         
         try {
             
            String SQLSelection = "SELECT `v1_combo_ruta`.`id_ruta`, `v1_combo_ruta`.`ruta`,`v1_combo_ruta`.`valor` FROM `v1_combo_ruta`";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                   model.add(new Item(rs.getInt("id_ruta"), rs.getString("ruta"),rs.getFloat("valor")));                
            }

            return model;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar persona", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
         return null;
     }
}
