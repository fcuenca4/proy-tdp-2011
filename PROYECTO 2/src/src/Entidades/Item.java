package Entidades;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Gravedad.Gravedad;
import Movimiento.MovimientoArtificial;


//Clase abstracta para modelar el comportamiento de los items en general.

public abstract class Item extends Entidad {
	
	
	protected Mario jugador;
	protected boolean fueAgarrado;
	protected MovimientoArtificial inteligencia;
	protected Gravedad gravedad;
	protected JLabel puntos;
	protected JLabel vidas;
	

	public abstract void accion();
	
	public void setObjetos(ListaSE<Entidad> o)
	{
		objetos=o;
	}
	
	public void setPiso(ListaSE<Entidad> p)
	{
		piso=p;
	}
	
	public void setJugador(Mario player)
	{
		this.jugador=player;
	}
	
	public boolean fueAgarrado()
	{
		return this.fueAgarrado;
	}
	
	public Mario getJugador()
	{
		return jugador;
	}
	
	public void destruir()
	{
		
		this.label=null;
		this.borde=new Cuadrado(0,0,null,0,0);
		this.gravedad.stop();
		this.inteligencia.stop();
	}
	
	
	
	
}
