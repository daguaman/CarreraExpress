package edu.incae.mba.carrera_express.utilitarios;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class FondoPantalla extends JDesktopPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagen;
	
	
	
	public FondoPantalla(String img) {
		this.imagen= new ImageIcon(img).getImage();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
	}
		
	
}
