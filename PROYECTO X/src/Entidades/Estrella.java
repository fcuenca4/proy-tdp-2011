package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Gravedad.Gravedad;
import Movimiento.MovimientoArtificial;
import Posicion.Posicion;


//Clase que representa a la estrella que hace invencible a Mario

public class Estrella extends Item {

	private MovimientoArtificial inteligencia;
	private Gravedad gravedad;
	
	
	
	public Estrella(int x,int y,ListaSE<Entidad> o,ListaSE<Entidad> p,Mario player,JLabel puntos)
	{
		this.objetos=o;
		this.piso=p;
		this.puntos=puntos;
		this.jugador=player;
		this.pos=new Posicion(x,y);
		this.inteligencia=new MovimientoArtificial(this,3);
		this.gravedad=new Gravedad(this,2);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/Starman.gif"));
		this.label=new JLabel(imagen);
		this.label.setBounds(x,y,32,32);
		this.borde=new Cuadrado(x,y,null,32,32);
		this.inteligencia.start();
		this.gravedad.start();
		
	}
	
	/**
	 * Hace invencible a Mario,cuando este agarra a la estrella.Y desaparece la estrella.
	 */
		
	public void accion()
	{
		int puntosviejos=Integer.parseInt(puntos.getText());
		if(jugador.esInmortal())this.puntos.setText(String.valueOf(puntosviejos+35));
		else {this.puntos.setText(String.valueOf(puntosviejos+20));
		jugador.setInmortal();}
		
		
		
		this.label.setIcon(null);
		this.gravedad.stop();
		this.inteligencia.stop();
		
		this.borde=null;
		this.jugador=null;
		this.label=null;
		this.objetos=null;
		this.piso=null;
		this.pos=null;
		
		
	}
}
