package Entidades;
import javax.swing.*; 
import javax.swing.Timer;

   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.*;
import Posicion.*;
import Auxiliares.*;
import Movimiento.MovimientoArtificial;
import Estructuras.*;
import Gravedad.Gravedad;

//Esta clase representa a Goomba.


public class Goomba extends Malo {
	
	private MovimientoArtificial inteligencia;   //Inteligencia del personaje.
	
	
	public Goomba(int i,int j,ListaSE<Entidad> o,ListaSE<Entidad> piso,ListaSE<BolaDeFuego> disparos,ListaSE<Entidad>limitadores,Mario jug,JLabel p){
		
		this.jugador=jug;
		this.objetos=o;
		this.piso=piso;
		this.disparos=disparos;
		this.limitadores=limitadores;
		this.pos=new Posicion(i,j);
		
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/Goomba.gif"));
		this.label=new JLabel(imagen);
		this.label.setBounds(i,j,32,32);
		this.borde=new Cuadrado(i,j,null,32,32);
		this.puntos=p;
		this.inteligencia=new MovimientoArtificial(this,1);
		
		this.inteligencia.start();
		
		
		
		
	}
	
	/**
	 * Accion que realiza sobre Mario cuando Goomba lo mata.
	 */
	
	public void matar()
	{
		
		if (jugador.esChiquito()){
			jugador.morir();
			jugador.decrementarPuntos(30);
		}
		if (jugador.esGrande())
			jugador.setChiquito();
	}
	
	
	
	/**
	 *Mata a Goomba cuando este es aplastado
	 * y realiza una animacion con el personaje
	 */
	public void morir ()
	{try{
		this.label.setBounds(label.getLocation().x,label.getLocation().y+4,32,32);
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Goomba Aplastado.png")));
		Timer timer = new Timer (800, new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		        label.setIcon(null);
		     } 
		}); 
		

		timer.start();
		
		timer.setRepeats(false);
		
		this.borde=new Cuadrado(0,0,null,0,0);
		this.pos=new Posicion(0,0);
		int puntosviejos=Integer.parseInt(puntos.getText());
		this.puntos.setText(String.valueOf(puntosviejos+60));
		
		inteligencia.stop();
		
		this.jugador=null;
		this.objetos=null;
		this.pos=null;
		this.borde=null;
		
		
		
		
		}
	catch(Exception e){}
	 	
		
	}
	
	/**
	 *Mata a Goomba cuando este es alcanzado por una bola de fuego
	 * o cuando el jugador uso la bomba nuclear.Realiza una animacion.
	 */
	public void morir_disparo ()
	{
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/GoombaDadoVuelta.gif")));
		Timer timer = new Timer (60, new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	  label.setLocation(label.getLocation().x+4,label.getLocation().y+8);
		     } 
		}); 
		

		timer.start();
		
		timer.setRepeats(true);
		this.borde=new Cuadrado(0,0,null,0,0);
		this.pos=new Posicion(0,0);
		int puntosviejos=Integer.parseInt(puntos.getText());
		this.puntos.setText(String.valueOf(puntosviejos+60));
		inteligencia.stop();
		this.jugador=null;
		this.objetos=null;
		this.pos=null;
		this.borde=null;
	
		
		
		
		
	
	 	
		
	}
	
	
}
