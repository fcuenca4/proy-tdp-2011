package Entidades;


import Cuerpo.*; 
import javax.swing.Icon;     
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import Auxiliares.*;
import java.io.*;

import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.Graphics2D;
import javax.swing.*;
import Posicion.Posicion;


/**
 * Esta clase hospeda el personaje principal del juego, encargada de darle forma
 * logica al mismo
 * 
 */

public class Mario extends Entidad {
	
	private boolean estaSaltando;//Variable de control
	private SpriteAnimado actual;//Sprite Actual
	private SpriteAnimado anterior;//Sprite Anterior
	private SpriteAnimado quieto;//Sprite Quieto
	private SpriteAnimado quietoIzq;//Sprite Quieto Izquierdo
	private SpriteAnimado derecha;//Sprite
	private SpriteAnimado izquierda;//Sprite
	private boolean muerto;//Variable de control
	private Animada movimiento;
	

	
	//Constructor 
	public Mario(int i,int j)
	{
		this.estaSaltando=false;
		this.pos=new Posicion(i,j);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/Spot_Snapping_Right.gif"));
		this.label=new JLabel();
		this.label.setBackground(new java.awt.Color(128, 255, 255));
		label.setIcon(imagen);
		label.setBounds(i,j,60,50);
		this.borde=new Cuadrado(i,j,this);
		this.movimiento=new Animada(this);
		movimiento.start();
		
		this.quieto = new SpriteAnimado();
		this.quieto.setearTemporal(false);
		this.quieto.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/Spot_Snapping_Right.gif")));
		
		this.quietoIzq = new SpriteAnimado();
		this.quietoIzq.setearTemporal(false);
		this.quietoIzq.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/Spot_Snapping_Left.gif")));

		
		
		this.izquierda = new SpriteAnimado();
		this.izquierda.setearTemporal(false);
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI1.gif")));	
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI2.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI3.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI4.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI5.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI6.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI7.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/coolI8.gif")));
		
		this.derecha = new SpriteAnimado();
		this.derecha.setearTemporal(false);
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool1.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool2.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool3.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool4.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool5.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool6.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool7.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/cool8.gif")));

		
		
	}
	
	//Setters
	
	public void setBorde(int i,int j)
	{
		this.borde.setPosicion(i,j);
	}
	
	public void setEstaSaltando(boolean b)
	{
		this.estaSaltando=b;
	}
	
	//Getters
	public boolean getEstaSaltando()
	{
		return this.estaSaltando;
	}
	
		
	public SpriteAnimado getActual()
	{return actual;}
	
	
	/**
	 * 
	 * Establece la animacion hacia la derecha
	 *
	 */
	public void derecha() 
	{
		this.anterior = this.actual;
		this.actual = this.derecha;

		
	}
	
	
	/**
	 * 
	 * Establece la animacion hacia la izquierda
	 *
	 */
	public void izquierda()
	{
		this.anterior = this.actual;
		this.actual = this.izquierda;
		
	}
	
	/**
	 * 
	 * Establece la animacion dejando el personaje quieto
	 *
	 */
	public void quieto()
	{
		this.anterior = this.actual;
		this.actual = this.quieto;
		
	}
	
	/**
	 * 
	 * Establece la animacion dejando el personaje quieto, pero mirando hacia la izquierda
	 *
	 */
	public void quietoI()
	{
		this.anterior = this.actual;
		this.actual = this.quietoIzq;
	
	}
	
	
		/**
	 * 
	 * Mata el personaje principal, disparando un cartel de dialogo y cerrando el juego
	 *
	 */
	public void morir()
	{
		muerto=true;
		JOptionPane.showMessageDialog(null,"Game Over");
		System.exit(0);
	}
	
	
	
}

	
	
	
	
	
	


