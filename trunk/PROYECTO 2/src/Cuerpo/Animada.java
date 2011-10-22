package Cuerpo;
import Entidades.Mario;
import javax.swing.JLabel;

/**
 * Esta clase utiliza un hilo para animar el personaje
 * 
 * 
 *
 */

public class Animada extends Thread {
	
	private Mario mario;  //Personaje Principal
	private JLabel label;   //Personaje Principal
	
	
	//constructor
	public Animada(Mario m)
	{	
		this.mario=m;
		this.label=m.getLabel();
	}
	
	/**
	 * Hilo encargado de representar el movimiento.
	 */
	public void run()
	{
		
		while( true )
		{
			try
			{
				label.setIcon(mario.getActual().obtenerImagen());
				Thread.sleep(90);
			}
			catch( Exception e )
			{
				
			}
			
		}
	}

}
