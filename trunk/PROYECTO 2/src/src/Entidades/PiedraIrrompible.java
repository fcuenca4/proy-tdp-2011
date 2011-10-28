package Entidades;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Auxiliares.Cuadrado;
import Posicion.Posicion;
/**
 * 
 * Modela una pidra que no puede ser destruida por el personaje
 * 
 */
public class PiedraIrrompible extends Entidad {
	
	private ImageIcon imagen;// Representacion Grafica

//Constructor.		
	public PiedraIrrompible(int i,int j)
	{
		this.pos=new Posicion(i, j);
		imagen=new ImageIcon(getClass().getResource("/Imagenes/bloque.gif"));
		this.label=new JLabel(imagen);
		label.setBounds(i,j,32,32);
		this.borde=new Cuadrado(i,j,null);
			
		
	}
	
	
	

}
