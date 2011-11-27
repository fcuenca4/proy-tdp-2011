package Movimiento;

import Entidades.*;
import Auxiliares.*;
import Estructuras.ListaSE;

//Esta clase modela el movimiento de los items y de los enemigos

public class MovimientoArtificial extends Thread {

	private Entidad entidad;
	private int control;     // 1:Goomba;2:KoopaTroopa;3:Item;
	public MovimientoArtificial(Entidad m, int aux) {

		this.entidad = m;
		this.control = aux;

	}

	public void run() {
		while (true) {
			Cuadrado bordeentidad = (Cuadrado) this.entidad.getBorde();

			boolean i = false;
			boolean d = false;

			
			
			while (!i) {
				try {
					switch (control) {
					case 1: {
						Mario jugador = ((Malo) entidad).getJugador();

						//Controla si hay una bola de fuego a su izquierda
						
						for (BolaDeFuego bola : (((Malo) entidad).getDisparos())) {
							if (bordeentidad
									.colisionaPorIzquierda(((Cuadrado) bola
											.getBorde()))) {
								((Malo) entidad).morir_disparo();
							}
						}

						//Controla si hay un limitador a su izquierda.
						
						for (Entidad lim : ((Malo) entidad).getLimitadores()) {
							Cuadrado bordeEntidad = (Cuadrado) lim.getBorde();
							if (bordeentidad
									.colisionaPorIzquierda(bordeEntidad)) {
								i = true;
							}
						}
						
						//Controla si esta Mario a su izquierda
						
						if (bordeentidad
								.colisionaPorIzquierda((Cuadrado) jugador
										.getBorde())) {
							if (jugador.esInmortal()) {
								((Malo) entidad).morir_disparo();
							} else 
								((Malo)entidad).matar();
							
						}
						break;
					}
					case 2: {
						Mario jugador = ((Malo) entidad).getJugador();
						((KoopaTroopa) entidad).izquierda();
						
						//Controla si hay una bola de fuego a su izquierda
						
						for (BolaDeFuego bola : (((Malo) entidad).getDisparos())) {
							if (bordeentidad
									.colisionaPorIzquierda(((Cuadrado) bola
											.getBorde()))) {
								((Malo) entidad).morir_disparo();
							}
						}
						
						//Controla si hay un limitador a su izquierda.
						
						for (Entidad lim : ((Malo) entidad).getLimitadores()) {
							Cuadrado bordeEntidad = (Cuadrado) lim.getBorde();
							if (bordeentidad
									.colisionaPorIzquierda(bordeEntidad)) {
								i = true;
							}
						}
						
						
						//Controla si esta Mario a su izquierda
						
						if (bordeentidad
								.colisionaPorIzquierda((Cuadrado) jugador
										.getBorde())) {
							if (jugador.esInmortal()) {
								((Malo) entidad).morir_disparo();
							} else 
								((Malo)entidad).matar();
						}
						break;
					}

					case 3: {
						Mario jugador = ((Item) entidad).getJugador();
						
						//Controla si esta Mario a su izquierda
						
						if (bordeentidad
								.colisionaPorIzquierda((Cuadrado) jugador
										.getBorde())) {
							((Item) entidad).accion();
						}
						break;
					}
				
				}
						
				//Controla si hay un objeto que no lo deje avanzar a su izquierda,si lo hay cambia de direccion.
					
					for (Entidad aux : entidad.getObjetos()) {
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						if (bordeentidad.colisionaPorIzquierda(bordeEntidad)) {
							i = true;
						}
					}
					

				//Actualizo la posicion de la entidad
					
					if (!i) {
						entidad.setBorde(entidad.getBorde().getX1() - 8,
								entidad.getBorde().getY1());
						entidad.setPosicion(entidad.getPosicion().getX() - 8,
								entidad.getPosicion().getY());
						entidad.getLabel().setLocation(
								entidad.getLabel().getLocation().x - 8,
								entidad.getLabel().getLocation().y);

						Thread.sleep(30);					//Hago que las balas se muevan mas rapido
						if(control!=4){Thread.sleep(30);}          

					}
					if (entidad.getPosicion().getX() < 10 && control == 2) {
						Item item = ((Item) entidad);
						item.destruir();

					}
				} catch (Exception e) {
				}

			}

			while (!d) {
				try {
					switch (control) {
					case 1: {
						Mario jugador = ((Malo) entidad).getJugador();
						
						//Controla si hay una bola de fuego a su derecha
						
						for (BolaDeFuego bola : (((Malo) entidad).getDisparos())) {
							if (bordeentidad
									.colisionaPorDerecha(((Cuadrado) bola
											.getBorde()))) {
								((Malo) entidad).morir_disparo();
							}
						}
						
						//Controla si hay un limitador a su derecha.
						
						for (Entidad lim : ((Malo) entidad).getLimitadores()) {
							Cuadrado bordeEntidad = (Cuadrado) lim.getBorde();
							if (bordeentidad.colisionaPorDerecha(bordeEntidad)) {
								d = true;
							}
						}
						
						//Controla si esta Mario a su derecha

						if (bordeentidad.colisionaPorDerecha((Cuadrado) jugador
								.getBorde())) {
							if (jugador.esInmortal())
								((Malo) entidad).morir_disparo();
							else {
								jugador.decrementarPuntos(30);
								if (jugador.esChiquito())
									jugador.morir();
								if (jugador.esGrande())
									jugador.setChiquito();
							}
						}
						break;
					}
					case 2: {
						Mario jugador = ((Malo) entidad).getJugador();
						((KoopaTroopa) entidad).derecha();
						
						//Controla si hay una bola de fuego a su derecha.
						
						for (BolaDeFuego bola : (((Malo) entidad).getDisparos())) {
							if (bordeentidad
									.colisionaPorDerecha(((Cuadrado) bola
											.getBorde()))) {
								((Malo) entidad).morir_disparo();
							}
						}
						
						//Controla si hay un limitador a su derecha
						
						for (Entidad lim : ((Malo) entidad).getLimitadores()) {
							Cuadrado bordeEntidad = (Cuadrado) lim.getBorde();
							if (bordeentidad.colisionaPorDerecha(bordeEntidad)) {
								d = true;
							}
						}
						
						//Controla si Mario esta a su derecha
						
						if (bordeentidad.colisionaPorDerecha((Cuadrado) jugador
								.getBorde())) {
							if (jugador.esInmortal()) {
								((Malo) entidad).morir_disparo();
							} else {
								jugador.decrementarPuntos(45);
								if (jugador.esChiquito())
									jugador.morir();
								if (jugador.esGrande())
									jugador.setChiquito();
							}
						}
						break;
					}
					case 3: {
						Mario jugador = ((Item) entidad).getJugador();
							
						//Controla si Mario esta a su derecha
							if (bordeentidad
									.colisionaPorDerecha((Cuadrado) jugador
											.getBorde())) {
								((Item) entidad).accion();
							}
							break;
						
					}
					}
					
					//Controla si hay un objeto que no lo deje avanzar a su derecha.
					
					for (Entidad aux : entidad.getObjetos()) {
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						if (bordeentidad.colisionaPorDerecha(bordeEntidad)) {
							d = true;
						}
					}

					//Actualiza la posicion de la entidad
					if (!d) {
						entidad.setBorde(entidad.getBorde().getX1() + 8,
								entidad.getBorde().getY1());
						entidad.setPosicion(entidad.getPosicion().getX() + 8,
								entidad.getPosicion().getY());
						entidad.getLabel().setLocation(
								entidad.getLabel().getLocation().x + 8,
								entidad.getLabel().getLocation().y);
						
						Thread.sleep(60);

					}
				} catch (Exception e) {
				}

			}

		}

	}
}