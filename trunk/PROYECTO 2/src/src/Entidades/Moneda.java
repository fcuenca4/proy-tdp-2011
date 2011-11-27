package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Esta clase representa a las monedas del juego.

public class Moneda extends Item implements Runnable {
	
	private JLabel points;
	
	
	public Moneda(int i,int j,JLabel p){
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Imagenes/Coin.gif"));
		this.label=new JLabel(imagen);
		label.setBounds(i,j,32,32);
		this.points=p;
		
	}
	
	public void run()
	{try{
		for(int i=0;i<8;i++)
		{label.setLocation(label.getLocation().x,label.getLocation().y-8);
		 Thread.sleep(40);
		}
		label.setIcon(null);
		}
	catch(Exception e){}
	}
	
	/**
	 * Accion que realiza cuando el jugador agarra una moneda.
	 */
	public void accion()
	{
		Thread hilo=new Thread(this);
		hilo.start();
		int puntosviejos=Integer.parseInt(points.getText());
		this.points.setText(String.valueOf(puntosviejos+5));
	}
	
	

}
