package Generador;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidades.*;
import Estructuras.ListaSE;

//Esta clase genera toda la parte lógica del juego(enemigos,bloques,pozos,items)

public class Generador {

	protected ListaSE<Entidad> bloques;		//Almacena los objetos logicos que solo ocupan lugar(tubos,bloques)
	protected ListaSE<Malo> malos;			//Almacena a los enemigos
	protected ListaSE<Entidad> piso;		//Almacena los objetos logicos que componen el piso.
	protected ListaSE<BolaDeFuego> disparos;	//Almacena los disparos que realiza Mario
	protected ListaSE<Entidad> limitadores;		//Indican los limites que tienen los enemigos para caminar.
	protected ListaSE<Item> items;				//Almacena a los items
	
	protected Mario jugador;
	
	protected JLabel puntos;
	protected JLabel vidas;
	protected JPanel personajes;
	

	public Generador(Mario jug, ListaSE<Entidad> o, ListaSE<Malo> m,
			ListaSE<Entidad> p, ListaSE<Item> i,ListaSE<BolaDeFuego> disparos,ListaSE<Entidad> lim,JPanel per,
			JLabel points,JLabel vidas) {
		bloques = o;
		malos = m;
		piso = p;
		items = i;
		limitadores=lim;
		this.disparos=disparos;
		jugador = jug;
		puntos = points;
		this.vidas=vidas;
		personajes = per;
	}

	public void nivel1() {
		
		crearPiso();
		
		
		crearGoomba(728,392);
		
		crearBloque(328,296);
		crearBloqueSorpresa(360,296,1);
		crearBloque(392,296);
		
		
		
		crearBloque(464,392);
		crearBloque(496,360);
		crearBloque(528,328);
		crearBloque(560,296);
		crearBloque(592,392);
		crearBloque(592,360);
		crearBloque(592,328);
		crearBloque(592,296);
		crearBloque(592,264);
		
		crearBloque(776,392);
		crearBloque(776,360);
		crearBloque(776,328);
		crearBloque(808,392);
		crearBloque(808,360);
		
		
		crearBloqueSorpresa(672,296,2);
		
		crearBloqueSorpresa(912,296,4);
		crearBloqueSorpresa(944,296,1);
		crearBloqueSorpresa(976,296,4);
		
		
		crearKoopaTroopa(1072,392);
		
		
		crearBloque(1104,392);
		crearBloque(1104,360);
		crearBloque(1136,392);
		crearBloque(1136,360);
		
	
		
		
		
		crearBloqueSorpresa(1240,296,4);
		crearBloqueSorpresa(1272,296,4);
		crearBloqueSorpresa(1304,296,4);
		crearBloqueSorpresa(1336,296,4);
		crearBloqueSorpresa(1368,296,4);
		
	
		
		
		crearBloqueSorpresa(1240,168,4);
		crearBloqueSorpresa(1272,168,4);
		crearBloqueSorpresa(1304,168,4);
		crearBloqueSorpresa(1336,168,4);
		crearBloqueSorpresa(1368,168,4);
		
		crearBloqueSorpresa(1464,264,6);
		
		crearKoopaTroopa(1400,392);
		crearGoomba(1632,392);
		
		crearBloque(1552,296);
		
		crearBloqueSorpresa(1600,168,3);
		crearBloque(1640,168);
		crearBloque(1672,168);
		
		crearBloque(1752,392);
		crearBloque(1752,360);
		crearBloque(1752,328);
		crearBloque(1784,392);
		crearBloque(1784,360);
		crearBloque(1784,328);
		
		crearBloqueSorpresa(1856,264,2);
		crearBloqueSorpresa(1888,264,5);
		
		crearBloque(1904,168);
		crearBloque(1936,168);
		
		crearGoomba(1976,392);
		
		crearBloque(2000,168);
		crearBloque(2032,168);
		
		crearBloque(2144,168);
		crearBloque(2176,168);
		
		//crearCañon(2280,368);
		
		crearBloque(2328,392);
		crearBloque(2328,360);
		crearBloque(2328,328);
		crearBloque(2328,296);
		crearBloque(2328,264);
		crearBloque(2328,232);
		crearBloque(2360,392);
		crearBloque(2360,360);
		crearBloque(2360,328);
		crearBloque(2360,296);
		crearBloque(2360,264);
		crearBloque(2360,232);
		
		
		//crearCañon(2592,168);
		crearBloque(2504,224);
		crearBloque(2536,224);
		
		crearBloqueSorpresa(2512,96,5);
		
		crearKoopaTroopa(2600,392);
		
		crearBloque(2704,392);
		crearBloque(2704,360);
		crearBloque(2736,392);
		crearBloque(2736,360);
		
		crearBloqueSorpresa(2808,264,4);
		crearBloque(2872,200);
		crearBloque(2904,200);
		crearBloqueSorpresa(2904,104,6);
		
		crearGoomba(2808,392);
		
		crearLimitador(2824,296);
		crearKoopaTroopa(2880,296);
		crearLimitador(2920,296);
		
		crearLimitador(2928,328);
		crearKoopaTroopa(2984,328);
		crearLimitador(3024,328);
		
		crearLimitador(3032,232);
		crearGoomba(3088,232);
		crearLimitador(3128,232);
		
		
		crearBloque(2856,392);
		crearBloque(2856,360);
		crearBloque(2856,328);
		crearBloque(2888,392);
		crearBloque(2888,360);
		crearBloque(2888,328);
		
		crearBloque(2960,392);
		crearBloque(2960,360);
		crearBloque(2992,392);
		crearBloque(2992,360);
		
	
		
		crearBloque(3064,392);
		crearBloque(3064,360);
		crearBloque(3064,328);
		crearBloque(3064,296);
		crearBloque(3064,264);
		crearBloque(3096,392);
		crearBloque(3096,360);
		crearBloque(3096,328);
		crearBloque(3096,296);
		crearBloque(3096,264);
		
		crearBloque(3248,232);
		crearBloque(3280,232);
		
		crearBloqueSorpresa(3280,136,3);
		
		
		crearLimitador(3296,392);
		crearGoomba(3360,392);
		crearKoopaTroopa(3488,392);
		crearLimitador(3568,392);
		
		crearBloque(3376,200);
		crearBloque(3408,200);
		crearBloque(3440,200);
		crearBloque(3472,200);
		crearBloque(3504,200);
		crearBloque(3536,200);
		crearBloque(3568,200);
		crearBloque(3600,200);
		crearBloque(3632,200);
		crearBloque(3664,200);
		crearBloque(3696,200);
		crearBloque(3728,200);
		crearBloque(3770,200);
		crearBloque(3802,200);
		crearBloque(3834,200);
		crearBloque(3866,200);
		crearBloque(3898,200);
		crearBloque(3930,200);
		crearBloque(3962,200);
		crearBloque(3994,200);
		crearBloque(4026,200);
		crearBloque(4058,200);
		
		crearKoopaTroopa(4640,392);
		crearLimitador(4672,392);
		
		
		crearBloque(4144,392);
		crearBloque(4144,360);
		crearBloque(4144,328);
		crearBloque(4176,392);
		crearBloque(4176,360);
		crearBloque(4176,328);

		
		
		
		
		crearBloque(4328,296);
		crearBloque(4360,296);
		
	
		
		
		
		
	}

	private void crearTuboChico(int x, int y) {
		Entidad t1 = new Tubo(x, y, 1);
		bloques.addLast(t1);

		Entidad t2 = new Tubo(x + 32, y, 2);
		bloques.addLast(t2);

		Entidad t3 = new Tubo(x, y - 32, 3);
		bloques.addLast(t3);

		Entidad t4 = new Tubo(x + 32, y - 32, 4);
		bloques.addLast(t4);

	}

	private void crearTuboGrande(int x, int y) {
		Entidad t1 = new Tubo(x, y, 1);
		bloques.addLast(t1);

		t1 = new Tubo(x, y - 32, 1);
		bloques.addLast(t1);

		Entidad t2 = new Tubo(x + 32, y, 2);
		bloques.addLast(t2);

		t2 = new Tubo(x + 32, y - 32, 2);
		bloques.addLast(t2);

		Entidad t3 = new Tubo(x, y - 64, 3);
		bloques.addLast(t3);

		Entidad t4 = new Tubo(x + 32, y - 64, 4);
		bloques.addLast(t4);

	}

	private void crearBloque(int x, int y) {
		Entidad ent = new PiedraIrrompible(x, y, 0,personajes, items, this.piso,bloques,malos, jugador,puntos,vidas);
		bloques.addLast(ent);
	}
	
	private void crearPiso()
	{
		for(int i=0;i<2120;i=i+32)
		{
			crearBloque(i,424);
		}
		
		
		crearLimitador(2152,392);
		
		
		for(int i=2248;i<2480;i+=32)
		{
			crearBloque(i,424);
		}
		
		crearLimitador(2520,392);
		
		for(int i=2552;i<3256;i+=32)
		{
			crearBloque(i,424);
		}
		for(int i=3328;i<3552;i+=32)
		{
			crearBloque(i,424);
		}
		for(int i=3624;i<3776;i+=32)
		{
			crearBloque(i,424);
		}
		for(int i=3848;i==3848;i+=32)
		{
			crearBloque(i,424);
		}
		for(int i=3936;i==3936;i+=32)
		{
			crearBloque(i,424);
		}
		for(int i=4024;i<=5000;i+=32)
		{
			crearBloque(i,424);
		}
		
		
		
	}

	private void crearBloqueSorpresa(int x, int y,int i) {
		Entidad ent = new PiedraIrrompible(x, y,i, personajes, items, this.piso,
				bloques,malos, jugador,puntos,vidas);
		
		
		bloques.addLast(ent);

	}

	private void crearGoomba(int x, int y) {
		Malo goomba = new Goomba(x, y, bloques,piso,disparos,limitadores,jugador, puntos);
		JLabel etiq_g1 = goomba.getLabel();
		etiq_g1.setOpaque(false);
		this.malos.addLast(goomba);
		personajes.add(etiq_g1);
	}
	
	private void crearKoopaTroopa(int x, int y) {
		Malo koopa = new KoopaTroopa(x, y, bloques,piso,disparos,limitadores,jugador, puntos);
		JLabel etiq_g1 = koopa.getLabel();
		etiq_g1.setOpaque(false);
		this.malos.addLast(koopa);
		personajes.add(etiq_g1);
	}
	
	private void crearLimitador(int x,int y)
	{
		Limitador lim=new Limitador(x,y);
		limitadores.addLast(lim);
		
	}
	

	
	
	
	
	
}
