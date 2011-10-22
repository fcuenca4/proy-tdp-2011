package Entidades;
import javax.swing.Icon; 
import Posicion.Posicion;
import Auxiliares.*;

import javax.swing.JLabel;


/**
 * Responsable de imponer una representacion grafica, posicion logica y borde a todas las clases que la van a heredar
 * 
 *
 */
public abstract class Entidad  {
	
	protected JLabel label; //Reporesentacion Grafica 
	protected Posicion pos;//Posicion Logica
	protected Borde  borde;//Borde
	
	//Constructor
	public Entidad()
	{
		super();
	}
	
	
	//Getters
	public JLabel getLabel()
	{
		return label;
	}
	
	public Borde getBorde()
	{
		return this.borde;
	}
	
		
	
	public Posicion getPosicion()
	{
		return pos;
	}
	
	//Setter
	public void setPosicion(int i,int j)
	{
		pos.setX(i);
		pos.setY(j);
	}
	
	
	

}
