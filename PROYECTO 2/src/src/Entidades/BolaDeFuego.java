package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Movimiento.Disparo;
import Posicion.Posicion;


//Esta clase representa a las bolas de fuego que dispara Mario

public class BolaDeFuego extends Entidad {

	private Mario jugador;
	private Disparo disparo;   //Inteligencia del disparo
	private JPanel panel;
	
	public BolaDeFuego(Mario jug,ListaSE<Entidad> o,ListaSE<Malo> e,JPanel p)
	{
		this.objetos=o;
		this.malos=e;
		this.jugador=jug;
		this.panel=p;
		this.pos=new Posicion(jugador.getPosicion().getX(),jugador.getPosicion().getY()+10);
		
		this.borde=new Cuadrado(jugador.getPosicion().getX(),jugador.getPosicion().getY(),null,16,16);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/Fire-bar.gif"));
		this.label=new JLabel(imagen);
		this.label.setBounds(jugador.getPosicion().getX()+8,jugador.getPosicion().getY(),16,16);
		panel.add(label);
		if(jugador.mirandoIzquierda()){this.disparo=new Disparo(jugador,objetos,malos,0,this);}
		else{this.disparo=new Disparo(jugador,objetos,malos,1,this);}
		this.disparo.start();
	}


	/**
	 * Hace desaparecer a la bola de fuego
	 */
	
	public void desaparecer()
	{
		this.label.setIcon(null);
		this.borde=new Cuadrado(0,0,null,0,0);
		this.disparo.stop();
		
		
		this.malos=null;
		this.objetos=null;
		this.pos=null;
	}

}
