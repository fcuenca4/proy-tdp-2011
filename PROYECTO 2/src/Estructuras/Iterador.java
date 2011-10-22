
package Estructuras;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * El método <code>remove()</code> no tendrá una definición concreta en los iteradores de este paquete.
 * Esta clase se utiliza para evitar definir dicho servicio en cada iterador.
 * 
 * Los iteradores podrán extender a esta clase abstracta e implementar únicamente <code>hasNext()</code> y <code>next()</code>.
 * 
 * Implementación genérica.
 */
public abstract class Iterador<E> implements Iterator<E> {

	/**
	 * Determina si quedan más elementos en la iteración.
	 * 
	 * @return
	 * <code>true</code> - Si el recorrido no terminó aún.
	 * <BR>
	 * <code>false</code> - Si el recorrido terminó.
	 */
	public abstract boolean hasNext();
	
	
	/**
	 * Devuelve el siguiente elemento de la iteración.
	 * 
	 * @return El siguiente elemento de la iteración.
	 * @throws NoSuchElementException Si no hay más elementos para devolver.
	 */
	public abstract E next() throws NoSuchElementException;
	
	
	/**
	 * No definido.
	 */
	public void remove() {
	}

}
