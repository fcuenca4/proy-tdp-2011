package Auxiliares;

import java.awt.Graphics; 

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidades.Entidad;
import Entidades.Goomba;
import Entidades.Item;
import Entidades.Malo;
import Entidades.Mario;
import Entidades.PiedraIrrompible;
import Entidades.Tubo;
import Estructuras.ListaSE;


//Esta clase dibuja un panel con una imagen de fondo,que sirve como modelo de mapa.

public class PanelDetalles extends JPanel {
	
	
	
	
	
	public PanelDetalles()
	{super();	
	}

	
	public void paint(Graphics g)
	{	
		ImageIcon fondo=new ImageIcon(getClass().getResource("/Imagenes/nivel1.gif"));
		g.drawImage(fondo.getImage(),0,0,5000,473,this);
		
		
		
		
		
		
}






}