package Main;

import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Entidades.Entidad;
import Entidades.Mario;
import Entidades.PiedraIrrompible;
import Entidades.Tubo;

import Estructuras.ListaSE;
import Gravedad.Gravedad;
import Movimiento.Movimiento;
import Posicion.Posicion;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Juego extends javax.swing.JFrame {

	protected Mario jugador;

	protected boolean control;
	protected boolean controlUp;
	protected Movimiento izquierda;
	protected Movimiento derecha;
	protected Movimiento saltar;
	protected JPanel panel;
	protected Posicion principio;
	protected Gravedad gravity;
	private JPanel personajes;
	protected ListaSE<Entidad> objetos; // OBJETOS CON LOS QUE PUEDE COLISIONAR
										// POR UN COSTADO
	protected ListaSE<Entidad> piso;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Juego inst = new Juego();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Juego() {
		super();

		control = false;
		controlUp = false;

		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground((new java.awt.Color(128, 255, 255)));
		control = false;
		controlUp = false;
		principio = new Posicion(0, 384);

		objetos = new ListaSE<Entidad>();
		piso = new ListaSE<Entidad>();
		{
			personajes = new JPanel();
			getContentPane().add(personajes, "Center");
			personajes.setLayout(null);
			personajes.setOpaque(false);
			personajes.setBounds(0,0, 2300, 500);

		}

		{
			panel = new JPanel();
			getContentPane().add(panel, "Center");
			panel.setLayout(null);
			panel.setBackground(new java.awt.Color(128, 255, 255));
			panel.setPreferredSize(new java.awt.Dimension(388, 264));
			panel.setBounds(8,19, 2300, 500);
		}

		JLabel castillo = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Imagenes/castillo.png")));
		castillo.setBounds(1809, 41, 256, 320);
		panel.add(castillo);

		JLabel hongo = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Imagenes/hongo.gif")));
		hongo.setBounds(0, 224, 96, 128);
		panel.add(hongo);

		JLabel arbusto = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Imagenes/arbusto.gif")));
		arbusto.setBounds(416, 282, 160, 70);
		panel.add(arbusto);

		JLabel nube1 = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Imagenes/nubes.gif")));
		nube1.setBounds(600, 50, 128, 48);
		panel.add(nube1);

		JLabel nube2 = new JLabel(new ImageIcon(getClass().getClassLoader()
				.getResource("Imagenes/nubes.gif")));
		nube2.setBounds(1400, 50, 128, 48);
		panel.add(nube2);

		// CREO EL PISO.

		for (int i = 0; i < 864; i = i + 32) {
			Entidad piso = new PiedraIrrompible(i, 352);
			JLabel label = piso.getLabel();
			JLabel label1 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			JLabel label2 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			label.setBounds(i, 352, 32, 32);
			label1.setBounds(i, 384, 32, 32);
			label2.setBounds(i, 416, 32, 32);
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			this.piso.addLast(piso);

		}
		// CREO EL POZO IMPLICITAMENTE

		for (int i = 928; i < 1632; i = i + 32) {
			Entidad piso = new PiedraIrrompible(i, 352);
			JLabel label = piso.getLabel();
			JLabel label1 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			JLabel label2 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			label.setBounds(i, 352, 32, 32);
			label1.setBounds(i, 384, 32, 32);
			label2.setBounds(i, 416, 32, 32);
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			this.piso.addLast(piso);

		}

		// CREO EL POZO IMPLICITAMENTE

		for (int i = 1696; i <= 2300; i = i + 32) {
			Entidad piso = new PiedraIrrompible(i, 352);
			JLabel label = piso.getLabel();
			JLabel label1 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			JLabel label2 = new JLabel(new ImageIcon(getClass()
					.getClassLoader().getResource("Imagenes/bloque.gif")));
			label.setBounds(i, 352, 32, 32);
			label1.setBounds(i, 384, 32, 32);
			label2.setBounds(i, 416, 32, 32);
			panel.add(label);
			panel.add(label1);
			panel.add(label2);
			this.piso.addLast(piso);

		}

		crearTuboChico(320, 320);
		crearTuboGrande(640, 320);
		crearTuboGrande(1000, 320);
		crearTuboGrande(1520, 320);
		crearBloque(1240, 224);
		crearBloque(1272, 224);
		crearBloque(1304, 224);
		crearBloque(1336, 224);

		jugador = new Mario(96, 320);
		JLabel etiq_jugador = jugador.getLabel();
		etiq_jugador.setOpaque(false);
		personajes.add(etiq_jugador);

		gravity = new Gravedad(jugador, objetos, piso);
		gravity.start();

		pack();

		this.setSize(512, 490);

		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				switch (evt.getKeyCode()) {
				case KeyEvent.VK_LEFT: {
					if (izquierda != null) {
						control = false;
						jugador.quietoI();
						izquierda.stop();
						izquierda = null;
						break;
					}
				}
				case KeyEvent.VK_RIGHT: {
					if (derecha != null) {
						control = false;
						jugador.quieto();
						derecha.stop();
						derecha = null;
						break;
					}
				}
				case KeyEvent.VK_SPACE: {
					controlUp = false;
					saltar = null;
					break;
				}
				}

			}

			public void keyPressed(KeyEvent evt) {
				switch (evt.getKeyCode()) {
				case KeyEvent.VK_SPACE: {
					if ((!controlUp) && (!jugador.getEstaSaltando())) {
						control = false;
						controlUp = true;
						saltar = new Movimiento(panel, evt, jugador, gravity,
								objetos);
						saltar.start();

					}
					break;
				}

				case KeyEvent.VK_LEFT: {
					if ((!control) && (jugador.getPosicion().getY() <= 320)) {
						control = true;
						if (izquierda == null) {
							jugador.izquierda();
							izquierda = new Movimiento(panel, evt, jugador,
									gravity, objetos);
							izquierda.start();
						}
						break;
					}
				}
				case KeyEvent.VK_RIGHT: {
					if ((!control)) {
						control = true;
						if (derecha == null) {
							
								jugador.derecha();
							
							derecha = new Movimiento(panel, evt, jugador,
									gravity, objetos);
							derecha.start();
						}
						break;

					}
				}
				}
			}

		}

		);

	}

	private void crearTuboChico(int x, int y) {
		Entidad t1 = new Tubo(x, y,1);
		JLabel etiq_t1 = t1.getLabel();
		panel.add(etiq_t1);
		objetos.addLast(t1);

		Entidad t2 = new Tubo(x + 32, y,2);
		JLabel etiq_t2 = t2.getLabel();
		panel.add(etiq_t2);
		objetos.addLast(t2);

		Entidad t3 = new Tubo(x, y - 32,3);
		JLabel etiq_t3 = t3.getLabel();
		panel.add(etiq_t3);
		objetos.addLast(t3);

		Entidad t4 = new Tubo(x + 32, y - 32,4);
		JLabel etiq_t4 = t4.getLabel();
		panel.add(etiq_t4);
		objetos.addLast(t4);

	}

	private void crearTuboGrande(int x, int y) {
		Entidad t1 = new Tubo(x, y,1);
		JLabel etiq_t1 = t1.getLabel();
		panel.add(etiq_t1);
		objetos.addLast(t1);

		t1 = new Tubo(x, y - 32,1);
		etiq_t1 = t1.getLabel();
		panel.add(etiq_t1);
		objetos.addLast(t1);

		Entidad t2 = new Tubo(x + 32, y,2);
		JLabel etiq_t2 = t2.getLabel();
		panel.add(etiq_t2);
		objetos.addLast(t2);

		t2 = new Tubo(x + 32, y - 32,2);
		etiq_t2 = t2.getLabel();
		panel.add(etiq_t2);
		objetos.addLast(t2);

		Entidad t3 = new Tubo(x, y - 64,3);
		JLabel etiq_t3 = t3.getLabel();
		panel.add(etiq_t3);
		objetos.addLast(t3);

		Entidad t4 = new Tubo(x + 32, y - 64,4);
		JLabel etiq_t4 = t4.getLabel();
		panel.add(etiq_t4);
		objetos.addLast(t4);

	}

	private void crearBloque(int x, int y) {
		Entidad piso = new PiedraIrrompible(x, y);
		JLabel label = piso.getLabel();
		label.setBounds(x, y, 32, 32);
		panel.add(label);
		objetos.addLast(piso);

	}

}
