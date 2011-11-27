package Gravedad;

import javax.swing.JOptionPane;
import Estructuras.*;
import Movimiento.MovimientoManual;
import Movimiento.Salto;
import Posicion.*;
import Auxiliares.*;
import Entidades.*;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Modela la gravedad, que va a ser utilizada para las caidas tanto del
 * personaje principal, como de los enemigos e items
 * 
 */

public class Gravedad extends Thread {

	private Entidad entidad; // Entidad que esta manejando la gravedad
	private int control;
	

	public Gravedad(Entidad j, int aux) {

		this.entidad = j;
		this.control = aux;  //Si es 1,es Mario.
		

	}

	/**
	 * 
	 * Controlador de colisiones por debajo.
	 * 
	 * @return True si hay colision por debajo del personaje principal False
	 *         caso contrario
	 */
	public boolean intersect() {
		Cuadrado bordeObjeto = (Cuadrado) entidad.getBorde();
		for (Entidad aux : entidad.getObjetos()) {
			Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
			if (bordeObjeto.colisionaPorAbajo(bordeEntidad)) {
				if (control == 1) {
					((Mario) entidad).setEstaSaltando(false);
				}

				return true;
			}
		}
		for (Entidad aux2 : entidad.getPiso()) {
			Cuadrado bordePiso = (Cuadrado) aux2.getBorde();
			if (bordeObjeto.colisionaPorAbajo(bordePiso)) {
				if (control == 1) {
					((Mario) entidad).setEstaSaltando(false);
				}
				return true;
			}
		}
	
		if(control!=1){
			Item item = ((Item) entidad);
			if (bordeObjeto.colisionaPorAbajo((Cuadrado) item.getJugador()
					.getBorde())) {
				System.out.println("item busco mario");
				item.accion();
				
				return true;
			}}
		if (control == 1) {

			for (Item it : entidad.getItems()) {
				if (bordeObjeto.colisionaPorAbajo((Cuadrado) it.getBorde())) {
					it.accion();
					break;
				}
			}

			for (Malo enemie : entidad.getMalos()) {
				if (bordeObjeto.colisionaPorAbajo((Cuadrado) enemie.getBorde())) {
					if(control==1)
					{if(((Mario)entidad).esInmortal())enemie.morir_disparo();
					else enemie.morir();}
					final Salto aux=new Salto(this,(Mario)entidad);
					aux.start();
					Timer timer = new Timer (1000, new ActionListener () 
					{ 
					    public void actionPerformed(ActionEvent e) 
					    { 
					        aux.stop();
					     } 
					}); 
					

					timer.start();
					
					timer.setRepeats(false);
					break;
				}
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

				Cuadrado bordeMario = (Cuadrado) entidad.getBorde();

				JLabel label = entidad.getLabel();

				boolean control = false;

				control = this.intersect(); // CONTROL SI HAY ALGO ABAJO DE
											// MARIO.
				Thread.sleep(10);

				if (!control) {
					if (this.control == 1) {
						((Mario) entidad).setEstaSaltando(true);
					}
					for (int i = 0; (i < 15) && (!control); i++) {

						label.setLocation(label.getLocation().x,
								label.getLocation().y + 8);
						entidad.setPosicion(entidad.getPosicion().getX(),
								entidad.getPosicion().getY() + 8);
						entidad.setBorde(entidad.getBorde().getX1(), entidad
								.getBorde().getY1() + 8);

						
						control = this.intersect();
						
						if(this.control==1)if(entidad.getPosicion().getY()>490){((Mario)entidad).decrementarPuntos(15);((Mario)entidad).morir();}
						Thread.sleep(20);
					}

				}

			} catch (Exception e) {
			}

		}

	}
}
