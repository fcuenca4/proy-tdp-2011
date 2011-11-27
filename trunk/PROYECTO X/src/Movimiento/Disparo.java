package Movimiento;

import Auxiliares.Cuadrado;
import Entidades.BolaDeFuego;
import Entidades.Entidad;
import Entidades.Malo;
import Entidades.Mario;
import Estructuras.ListaSE;


//Esta clase modela el movimiento de las bolas de fuego.

public class Disparo extends Thread {

	private Mario jugador;
	private ListaSE<Entidad> objetos;
	private ListaSE<Malo> enemigos;
	private BolaDeFuego bola;
	private int direccion; // 0=izquierda 1=derecha

	public Disparo(Mario jug, ListaSE<Entidad> o, ListaSE<Malo> e, int dir,
			BolaDeFuego bola) {

		this.jugador = jug;
		this.objetos = o;
		this.enemigos = e;
		this.direccion = dir;
		this.bola = bola;

	}

	public void run() {
		try {
			if (direccion == 0) {
				while (true) {
					Cuadrado bordeBola = (Cuadrado) bola.getBorde();
					
					//Controla si hay un enemigo a su izquierda
					
					for (Malo enemies : enemigos) {
						if (bordeBola.colisionaPorIzquierda((Cuadrado) enemies
								.getBorde())) {
							enemies.morir_disparo();
						}
					}

					
					//Controla si hay un objeto que no lo deje avanzar a su izquierda
					for (Entidad objeto : objetos) {
						if (bordeBola.colisionaPorIzquierda(((Cuadrado) objeto
								.getBorde()))) {
							bola.desaparecer();
						}
					}
					
					//Actualiza la posicion 
					
					bola.setBorde(bola.getBorde().getX1()-8,bola.getBorde().getY1());
					bola.setPosicion(bola.getPosicion().getX()-8,bola.getPosicion().getY());
					bola.getLabel().setLocation(bola.getLabel().getX()-8,bola.getLabel().getY());
					Thread.sleep(30);
				}

			}
			else{
				while (true) {
					Cuadrado bordeBola = (Cuadrado) bola.getBorde();
					
					//Controla si hay un enemigo a su derecha
					
					for (Malo enemies : enemigos) {
						if (bordeBola.colisionaPorDerecha((Cuadrado) enemies
								.getBorde())) {
							enemies.morir_disparo();
						}
					}

					//Controla si hay un objeto que no lo deje avanzar a su derecha
					
					for (Entidad objeto : objetos) {
						if (bordeBola.colisionaPorDerecha(((Cuadrado) objeto
								.getBorde()))) {
							bola.desaparecer();
						}
					}
					
					//Actualiza la posicion 
					
					bola.setBorde(bola.getBorde().getX1()+8,bola.getBorde().getY1());
					bola.setPosicion(bola.getPosicion().getX()+8,bola.getPosicion().getY());
					bola.getLabel().setLocation(bola.getLabel().getX()+8,bola.getLabel().getY());
					Thread.sleep(30);
				}

			}
				

		} catch (Exception e) {
		}
	}
}
