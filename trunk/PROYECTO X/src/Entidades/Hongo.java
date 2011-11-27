package Entidades;

import javax.swing.ImageIcon; 
import javax.swing.JLabel;
import Posicion.*;
import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Movimiento.MovimientoArtificial;
import Gravedad.*;


//Esta clase representa al hongo que hace crecer a Mario

public class Hongo extends Item {
	
	
	

	
	public Hongo(int x,int y,ListaSE<Entidad> o,ListaSE<Entidad> p,Mario player,JLabel puntos)
	{
		this.objetos=o;
		this.piso=p;
		this.puntos=puntos;
		this.jugador=player;
		this.pos=new Posicion(x,y);
		this.inteligencia=new MovimientoArtificial(this,3);
		this.gravedad=new Gravedad(this,2);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/mushroom.png"));
		this.label=new JLabel(imagen);
		this.label.setBounds(x,y,32,32);
		this.borde=new Cuadrado(x,y,null,32,32);
		this.inteligencia.start();
		this.gravedad.start();
		
	}
	
	/**
	 * Accion que realiza sobre Mario cuando agarra al hongo.Y desaparece al hongo
	 */
	
	 
	public void accion()
	{
		//System.out.println("grande !");
		int puntosviejos=Integer.parseInt(puntos.getText());
		if(jugador.esChiquito()) {this.puntos.setText(String.valueOf(puntosviejos+10));jugador.setGrande();}
		else this.puntos.setText(String.valueOf(puntosviejos+50));
		
		this.borde=new Cuadrado(0,0,null,0,0);
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
