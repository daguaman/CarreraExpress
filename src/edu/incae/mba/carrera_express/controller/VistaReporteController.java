/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.incae.mba.carrera_express.controller;

import edu.incae.mba.carrera_express.DAO.VistaReporteDao;

/**
 *
 * @author admin
 */
public class VistaReporteController {
    VistaReporteDao vistaReporteDao;

    public VistaReporteController() {
        this.vistaReporteDao=new VistaReporteDao();
    }
    
    
    
    public void controllerEliminarTicket(Integer id)
	{
	 this.vistaReporteDao.eliminarTicket(id);
	}
}
