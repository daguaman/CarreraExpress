/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.DAO;

import edu.incae.mba.carrera_express.beans.ClienteBeans;
import edu.incae.mba.carrera_express.beans.TicketBeans;
import edu.incae.mba.carrera_express.utilitarios.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Carrera
 */
public class TicketsDao {
        
private TicketBeans ticketBeans;
private ClienteBeans clienteBeans;

    public TicketsDao() {
        this.ticketBeans= new TicketBeans();
        this.clienteBeans= new ClienteBeans();
    }
    
    public String registrarTicket(TicketBeans p_ticket)
    {
        CallableStatement myStm = null;
        String theResult="";
        try {
            
            
        GregorianCalendar calendar=p_ticket.getCalendar();
        int year       = calendar.get(Calendar.YEAR);
        int month      = calendar.get(Calendar.MONTH); 
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
        int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

        int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute     = calendar.get(Calendar.MINUTE);
        int second     = calendar.get(Calendar.SECOND);
        int millisecond= calendar.get(Calendar.MILLISECOND);
            
            myStm = Conexion.getConnection().prepareCall("{call sp_ingresar_ticket(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            myStm.setInt(1, p_ticket.getFk_cedula());
            myStm.setInt(2, p_ticket.getFk_tipo());
            myStm.setInt(3, p_ticket.getFk_ruta());
            
            myStm.setInt(4, dayOfMonth);
            myStm.setInt(5, month+1);
            myStm.setInt(6, year);
            myStm.setInt(7,hourOfDay);
            myStm.setInt(8, minute);
            myStm.setBoolean(9, p_ticket.getIda_vuelta());
            myStm.setFloat(10, p_ticket.getTotal());
            myStm.setFloat(11, p_ticket.getFk_user_system());
            myStm.setFloat(12, p_ticket.getDscto_edad());
            myStm.registerOutParameter(13, Types.VARCHAR);           
          
            myStm.execute();
            Conexion.getConnection().commit();

            theResult = myStm.getString(13);
            return theResult;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
        return null;
    }

    public Integer registrarCliente(ClienteBeans c1) {
       CallableStatement myStm = null;
       
        try {
          myStm = Conexion.getConnection().prepareCall("{call sp_ingresar_cliente(?,?,?,?,?)}");
            
            myStm.setString(1,c1.getCedula() );
            myStm.setString(2,c1.getNombres() );
            myStm.setString(3,c1.getApellidos());
            myStm.setInt(4, c1.getFk_tipo());
            
            myStm.registerOutParameter(5, Types.INTEGER); 
            
            myStm.execute();
            Conexion.getConnection().commit();

            Integer codigoPersona = myStm.getInt(5);
            return codigoPersona;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
        return null;
    }
    
    

}