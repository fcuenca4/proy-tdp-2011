package Movimiento;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import Estructuras.*;

import Auxiliares.Cuadrado;
import Entidades.*;
import Gravedad.Gravedad;

//Esta clase modela el movimiento del jugador hacia izquierda y derecha.

public class MovimientoManual extends Thread {

	private JPanel panel;
	private JPanel enemigos;
	private KeyEvent tecla;
	private Mario jugador;
	private Gravedad gravedad;

	public MovimientoManual(JPanel enemigos, JPanel p, KeyEvent t, Mario j,
			Gravedad g) {
		this.panel = p;
		this.enemigos = enemigos;
		this.tecla = t;
		this.jugador = j;
		this.gravedad = g;

	}

	public void run() {

		if (!jugador.estaMuerto()) {
			switch (tecla.getKeyCode()) {

			case KeyEvent.VK_LEFT: {
				while (!jugador.getFinish()) {
					try {

						Cuadrado bordeMario = (Cuadrado) jugador.getBorde();

						//Controla si hay un enemigo a su izquierda
						
						for (Malo enemie : jugador.getMalos()) {
							if (bordeMario
									.colisionaPorIzquierda((Cuadrado) enemie
											.getBorde())) {
								if (jugador.esInmortal())
									enemie.morir_disparo();
								else
									enemie.matar();
								

							}

						}
						
						//Controla si hay un item a si izquierda 
						
						for (Item item : jugador.getItems()) {
							if (item.getBorde() != null)
								if (bordeMario
										.colisionaPorIzquierda((Cuadrado) item
												.getBorde()))
									((Item) item).accion();
						}

						boolean control = false;
						
						//Controla si hay algun objeto que no lo deje avanzar a su izquierda
						
						for (Entidad aux : jugador.getObjetos()) {
							Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
							if (bordeMario.colisionaPorIzquierda(bordeEntidad)) {

								control = true;
								break;
							}
						}

						if ((!control) && (jugador.getPosicion().getX() >= 168)
						 && (jugador.getPosicion().getY() <= 490)  ) {
							jugador.setBorde(jugador.getBorde().getX1() - 8,
									jugador.getBorde().getY1());
							jugador.setPosicion(
									jugador.getPosicion().getX() - 8, jugador
											.getPosicion().getY());
							enemigos.setLocation(enemigos.getLocation().x + 8,
									enemigos.getLocation().y);

							panel.setLocation(panel.getLocation().x + 8,
									panel.getLocation().y);

						}

						Thread.sleep(40);

					} catch (Exception e) {
					}
				}

			}

			case KeyEvent.VK_RIGHT: {
				while (!jugador.getFinish()) {
					try {
						Cuadrado bordeMario = (Cuadrado) jugador.getBorde();

						//Controla si hay un enemigo a su derecha
						
						for (Malo enemie : jugador.getMalos()) {
							if (bordeMario
									.colisionaPorDerecha((Cuadrado) enemie
											.getBorde())) {
								if (jugador.esInmortal())
									enemie.morir_disparo();
								else 
									enemie.matar();
								

							}

						}
						
						//Controla si hay un item a su derecha.
						
						for (Item item : jugador.getItems()) {
							if (item.getBorde() != null)
								if (bordeMario
										.colisionaPorDerecha((Cuadrado) item
												.getBorde())) {
									((Item) item).accion();
									break;
								}

						}

						boolean control = false;
						
						//Controla si hay un objeto que no lo deje avanzar a su derecha.
						for (Entidad aux : jugador.getObjetos()) {
							Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
							if (bordeMario.colisionaPorDerecha(bordeEntidad)) {

								control = true;
								break;
							}
						}

						if ((!control) && (jugador.getPosicion().getX() <= 4640)
						 && (jugador.getPosicion().getY() <= 490) ) {
							jugador.setBorde(jugador.getBorde().getX1() + 8,
									jugador.getBorde().getY1());
							jugador.setPosicion(
									jugador.getPosicion().getX() + 8, jugador
											.getPosicion().getY());
							enemigos.setLocation(enemigos.getLocation().x - 8,
									enemigos.getLocation().y);
							panel.setLocation(panel.getLocation().x - 8,
									panel.getLocation().y);

							

						}
						if (jugador.getPosicion().getX() > 4640) jugador.finalizar();

						Thread.sleep(40);

					
					
					}

					catch (Exception e) {
					}
				}
			}
			}

		}
	}
}
