package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Auxiliares.Cuadrado;
import Posicion.Posicion;


//Esta clase representa a la flor que permite al jugador disparar Bolas de Fuego

public class Flor extends Item {
	
	private Mario jugador;
	
	
	
	public Flor(int i,int j,Mario player,JLabel puntos,JLabel vidas)
	{
		this.pos=new Posicion(i,j);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/fireFlower.png"));
		this.label=new JLabel(imagen);
		this.label.setBounds(i,j,32,32);
		this.vidas=vidas;
		this.puntos=puntos;
		this.borde=new Cuadrado(i,j,null,32,32);
		this.jugador=player;
	}
	
	/**
	 * Accion que realiza sobre Mario cuando este agarra a la flor.Y desaparece la flor.
	 */
	
	public	void accion()
	{
	
		if(jugador.esChiquito()){jugador.setGrande();
								int puntosviejos=Integer.parseInt(puntos.getText());
								this.puntos.setText(String.valueOf(puntosviejos+5));
		}
		else{if(jugador.esPoderoso()){
			int puntosviejos=Integer.parseInt(puntos.getText());
			this.puntos.setText(String.valueOf(puntosviejos+50));
			}
		else{
			jugador.setPoderoso();
			int puntosviejos=Integer.parseInt(puntos.getText());
		this.puntos.setText(String.valueOf(puntosviejos+20));
		}}

		
		this.label.setIcon(null);
		this.borde=null;
		this.jugador=null;
		this.label=null;
		this.objetos=null;
		this.piso=null;
		this.pos=null;
	}

}

