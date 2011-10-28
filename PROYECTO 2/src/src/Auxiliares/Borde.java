package Auxiliares;
import Entidades.Mario;
/**
 * Modela el  borde del cuadrado.
 * 
 * 
 * */
public abstract class Borde {
	
	protected int x1;//Posicion X del Cuadrado
	protected int x2;//Posicion X del Cuadrado
	protected int y1;//Posicion Y del Cuadrado
	protected int y2;//Posicion Y del Cuadrado
	
	//Setters
	public abstract void setPosicion(int x,int y);
	//Getters
	public abstract int getX1();
	
	public abstract int getX2();
	
	public abstract int getY1();
	
	public abstract int getY2();
	

}