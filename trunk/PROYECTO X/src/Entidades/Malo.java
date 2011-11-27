package Entidades;

import javax.swing.JLabel;

import Estructuras.ListaSE;
import Gravedad.Gravedad;
import Movimiento.MovimientoArtificial;

//Clase abstracta para modelar el comportamiento de los enemigos en general.

public abstract class Malo extends Entidad {
	
	protected Mario jugador;
	protected JLabel puntos;
	protected ListaSE<BolaDeFuego> disparos;
	protected ListaSE<Entidad> limitadores;

	
	public abstract void morir ();
	
	public abstract void morir_disparo();
	
	public Mario getJugador()
	{
		return jugador;
	}
	
	public ListaSE<BolaDeFuego> getDisparos()
	{
		return disparos;
	}
	
	public ListaSE<Entidad> getLimitadores()
	{
		return limitadores;
	}
	
	public abstract void matar();

}
