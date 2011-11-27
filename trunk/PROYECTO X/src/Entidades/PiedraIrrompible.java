package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Auxiliares.Cuadrado;
import Estructuras.ListaSE;
import Posicion.Posicion;

/**
 * 
 * Modela una pidra que no puede ser destruida por el personaje
 * 
 */
public class PiedraIrrompible extends Entidad {

	private ImageIcon imagen;// Representacion Grafica
	private boolean sorpresa;
	private int item; // 0:VACIO 1:HONGO 2:PLANTA 3:ESTRELLA 4:MONEDA 5:HONGO VIDA 6:BOMBA
	private JPanel panel;
	private ListaSE<Item> items;
	protected ListaSE<Entidad> piso;
	protected ListaSE<Entidad> objetos;
	protected Mario jugador;
	protected JLabel points;
	protected JLabel vidas;

	// Constructor.
	public PiedraIrrompible(int i, int j, int item, JPanel panel,
			ListaSE<Item> items, ListaSE<Entidad> piso,
			ListaSE<Entidad> objetos,ListaSE<Malo> malos, Mario jugador, JLabel p,JLabel vidas) {
		this.pos = new Posicion(i, j);

		if (item == 0) {sorpresa = false;} 
		else {
			imagen = new ImageIcon(getClass().getResource(
					"/Imagenes/pregunta.png"));
					this.label = new JLabel(imagen);
					label.setBounds(i, j, 32, 32);
					panel.add(label);
					sorpresa = true;
		}

		this.borde = new Cuadrado(i, j, null, 32, 32);
		this.item = item;
		this.items = items;
		this.panel = panel;
		this.objetos = objetos;
		this.piso = piso;
		this.jugador = jugador;
		this.points = p;
		this.vidas=vidas;
		this.malos=malos;

	}

	public boolean tieneItem() {
		return sorpresa;
	}

	public Item sacarItem() {
		Item aux = null;
		this.label.setIcon(new ImageIcon(getClass().getResource(
				"/Imagenes/bloque.png")));
		switch (item) {
		case 1: {
			aux = new Hongo(this.pos.getX(), this.pos.getY() - 32, objetos,
					piso, jugador,points);
			JLabel label = aux.getLabel();
			label.setBounds(aux.getPosicion().getX(), aux.getPosicion().getY(),
					32, 32);
			panel.add(label);
			items.addLast(aux);
			break;
		}
		case 2: {
			aux = new Flor(this.pos.getX(), this.pos.getY() - 32, jugador,points,vidas);
			JLabel label = aux.getLabel();
			panel.add(label);
			items.addLast(aux);
			break;
		}
		case 3: {
			aux = new Estrella(this.pos.getX(), this.pos.getY()-32,objetos,piso,jugador,points);
			JLabel label = aux.getLabel();
			panel.add(label);
			items.addLast(aux);
			break;
		}
		case 4: {
			aux = new Moneda(this.pos.getX(), this.pos.getY() - 32, points);
			JLabel label = aux.getLabel();
			panel.add(label);
			items.addLast(aux);
			((Moneda) aux).accion();
			break;
		}
		case 5: {
			aux = new HongoVida(this.pos.getX(), this.pos.getY() - 32,objetos,piso,jugador,points,vidas);
			JLabel label = aux.getLabel();
			panel.add(label);
			items.addLast(aux);
			
			break;
		}
		case 6: {
			aux=new Bomba(this.pos.getX(),this.pos.getY()-32,points,vidas,malos,jugador);
			JLabel label=aux.getLabel();
			panel.add(label);
			items.addLast(aux);
		}
		}
		this.sorpresa = false;

		return aux;

	}

}
