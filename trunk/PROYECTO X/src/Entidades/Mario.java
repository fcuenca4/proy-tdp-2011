package Entidades;

import Cuerpo.*;
import Estructuras.ListaSE;
import Gravedad.Gravedad;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Image;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import Auxiliares.*;
import java.io.*;

import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.Graphics2D;
import javax.swing.*;

import Main.Juego;
import Movimiento.MovimientoManual;
import Movimiento.Salto;
import Posicion.Posicion;

/**
 * Esta clase hospeda el personaje principal del juego, encargada de darle forma
 * logica al mismo
 * 
 */

public class Mario extends Entidad {
	
	private boolean finish;
	
	private boolean mirandoIzquierda;
	private boolean mirandoDerecha;
	private boolean estaQuieto;
	
	private boolean estaSaltando;// Variable de control
	private SpriteAnimado actual;// Sprite Actual
	
	private SpriteAnimado quieto;// Sprite Quieto
	private SpriteAnimado quietoIzq;// Sprite Quieto Izquierdo
	private SpriteAnimado derecha;// Sprite
	private SpriteAnimado izquierda;// Sprite
	private SpriteAnimado salto;
	private SpriteAnimado quietoDerechaGrande;
	private SpriteAnimado quietoIzquierdaGrande;
	private SpriteAnimado quietoIzquierdaPoderoso;
	private SpriteAnimado quietoDerechaPoderoso;
	private SpriteAnimado derechaGrande;
	private SpriteAnimado izquierdaGrande;
	private SpriteAnimado derechaPoderoso;
	private SpriteAnimado izquierdaPoderoso;
	private SpriteAnimado muerto;

	private SpriteAnimado invencibleChiquitoQuietoD;
	private SpriteAnimado invencibleChiquitoQuietoI;
	private SpriteAnimado invencibleGrandeQuietoD;
	private SpriteAnimado invencibleGrandeQuietoI;
	private SpriteAnimado invencibleChiquitoI;
	private SpriteAnimado invencibleChiquitoD;
	private SpriteAnimado invencibleGrandeI;
	private SpriteAnimado invencibleGrandeD;
	

	private boolean estaMuerto;// Variable de control
	private Animada movimiento;
	private boolean esChiquito;
	private boolean esGrande;
	private boolean esInmortal;
	private boolean esPoderoso;
	private int vidas;
	
	private Juego juego;
	private JLabel etiq_vidas;
	private JLabel etiq_puntos;

	// Constructor
	public Mario(int i, int j, ListaSE<Entidad> piso, ListaSE<Entidad> objetos,
			ListaSE<Malo> malos, ListaSE<Item> items,Juego juego,JLabel etiq_vidas,JLabel etiq_puntos) {
		this.items = items;
		this.objetos = objetos;
		this.piso = piso;
		this.malos = malos;
		this.esChiquito = true;
		this.esGrande = false;
		this.esPoderoso = false;
		this.esInmortal = false;
		this.estaSaltando = false;
		this.pos = new Posicion(i, j);
		this.vidas=1;
		this.etiq_vidas=etiq_vidas;
		this.etiq_puntos=etiq_puntos;
	
	
		
		ImageIcon imagen = new ImageIcon(getClass().getResource(
				"/Imagenes/Mario.gif"));
		this.label = new JLabel();
		this.juego=juego;

		this.esChiquito = true;
		this.mirandoDerecha = true;
		this.mirandoIzquierda = false;
		label.setIcon(imagen);
		label.setBounds(i, j, 32, 32);
		this.borde = new Cuadrado(i, j, this, 32, 32);
		this.movimiento = new Animada(this, 1);
		movimiento.start();

		this.quieto = new SpriteAnimado();
		this.quieto.setearTemporal(false);
		this.quieto.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario.gif")));

		this.quietoIzq = new SpriteAnimado();
		this.quietoIzq.setearTemporal(false);
		this.quietoIzq.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/MarioI.gif")));

		this.izquierda = new SpriteAnimado();
		this.izquierda.setearTemporal(false);
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario - WalkI1.gif")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario - WalkI2.gif")));

		this.izquierdaGrande = new SpriteAnimado();
		this.izquierdaGrande.setearTemporal(false);
		this.izquierdaGrande.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Super Mario - WalkI2.gif")));
		this.izquierdaGrande.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Super Mario - WalkI3.gif")));

		this.derecha = new SpriteAnimado();
		this.derecha.setearTemporal(false);
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario - Walk1.gif")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario - Walk2.gif")));

		this.quietoDerechaGrande = new SpriteAnimado();
		this.quietoDerechaGrande.setearTemporal(false);
		this.quietoDerechaGrande.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Super Mario.gif")));

		this.quietoIzquierdaGrande = new SpriteAnimado();
		this.quietoIzquierdaGrande.setearTemporal(false);
		this.quietoIzquierdaGrande.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Super MarioI.gif")));

		this.derechaGrande = new SpriteAnimado();
		this.derechaGrande.setearTemporal(false);
		this.derechaGrande.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Super Mario - Walk2.gif")));
		this.derechaGrande.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Super Mario - Walk3.gif")));

		this.salto = new SpriteAnimado();
		this.salto.setearTemporal(false);
		this.salto.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Mario - Jump.gif")));

		this.quietoIzquierdaPoderoso = new SpriteAnimado();
		this.quietoIzquierdaPoderoso.setearTemporal(false);
		this.quietoIzquierdaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery MarioI.gif")));

		this.quietoDerechaPoderoso = new SpriteAnimado();
		this.quietoDerechaPoderoso.setearTemporal(false);
		this.quietoDerechaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery Mario.gif")));

		this.derechaPoderoso = new SpriteAnimado();
		this.derechaPoderoso.setearTemporal(false);
		this.derechaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery Mario - Walk2.gif")));
		this.derechaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery Mario - Walk3.gif")));

		this.izquierdaPoderoso = new SpriteAnimado();
		this.izquierdaPoderoso.setearTemporal(false);
		this.izquierdaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery Mario - WalkI2.gif")));
		this.izquierdaPoderoso.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/Fiery Mario - WalkI3.gif")));

		this.invencibleChiquitoD = new SpriteAnimado();
		this.invencibleChiquitoD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoD1.gif")));
		this.invencibleChiquitoD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoD2.gif")));

		this.invencibleChiquitoI = new SpriteAnimado();
		this.invencibleChiquitoI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoI1.gif")));
		this.invencibleChiquitoI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoI2.gif")));

		this.invencibleGrandeD = new SpriteAnimado();
		this.invencibleGrandeD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeD1.gif")));
		this.invencibleGrandeD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeD2.gif")));

		this.invencibleGrandeI = new SpriteAnimado();
		this.invencibleGrandeI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeI1.gif")));
		this.invencibleGrandeI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeI2.gif")));

		this.invencibleGrandeD = new SpriteAnimado();
		this.invencibleGrandeD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeD1.gif")));
		this.invencibleGrandeD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeD2.gif")));

		this.invencibleGrandeI = new SpriteAnimado();
		this.invencibleGrandeI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeI1.gif")));
		this.invencibleGrandeI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleGrandeI2.gif")));

		this.invencibleChiquitoQuietoD = new SpriteAnimado();
		this.invencibleChiquitoQuietoD.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoQuietoD.gif")));

		this.invencibleChiquitoQuietoI = new SpriteAnimado();
		this.invencibleChiquitoQuietoI.AgregarImagen(new ImageIcon(getClass()
				.getResource("/Imagenes/invencibleChiquitoQuietoI.gif")));
		
		this.invencibleGrandeQuietoD=new SpriteAnimado();
		this.invencibleGrandeQuietoD.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/invencibleGrandeQuietoD.gif")));
		
		this.invencibleGrandeQuietoI=new SpriteAnimado();
		this.invencibleGrandeQuietoI.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/invencibleGrandeQuietoI.gif")));
		
		this.muerto=new SpriteAnimado();
		this.muerto.AgregarImagen(new ImageIcon(getClass().getResource("/Imagenes/Mario - Dead.gif")));
		
		

	}

	// Setters

	public void setBorde(int i, int j) {
		this.borde.setPosicion(i, j);
	}

	public void setEstaSaltando(boolean b) {
		this.estaSaltando = b;
	}

	public void setChiquito() {

		if (actual == izquierda) {
		
			this.actual = quietoIzq;
		}
		if (actual == derecha) {
			
			this.actual = quieto;
		}

		if (!esChiquito) {
			this.borde = new Cuadrado(borde.getX1(), borde.getY1() + 32, this,
					32, 32);
			this.label.setBounds(label.getLocation().x,
					label.getLocation().y + 32, 32, 32);
		}

		this.esChiquito = true;
		this.esGrande = false;
		this.esPoderoso = false;
		if(estaQuieto && mirandoDerecha){quieto();return;}
		if(estaQuieto && mirandoIzquierda){quietoI();return;}
		if(!estaQuieto && mirandoDerecha) {derecha();return;}
		if(!estaQuieto && mirandoIzquierda){izquierda();return;}
	}

	public void setGrande() {
		
		
		if (!esGrande) {
			
			this.borde = new Cuadrado(borde.getX1(), borde.getY1() - 32, this,
					32, 64);
			this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Super Mario.gif")));
			
			this.label.setBounds(label.getLocation().x,
				label.getLocation().y - 32, 32, 64);
			
			
			
		}
		this.esChiquito = false;
		this.esGrande = true;
		this.esPoderoso = false;
		if(estaQuieto && mirandoDerecha){quieto();return;}
		if(estaQuieto && mirandoIzquierda){quietoI();return;}
		if(!estaQuieto && mirandoDerecha) {derecha();return;}
		if(!estaQuieto && mirandoIzquierda){izquierda();return;}

	}

	public void setInmortal() {
		this.esInmortal = true;
		Timer timer = new Timer(15000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (esGrande) {
					esInmortal = false;
					setGrande();
				} else {
					esInmortal = false;
					setChiquito();
				}
			}
		});

		timer.start();

		timer.setRepeats(false);
	}

	public void setPoderoso() {
		if (!esPoderoso && esGrande) {
			this.esChiquito = false;
			
			this.esPoderoso = true;

		}
		if (!esPoderoso && !esGrande) {
			setGrande();
		}

	}
	
	public void setMuerto(boolean e)
	{
		estaMuerto=e;
	}

	// Getters
	public boolean getEstaSaltando() {
		return this.estaSaltando;
	}

	public SpriteAnimado getActual() {
		return actual;
	}

	/**
	 * 
	 * Establece la animacion hacia la derecha
	 * 
	 */
	public void derecha() {
		this.mirandoIzquierda = false;
		this.mirandoDerecha = true;
		this.estaQuieto=false;
	
		if (esInmortal && esChiquito) {
			this.actual = this.invencibleChiquitoD;
			return;
		}
		if (esInmortal && esGrande) {
			this.actual = this.invencibleGrandeD;
			return;
		}
		if (esChiquito)
			this.actual = this.derecha;
		if (esGrande)
			this.actual = this.derechaGrande;
		if (esPoderoso)
			this.actual = this.derechaPoderoso;

	}

	/**
	 * 
	 * Establece la animacion hacia la izquierda
	 * 
	 */
	public void izquierda() {
		this.mirandoIzquierda = true;
		this.mirandoDerecha = false;
		this.estaQuieto=false;
		

		if (esInmortal && esChiquito) {
			this.actual = this.invencibleChiquitoI;
			return;
		}
		if (esInmortal && esGrande) {
			this.actual = this.invencibleGrandeI;
			return;
		}
		if (esChiquito) {
			this.actual = this.izquierda;
		}
		if (esGrande) {
			this.actual = this.izquierdaGrande;
		}
		if (esPoderoso) {
			this.actual = this.izquierdaPoderoso;
		}

	}

	/**
	 * 
	 * Establece la animacion dejando el personaje quieto
	 * 
	 */
	public void quieto() {
		
		this.estaQuieto=true;
		if (esInmortal && esChiquito) {
			this.actual = this.invencibleChiquitoQuietoD;
			return;
		}
		if (esInmortal && esGrande) {
			this.actual = this.invencibleGrandeQuietoD;
			return;
		}
		if (esChiquito)
			this.actual = this.quieto;
		if (esGrande)
			this.actual = this.quietoDerechaGrande;
		if (esPoderoso)
			this.actual = this.quietoDerechaPoderoso;
	}

	/**
	 * 
	 * Establece la animacion dejando el personaje quieto, pero mirando hacia la
	 * izquierda
	 * 
	 */
	public void quietoI() {
		
		this.estaQuieto=true;
		if (esInmortal && esChiquito) {
			this.actual = this.invencibleChiquitoQuietoI;
			return;
		}
		if (esInmortal && esGrande) {
			this.actual = this.invencibleGrandeQuietoI;
			return;
		}
		if (esChiquito) {
			this.actual = this.quietoIzq;
		}
		if (esGrande) {
			this.actual = this.quietoIzquierdaGrande;
		}
		if (esPoderoso) {
			this.actual = this.quietoIzquierdaPoderoso;
		}

	}

	
	/**
	 * 
	 * Mata el personaje principal,sino tiene vidas,
	 * disparando un cartel de dialogo y cerrando
	 * el juego.Si le quedan vidas se descuentan los puntos
	 * y se reinicia el juego.
	 */
	public void morir() {
		
		int vidasviejas=Integer.parseInt(this.etiq_vidas.getText());
		this.etiq_vidas.setText(String.valueOf(vidasviejas-1));
		
		 if(vidas==0){JOptionPane.showMessageDialog(null, "Game Over");System.exit(0);}
			else{decrementarVida();juego.reiniciar();}
		
		}
	
	
	/**
	 * Simula una animacion con el jugador y finaliza la aplicacion
	 * cuando se termina el nivel.
	 */
	public void finalizar()
	{
		this.setFinish(true);
		Timer timer=new Timer(70,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(esChiquito) actual=derecha;
				else{
					if(esPoderoso) actual=derechaPoderoso;
					else	actual=derechaGrande;
				}
				label.setLocation(label.getLocation().x+8,label.getLocation().y);
				borde.setPosicion(borde.getX1()+8,borde.getY1());
				pos.setX(pos.getX()+8);
				if (pos.getX() == 4800) {
					JOptionPane
							.showMessageDialog(null, "Ganaste !");
					System.exit(0);
				}
			}
		});
		
		
		
		
		
		timer.start();
		timer.setRepeats(true);
		
		
		
	}
		
		
		
	

	public boolean esChiquito() {
		return esChiquito;
	}

	public boolean esGrande() {
		return esGrande;
	}

	public boolean esPoderoso() {
		return esPoderoso;
	}

	public boolean esInmortal() {
		return esInmortal;
	}
	
	public boolean estaMuerto() {
		return estaMuerto;
	}


	public boolean mirandoIzquierda() {
		return mirandoIzquierda;
	}
	
	public void aumentarVida()
	{
		this.vidas+=1;
	}
	
	public void decrementarVida()
	{
		this.vidas-=1;
	}
	
	public void aumentarPuntos(int n)
	{
		int puntosviejos=Integer.parseInt(this.etiq_puntos.getText());
		this.etiq_puntos.setText(String.valueOf(puntosviejos+n));
	}
	
	public void decrementarPuntos(int n)
	{
		int puntosviejos=Integer.parseInt(this.etiq_puntos.getText());
		this.etiq_puntos.setText(String.valueOf(puntosviejos-n));
	}

	public boolean getFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	

	
	
	
}
