package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Posicion.Posicion;

//Esta clase representa a la Bomba Nuclear

public class Bomba extends Item {

	private ListaSE<Malo> enemigos;    //Almacena a los enemigos

	public Bomba(int i, int j, JLabel puntos, JLabel vidas,
			ListaSE<Malo> enemigos, Mario jugador) {
		this.pos = new Posicion(i, j);
		ImageIcon imagen = new ImageIcon(getClass().getResource(
				"/Imagenes/bomba.png"));
		this.label = new JLabel(imagen);
		this.label.setBounds(i, j, 32, 32);
		this.vidas = vidas;
		this.puntos = puntos;
		this.borde = new Cuadrado(i, j, null, 32, 32);
		this.enemigos = enemigos;
		this.jugador = jugador;

	}
	
	/**
	 * Mata a todos los enemigos que estan en la pantalla.Y desaparece la bomba.
	 */

	public void accion() {

		this.label.setIcon(null);
		for (Malo enemie : this.enemigos) {
			if (enemie.getPosicion() != null) {
				Posicion pos = enemie.getPosicion();
				if (pos.getX() >= jugador.getPosicion().getX()-160
						&& pos.getX() <= jugador.getPosicion().getX() + 352) {
					enemie.morir_disparo();
				}
			}
		}
		jugador.decrementarPuntos(45);
		this.borde = null;
		this.jugador = null;
		this.label = null;
		this.objetos = null;
		this.piso = null;
		this.pos = null;
	}

}
