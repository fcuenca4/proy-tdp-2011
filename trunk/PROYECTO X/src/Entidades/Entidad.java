package Entidades;
import javax.swing.Icon; 
import Posicion.Posicion;
import Auxiliares.*;
import Cuerpo.SpriteAnimado;
import Estructuras.ListaSE;

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
	protected ListaSE<Entidad> objetos;	//Lista de objetos en el Mapa
	protected ListaSE<Entidad> piso;	//Lista que indica la posicion del piso.
	protected ListaSE<Malo> malos; 
	protected ListaSE<Item> items;
	
	
	//Constructor
	protected Entidad()
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
	
	public ListaSE<Entidad> getPiso()
	{
		return piso;
	}
	
	public ListaSE<Malo> getMalos()
	{
		return malos;
	}
	
	public ListaSE<Entidad> getObjetos()
	{
		return objetos;
	}
	
	public ListaSE<Item> getItems()
	{
		return items;
	}
	
	//Setter
	public void setPosicion(int i,int j)
	{
		pos.setX(i);
		pos.setY(j);
	}
	
	public void setBorde(int i,int j)
	{
		this.borde.setPosicion(i,j);
	}

	
	
	

}
