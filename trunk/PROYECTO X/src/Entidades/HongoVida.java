package Entidades;

import javax.swing.ImageIcon; 
import javax.swing.JLabel;
import Posicion.*;
import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Estructuras.Position;
import Movimiento.MovimientoArtificial;
import Gravedad.*;


//Esta clase representa al hongo verde que suma una vida a Mario.

public class HongoVida extends Item {
	
	private MovimientoArtificial inteligencia;
	private Gravedad gravedad;


	
	public HongoVida(int x,int y,ListaSE<Entidad> o,ListaSE<Entidad> p,Mario player,JLabel puntos,JLabel vidas)
	{
		this.objetos=o;
		this.piso=p;
		this.vidas=vidas;
		this.puntos=puntos;
		this.jugador=player;
		this.pos=new Posicion(x,y);
		this.inteligencia=new MovimientoArtificial(this,3);
		this.gravedad=new Gravedad(this,2);
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/oneUp.png"));
		this.label=new JLabel(imagen);
		this.label.setBounds(x,y,32,32);
		this.borde=new Cuadrado(x,y,null,32,32);
		this.inteligencia.start();
		this.gravedad.start();
		
	}
	
	/**
	 * Accion que realiza sobre Mario cuando agarra el hongo verde.Y desaparecer al hongo
	 */
	
	 
	public void accion()
	{
		//System.out.println("Vida");
		
		int puntosviejos=Integer.parseInt(puntos.getText());
		int vidasviejas=Integer.parseInt(vidas.getText());
		this.puntos.setText(String.valueOf(puntosviejos+100));
		this.vidas.setText(String.valueOf(vidasviejas+1));
		this.jugador.aumentarVida();
		this.jugador.aumentarPuntos(100);
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
		this.puntos=null;
		this.vidas=null;
		
		this.items=null;
		
	}
	
	
	
	
	
	
}