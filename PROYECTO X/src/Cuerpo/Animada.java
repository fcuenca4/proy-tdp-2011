package Cuerpo;
import Entidades.*;
import Entidades.Mario;
import javax.swing.JLabel;

/**
 * Esta clase utiliza un hilo para animar el personaje
 * 
 * 
 *
 */

public class Animada extends Thread {
	
	private Entidad entidad;  //Personaje Principal
	private JLabel label;   //Personaje Principal
	private int control;    //1 Mario ;2 Koopa Troopa
	
	//constructor
	public Animada(Entidad m,int c)
	{	
		this.entidad=m;
		this.label=m.getLabel();
		this.control=c;
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
				if(control==1){label.setIcon(((Mario)entidad).getActual().obtenerImagen());}
				else{label.setIcon(((KoopaTroopa)entidad).getActual().obtenerImagen());}
				Thread.sleep(90);
			}
			catch( Exception e )
			{
				
			}
			
		}
	}

}
