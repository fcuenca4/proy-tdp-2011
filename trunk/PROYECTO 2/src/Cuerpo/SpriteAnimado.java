package Cuerpo;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SpriteAnimado{
	private Vector<Icon> accion;
	private boolean temporal;
	private int indice = 0;
	
	/**
	 * Encargado de modelar los movimientos de la animacion del personaje
	 * 
	 */
	public SpriteAnimado()
	{
		this.accion = new Vector<Icon>();  //Vector de iconos con los movimientos
		this.temporal = false;				//Variable de control
		
		
	}
	/**
	 * 
	 * Agrega un icono al vector.
	 *
	 * @param ii
	 * 
	 */
	public void AgregarImagen( ImageIcon ii )
	{
		this.accion.add(ii);
	}

	
	/**
	 * 
	 * Obtiene la imagen deseada.
	 *
	 * @param i
	 * @return Icon
	 */
	public Icon obtenerImagen( int i )
	{
		return this.accion.get(i);
	}
	
	

	/**
	 * 
	 * 
	 *
	 * @return Icon 
	 */
	public Icon obtenerImagen()
	{
		
		Icon c = this.obtenerImagen(this.indice);
		if (this.indice < this.accion.size()-1)
		{
			this.indice++;
		} else
		{
			this.indice = 0;			
		}
	
		return c;
	}
	
	
	
	
	public int obtenerLongitud()
	{
		return this.accion.size();
	}
	
	public void setearTemporal ( boolean b )
	{
		this.temporal = b;
	}
	
	public boolean esTemporal( )
	{
		return this.temporal;
	}
}