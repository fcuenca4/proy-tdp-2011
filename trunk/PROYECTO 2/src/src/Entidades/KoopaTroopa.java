package Entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Auxiliares.Cuadrado;
import Cuerpo.Animada;
import Cuerpo.SpriteAnimado;
import Estructuras.ListaSE;
import Movimiento.MovimientoArtificial;
import Posicion.Posicion;


//Esta clase representa a Koopa Troopa,la tortuga.
public class KoopaTroopa extends Malo {

	private SpriteAnimado derecha;
	private SpriteAnimado izquierda;
	private SpriteAnimado actual;
	private Animada movimiento;    //Modela el movimiento de los Sprites
	private boolean fueGolpeada;
	private MovimientoArtificial inteligencia;

	public KoopaTroopa(int i, int j, ListaSE<Entidad> o, ListaSE<Entidad> piso,
			ListaSE<BolaDeFuego> disparos, ListaSE<Entidad> limitadores,
			Mario jug, JLabel p) {

		this.jugador = jug;
		this.objetos = o;
		this.piso = piso;
		this.disparos = disparos;
		this.limitadores = limitadores;
		this.pos = new Posicion(i, j);
		ImageIcon imagen = new ImageIcon(getClass().getResource(
				"/Imagenes/Koopa1I.png"));
		this.label = new JLabel(imagen);
		this.label.setBounds(i, j - 16, 32, 48);
		this.borde = new Cuadrado(i, j, null, 32, 32);
		this.puntos = p;
		this.inteligencia = new MovimientoArtificial(this, 2);
		this.inteligencia.start();

		this.movimiento = new Animada(this, 2);
		this.movimiento.start();

		this.derecha = new SpriteAnimado();
		this.derecha.setearTemporal(false);
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Koopa1D.png")));
		this.derecha.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Koopa2D.png")));

		this.izquierda = new SpriteAnimado();
		this.izquierda.setearTemporal(false);
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Koopa1I.png")));
		this.izquierda.AgregarImagen(new ImageIcon(getClass().getResource(
				"/Imagenes/Koopa2I.png")));

	}
	
	/**
	 * Muestra a la tortuga yendo para la derecha
	*/
	

	public void derecha() {
		actual = derecha;
	}

	
	/**
	 * Muestra a la tortuga yendo para la izquierda
	*/
	public void izquierda() {
		actual = izquierda;
	}

	public SpriteAnimado getActual() {
		return actual;
	}
	
	

	/**
	 * Accion que realiza sobre Mario cuando Koopa Troopa lo mata.
	 */
	public void matar() {

		if (jugador.esChiquito()) {

			jugador.morir();
			jugador.decrementarPuntos(45);
		}
		if (jugador.esGrande())
			jugador.setChiquito();
	}

	/**
	 *Mata a Goomba cuando este es aplastado por segunda vez
	 * y realiza una animacion con el personaje
	 */
	public void morir() {
		try {
			if (!fueGolpeada) {
				fueGolpeada = true;
			} else {
				this.label.setBounds(label.getLocation().x,
						label.getLocation().y + 20, 32, 28);
				this.label.setIcon(new ImageIcon(getClass().getResource(
						"/Imagenes/KoopaCaparazon.gif")));
				this.borde = new Cuadrado(0, 0, null, 0, 0);
				this.pos = new Posicion(0, 0);
				int puntosviejos = Integer.parseInt(puntos.getText());
				this.puntos.setText(String.valueOf(puntosviejos + 90));

				inteligencia.stop();
				this.movimiento.stop();

				this.jugador = null;
				this.objetos = null;
				this.pos = null;
				this.borde = null;

			}

		} catch (Exception e) {
		}

	}

	/**
	 *Mata a Koopa Troopa cuando este es alcanzado por una bola de fuego
	 * o cuando el jugador uso la bomba nuclear.Realiza una animacion.
	 */
	
	public void morir_disparo() {
		try {
			this.label.setIcon(new ImageIcon(getClass().getResource(
					"/Imagenes/KoopaDadoVuelta.png")));
			Timer timer = new Timer(60, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setLocation(label.getLocation().x + 4,
							label.getLocation().y + 8);
				}
			});

			timer.start();

			timer.setRepeats(true);
			this.borde = new Cuadrado(0, 0, null, 0, 0);
			this.pos = new Posicion(0, 0);
			int puntosviejos = Integer.parseInt(puntos.getText());
			this.puntos.setText(String.valueOf(puntosviejos + 60));
			this.inteligencia.stop();
			this.movimiento.stop();
			this.jugador = null;
			this.objetos = null;
			this.pos = null;
			this.borde = null;

		} catch (Exception e) {
		}

	}

	/**
	 *Retorna si la tortuga ya fue golpeada una vez.
	 */

	public boolean fueGolpeada() {
		return fueGolpeada;
	}

}
