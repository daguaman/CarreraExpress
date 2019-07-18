/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.utilitarios;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author admin
 */
public class Reporte {

    public Reporte() {
    }
    
    
    public void generarReporte(String codigo,Connection conexion)
    {
        try{
            Map<String,Object> parametro= new HashMap<>();
            parametro.put("par_codigo", codigo);
           
            //String ruta = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            String ruta1=((this.getClass().getProtectionDomain().getCodeSource().getLocation()).toString()).substring(6);                   
            
            
            String ruta=ruta1.split("build")[0]+"src/edu/incae/mba/carrera_express/reportes/ticket.jrxml";
            String imagen=ruta1.split("build")[0]+"src/iconos/onlinelogomaker.png";
           imagen= imagen.replace('/', File.separatorChar);
            parametro.put("par_imagen", imagen);
            JasperReport contenido=JasperCompileManager.compileReport(ruta.replace('/',File.separatorChar ));
            JasperPrint imprimir= JasperFillManager.fillReport(contenido, parametro,conexion);
            JasperViewer.viewReport(imprimir);            
            
        }
        catch(JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al crear el reporte", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
    }
}
