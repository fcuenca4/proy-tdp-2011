
package Estructuras;



import java.util.NoSuchElementException;

/**
 * Define el comportamiento de un iterador de una lista.
 * 
 * Implementaci�n gen�rica.
 */
public class IteradorLista<E> extends Iterador<E> {

	// Atributos
	
	private List<E> lista; // La lista a recorrer
	private Position<E> cursor; // Marcador de la posici�n siguiente
	
	
	// Constructores
	
	/**
	 * Crea un nuevo iterador para recorrer la lista que pasa como par�metro.
	 */
	public IteradorLista(List<E> l) {
		lista = l;
		
		if (! lista.isEmpty())
			cursor = lista.first();
		else
			cursor = null;
	}
	
	
	// M�todos
	
	/**
	 * Determina si quedan m�s elementos en la iteraci�n.
	 * 
	 * @return
	 * <code>true</code> - Si el recorrido no termin� a�n.
	 * <BR>
	 * <code>false</code> - Si el recorrido termin�.
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	
	/**
	 * Devuelve el siguiente elemento de la iteraci�n.
	 * 
	 * @return El siguiente elemento de la iteraci�n.
	 * @throws NoSuchElementException Si no hay m�s elementos para devolver.
	 */
	public E next() throws NoSuchElementException {
		
		if (cursor == null)
			throw new NoSuchElementException("El recorrido ha finalizado. " +
											 "Throwed by: IteradorLista.next()");
		
		E element = cursor.element(); // Almacena el elemento a devolver
		
		if (cursor == lista.last())
			// Si es la �ltima posici�n, se anula
			cursor = null;
		else
			// Si no, se actualiza con la posici�n siguiente
			cursor = lista.next(cursor);
		
		return element;
	}

}
