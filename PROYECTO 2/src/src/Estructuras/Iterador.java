
package Estructuras;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * El m�todo <code>remove()</code> no tendr� una definici�n concreta en los iteradores de este paquete.
 * Esta clase se utiliza para evitar definir dicho servicio en cada iterador.
 * 
 * Los iteradores podr�n extender a esta clase abstracta e implementar �nicamente <code>hasNext()</code> y <code>next()</code>.
 * 
 * Implementaci�n gen�rica.
 */
public abstract class Iterador<E> implements Iterator<E> {

	/**
	 * Determina si quedan m�s elementos en la iteraci�n.
	 * 
	 * @return
	 * <code>true</code> - Si el recorrido no termin� a�n.
	 * <BR>
	 * <code>false</code> - Si el recorrido termin�.
	 */
	public abstract boolean hasNext();
	
	
	/**
	 * Devuelve el siguiente elemento de la iteraci�n.
	 * 
	 * @return El siguiente elemento de la iteraci�n.
	 * @throws NoSuchElementException Si no hay m�s elementos para devolver.
	 */
	public abstract E next() throws NoSuchElementException;
	
	
	/**
	 * No definido.
	 */
	public void remove() {
	}

}
