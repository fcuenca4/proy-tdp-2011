
package Estructuras;



import java.util.NoSuchElementException;

/**
 * Define el comportamiento de un iterador de una lista.
 * 
 * Implementación genérica.
 */
public class IteradorLista<E> extends Iterador<E> {

	// Atributos
	
	private List<E> lista; // La lista a recorrer
	private Position<E> cursor; // Marcador de la posición siguiente
	
	
	// Constructores
	
	/**
	 * Crea un nuevo iterador para recorrer la lista que pasa como parámetro.
	 */
	public IteradorLista(List<E> l) {
		lista = l;
		
		if (! lista.isEmpty())
			cursor = lista.first();
		else
			cursor = null;
	}
	
	
	// Métodos
	
	/**
	 * Determina si quedan más elementos en la iteración.
	 * 
	 * @return
	 * <code>true</code> - Si el recorrido no terminó aún.
	 * <BR>
	 * <code>false</code> - Si el recorrido terminó.
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	
	/**
	 * Devuelve el siguiente elemento de la iteración.
	 * 
	 * @return El siguiente elemento de la iteración.
	 * @throws NoSuchElementException Si no hay más elementos para devolver.
	 */
	public E next() throws NoSuchElementException {
		
		if (cursor == null)
			throw new NoSuchElementException("El recorrido ha finalizado. " +
											 "Throwed by: IteradorLista.next()");
		
		E element = cursor.element(); // Almacena el elemento a devolver
		
		if (cursor == lista.last())
			// Si es la última posición, se anula
			cursor = null;
		else
			// Si no, se actualiza con la posición siguiente
			cursor = lista.next(cursor);
		
		return element;
	}

}
