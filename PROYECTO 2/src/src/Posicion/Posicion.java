package Posicion;

import Posicion.*;
/**
 * Modela una posicion logica que sera utilizada en todo el juego
 */
public class Posicion {
	
	private int x;
	private int y;
	
	//Constructor
	public Posicion(int i,int j)
	{
		x=i;
		y=j;
	}
	
	//Getters
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
	//Setters
	public void setX(int i)
	{
		x=i;
	}
	
	public void setY(int j)
	{
		y=j;
	}
	
	//Comparador de Posiciones
	public boolean equals(Object p)
	{
		Posicion aux=(Posicion)p;
		if (aux.getX()==this.x && aux.getY()==this.y) return true;else return false;
	}
}
