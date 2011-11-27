package Main;



import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;      
import java.awt.event.KeyEvent;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import Generador.*;
import Auxiliares.PanelDetalles;
import Entidades.*;
import Estructuras.ListaSE;
import Gravedad.Gravedad;
import Movimiento.*;






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

	protected SplashScreen splash;   //Splah screen.
	protected Mario jugador;		//Personaje principal del juego,Mario.
	protected Audio musica;			//Controla el audio del juego
	protected boolean control;		//Auxiliar
	protected boolean controlUp;	//Auxiliar
	
	protected MovimientoManual izquierda;		//Hilo que hace mover a Mario para la izquierda
	protected MovimientoManual derecha;			//Hilo que hace mover a Mario para la derecha
	protected Salto saltar;						//Hilo que hace saltar a Mario
	protected Gravedad gravity;					//Hilo que hace caer a Mario 
	
	
	protected PanelDetalles panel;				//Panel donde se dibuja el cuerpo del mapa(tubos,bloques,nubes,piso)
	private JPanel personajes;					//Panel donde se encuentra Mario y las etiquetas de las vidas y puntos
	private JPanel enemigos;					//Panel donde se encuentran los enemigos
	protected JLabel puntos;					//Etiqueta
	protected JLabel vidas;						//Etiqueta
	
	
	protected ListaSE<Entidad> objetos; 	//Almacena los objetos logicos que solo ocupan lugar(tubos,bloques)
	protected ListaSE<Malo> malos;			//Almacena a los enemigos
	protected ListaSE<Entidad> piso;		//Almacena los objetos logicos que componen el piso.
	protected ListaSE<Item> items;			//Almacena a los items
	protected ListaSE<Entidad> limitadores;  //Indican los limites que tienen los enemigos para caminar.
	protected ListaSE<BolaDeFuego> disparos;	//Almacena los disparos que realiza Mario
	
	
	
	
	public static void main(String[] args) {
		
        SplashScreen splash = new SplashScreen(5000);
       splash.showSplash();

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
		
		//Inicio la musica
		musica=new Audio("/Imagenes/musica.mid");
		musica.reproducir(50);
		
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	 	getContentPane().setBackground((new java.awt.Color(128, 255, 255)));
		control = false;
		controlUp = false;
		


		objetos = new ListaSE<Entidad>();
		malos= new ListaSE<Malo>();
		piso = new ListaSE<Entidad>();
		items=new ListaSE<Item>();
		disparos=new ListaSE<BolaDeFuego>();
		limitadores=new ListaSE<Entidad>();

			
				
		
			
		
		
		
		{
			personajes = new JPanel();
			getContentPane().add(personajes, "Center");
			personajes.setLayout(null);
			personajes.setOpaque(false);
			personajes.setBounds(0,0, 5000, 510);
			JLabel etiqueta1=new JLabel("MARIO x");
			etiqueta1.setFont(new java.awt.Font("Tahoma", 1, 11));
			etiqueta1.setForeground(new java.awt.Color(255, 255, 255));
			etiqueta1.setBounds(30, 10, 60, 20);
			
			
			this.vidas=new  JLabel("1");
			this.vidas.setFont(new java.awt.Font("Tahoma", 1, 11));
			this.vidas.setForeground(new java.awt.Color(255, 255, 255));
			vidas.setBounds(90,10,100,20);	
			
			this.puntos=new JLabel("00");
			this.puntos.setFont(new java.awt.Font("Tahoma", 1, 11));
			this.puntos.setForeground(new java.awt.Color(255, 255, 255));
			
			puntos.setBounds(140,10,100,20);
					
			personajes.add(puntos);
			personajes.add(etiqueta1);
			personajes.add(vidas);

		}
		
		
		
		personajes.setBounds(0,0, 512,490);
		personajes.setOpaque(false);
		
		
		
		
		
		{
			enemigos= new JPanel();
			getContentPane().add(enemigos, "Center");
			enemigos.setLayout(null);
			enemigos.setOpaque(false);
			enemigos.setBounds(0,0, 5000, 510);

		}
		
		

		{
			panel = new PanelDetalles();
			
			getContentPane().add(panel, "Center");
			panel.setLayout(null);
			panel.setBackground(new java.awt.Color(128, 255, 255));
			panel.setPreferredSize(new java.awt.Dimension(388, 264));
			panel.setBounds(0,0, 5000, 500);
		}
		
		
		//MARIO
				jugador = new Mario(160,392,piso,objetos,malos,items,this,vidas,puntos);
				JLabel etiq_jugador = jugador.getLabel();
				etiq_jugador.setOpaque(false);
				
				personajes.add(etiq_jugador);
		
				
				
				
		
		
	
		
		
		
		
			
		
		
	
		
		Generador gen=new Generador(jugador, objetos, malos, piso,items,disparos,limitadores,enemigos,puntos,vidas);
		gen.nivel1();
		
		
			
		gravity = new Gravedad(jugador,1);
		gravity.start();

	

		pack();

		this.setSize(512, 510);

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
						saltar = new Salto(gravity,jugador);
						saltar.start();

					}
					break;
				}
				case KeyEvent.VK_Z: {
					if(jugador.esPoderoso()){
					BolaDeFuego bola=new BolaDeFuego(jugador,objetos,malos,enemigos);
					disparos.addLast(bola);}
					break;
				}
				
				

				case KeyEvent.VK_LEFT: {
					if ((!control) /*&& (jugador.getPosicion().getY() <= 320)*/) {
						control = true;
						if (izquierda == null) {
							
							izquierda = new MovimientoManual(enemigos,panel, evt, jugador,
									gravity);
							jugador.izquierda();
							izquierda.start();
						}
						break;
					}
				}
				case KeyEvent.VK_RIGHT: {
					if ((!control)) {
						control = true;
						if (derecha == null) {
							
								
							
							derecha = new MovimientoManual(enemigos,panel, evt, jugador,
									gravity);
							jugador.derecha();
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
	/**
	 * Lleva al jugador al principio del juego por haber perdido una vida.
	 */
	
	public void reiniciar()
	{
		jugador.setChiquito();
		jugador.setBorde(160,384);
		jugador.getLabel().setLocation(160,384);
		jugador.setPosicion(160,384);
		panel.setLocation(0,0);
		enemigos.setLocation(0,0);
	}


}
