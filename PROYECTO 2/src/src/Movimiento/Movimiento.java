package Movimiento;
import javax.swing.JOptionPane;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import Estructuras.*;

import Auxiliares.Cuadrado;
import Entidades.Entidad;
import Entidades.Mario;
import Gravedad.Gravedad;

public class Movimiento extends Thread {

	private JPanel panel;
	private KeyEvent tecla;
	private Mario jugador;
	private Gravedad gravedad;
	private ListaSE<Entidad> objetos;

	public Movimiento(JPanel p, KeyEvent t, Mario j, Gravedad g,
			ListaSE<Entidad> l) {
		this.panel = p;
		this.tecla = t;
		this.jugador = j;
		this.gravedad = g;
		this.objetos = l;
	}

	public void run() {
		switch (tecla.getKeyCode()) {
		case KeyEvent.VK_SPACE: {
			try {
				Cuadrado bordeMario=(Cuadrado)jugador.getBorde();
				boolean control=false;
				for(Entidad aux:objetos){
					Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
					if (bordeMario.colisionaPorArriba(bordeEntidad)) {
						control = true;
						break;
					}
				}
				if(!control){
				gravedad.suspend();
				jugador.setEstaSaltando(true);	
				JLabel label = jugador.getLabel();
				for (int i = 0; i < 15 && !control; i++) {
					jugador.setBorde(jugador.getBorde().getX1(), jugador
							.getBorde().getY1() - 8);
					label.setLocation(label.getLocation().x,
							label.getLocation().y - 8);
					jugador.setPosicion(jugador.getPosicion().getX(), jugador
							.getPosicion().getY() - 8);
					
					jugador.getLabel().repaint();
					Thread.sleep(30);
					for(Entidad aux:objetos){
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						if (bordeMario.colisionaPorArriba(bordeEntidad)) {
							control = true;
							break;
						}
					}
				}

				gravedad.resume();
				break;}
			} catch (Exception e) {
			}
		}

		case KeyEvent.VK_LEFT: {
			while (true) {
				try {

					Cuadrado bordeMario = (Cuadrado) jugador.getBorde();

					boolean control = false;
					for (Entidad aux : objetos) {
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						if (bordeMario.colisionaPorIzquierda(bordeEntidad)) {
							control = true;
							break;
						}
					}
					if ((!control) && (jugador.getPosicion().getX() != 96)
							&& (jugador.getPosicion().getY() <= 320)) {
						jugador.setBorde(jugador.getBorde().getX1() - 8,
								jugador.getBorde().getY1());
						jugador.setPosicion(jugador.getPosicion().getX() - 8,
								jugador.getPosicion().getY());
						panel.setLocation(panel.getLocation().x + 8,
								panel.getLocation().y);
						
						panel.repaint();
						jugador.getLabel().repaint();

					}
					Thread.sleep(30);
					
				} catch (Exception e) {
				}
			}
			
		}
		case KeyEvent.VK_RIGHT: {
			while (true) {
				try {
					Cuadrado bordeMario = (Cuadrado) jugador.getBorde();
					JLabel label = jugador.getLabel();

					boolean control = false;
					for (Entidad aux : objetos) {
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						if (bordeMario.colisionaPorDerecha(bordeEntidad)) {
							control = true;
							break;
						}
					}

					if ((!control) && (jugador.getPosicion().getX() != 1984)
							&& (jugador.getPosicion().getY() <= 320)) {
						jugador.setBorde(jugador.getBorde().getX1() + 8,
								jugador.getBorde().getY1());
						jugador.setPosicion(jugador.getPosicion().getX() + 8,
								jugador.getPosicion().getY());
						panel.setLocation(panel.getLocation().x - 8,
								panel.getLocation().y);
					if(jugador.getPosicion().getX()==1984){JOptionPane.showMessageDialog(null,"Game Over");System.exit(0);}
						panel.repaint();
						jugador.getLabel().repaint();

					}

					Thread.sleep(30);
					
				}
				
				catch (Exception e) {
				}
			}
		}

		}
	}
}
