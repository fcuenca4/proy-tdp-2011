package Entidades;

import Auxiliares.Cuadrado;
import Posicion.Posicion;

//Sirve como indicador de los limites por los cuales los enemigos pueden transitar.

public class Limitador extends Entidad {
	
	public Limitador(int i,int j)
	{
		this.pos=new Posicion(i,j);
		this.borde=new Cuadrado(i,j,null,32,32);
	}

}
