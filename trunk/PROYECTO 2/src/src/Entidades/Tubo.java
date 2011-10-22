package Entidades;

import javax.swing.ImageIcon;  
import javax.swing.JLabel;
import Auxiliares.*;
import Posicion.Posicion;




public class Tubo extends Entidad {
	
	
	private ImageIcon imagen;
	
	
	public Tubo(int i,int j,int parte)
	{
		this.pos=new Posicion(i, j);
		switch(parte)
		{case 1:{imagen=new ImageIcon(getClass().getResource("/Imagenes/Tubo1.png"));break;}
		case 2:{imagen=new ImageIcon(getClass().getResource("/Imagenes/Tubo2.png"));break;}
		case 3:{imagen=new ImageIcon(getClass().getResource("/Imagenes/Tubo3.png"));break;}
		case 4:{imagen=new ImageIcon(getClass().getResource("/Imagenes/Tubo4.png"));break;}
		}
		this.label=new JLabel(imagen);
		label.setBounds(i,j,32,32);
		this.borde=new Cuadrado(i,j);
		
	}
	

}
