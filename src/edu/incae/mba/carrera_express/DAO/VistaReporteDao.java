/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.DAO;

import edu.incae.mba.carrera_express.beans.VistaReporte;
import edu.incae.mba.carrera_express.utilitarios.Conexion;
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

/**
 *
 * @author Christian Carrera
 */
public class VistaReporteDao {
    
    VistaReporte reporte;

    public VistaReporteDao() {
    }
    
   public List<Object> buscarReporte(String string, JButton btn_eliminar) {
        try {
            String SQLSelection = "SELECT * FROM `v_reporte_ticket` where `v_reporte_ticket`.`estado`='A'";
            List<Object> rowValues = new ArrayList<>();

            PreparedStatement st;
            st = Conexion.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rowValues.add(new Object[]{rs.getString("codigo"),
                            rs.getInt("id"), 
                            rs.getString("cedula"), 
                            rs.getString("apellidos"),
                            rs.getString("nombre"), 
                            rs.getString("tipo"), 
                            rs.getFloat("porcentaje"),
                            rs.getFloat("dscto_edad"), 
                            rs.getString("ciudad_origen"), 
                            rs.getString("ciudad_destino"),
                            rs.getFloat("valor"), 
                            rs.getDate("fecha_viaje"), 
                            rs.getBoolean("ida_vuelta"),
                            rs.getFloat("total"), 
                            rs.getString("user"), 
                            rs.getTimestamp("fecha_ingreso"), btn_eliminar});
            }

            return rowValues;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar Registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return null;
    }

    public void eliminarTicket(Integer id) {
        String SQL="";
        PreparedStatement st= null;
    	try {
            SQL="UPDATE `ticket` SET `estado` = 'I' WHERE `ticket`.`id`=?";
                st=Conexion.getConnection().prepareStatement(SQL);
		    st.setInt(1, id);
                    st.execute();
		    Conexion.getConnection().commit();
		    JOptionPane.showMessageDialog(null,"Se ha eliminado de manera logica el ticket","Exito",1,new ImageIcon("imagenes/ok.png"));
		    
            } catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,e,"Error",0,new ImageIcon("imagenes/btn_sair.png"));
			Logger.getLogger(TipoPasajeroDao.class.getName()).log(Level.SEVERE, null,e);
		}
        }
    }
    
