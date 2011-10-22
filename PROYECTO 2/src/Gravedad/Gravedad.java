package Gravedad;
import javax.swing.JOptionPane;
import Estructuras.*;
import Posicion.*;
import Auxiliares.*;
import Entidades.*;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Modela la gravedad, que va a ser utilizada para las caidas tanto del personaje principal, como de los enemigos e items
 * 
*/

public class Gravedad extends Thread {

	private Mario jugador;	//Personaje Principal
	private ListaSE<Entidad> lista;	//Lista de objetos en el Mapa
	private ListaSE<Entidad> piso;	//Lista que indica la posicion del piso.

	public Gravedad(Mario j, ListaSE<Entidad> l, ListaSE<Entidad> p) {
		this.lista = l;
		this.jugador = j;
		this.piso = p;
	}
	/**
	 * 
	 * Controlador de colisiones por debajo.
	 *
	 * @return True si hay colision por debajo del personaje principal
	 * 			False caso contrario
	 */
	public boolean intersect() {
		Cuadrado bordeMario = (Cuadrado) jugador.getBorde();
		for (Entidad aux : lista) {
			Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
			if (bordeMario.colisionaPorAbajo(bordeEntidad)) {
				jugador.setEstaSaltando(false);return true;
			}
		}
		for (Entidad aux2 : piso) {
			Cuadrado bordePiso = (Cuadrado) aux2.getBorde();
			if (bordeMario.colisionaPorAbajo(bordePiso)) {
				jugador.setEstaSaltando(false);return true;
				}
		}
		return false;

	}

	/**
	 * Hilo gravedad, se ejecuta durante todo el juego
	 */
	public void run() {

		while (true) {
			try {

				Cuadrado bordeMario = (Cuadrado) jugador.getBorde();
				JLabel label = jugador.getLabel();

				boolean control = false;
			

				control = this.intersect(); // CONTROL SI HAY ALGO ABAJO DE
											// MARIO.
				Thread.sleep(50);
				if (!control) {
					for (int i = 0; (i < 15) && (!control); i++) {

						jugador.setEstaSaltando(true);
						
						label.setLocation(label.getLocation().x,
								label.getLocation().y + 8);
						jugador.setPosicion(jugador.getPosicion().getX(),
								jugador.getPosicion().getY() + 8);
						jugador.setBorde(jugador.getBorde().getX1(), jugador
								.getBorde().getY1() + 8);
						jugador.getLabel().repaint();
						control=this.intersect();
						jugador.getLabel().repaint();
						if(jugador.getPosicion().getY()>450){JOptionPane.showMessageDialog(null,"Game Over");System.exit(0);}
						Thread.sleep(20);
					}

				}

			} catch (Exception e) {
			}

		}

	}
}
