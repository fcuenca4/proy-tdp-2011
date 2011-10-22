
package Estructuras;

import java.util.Iterator; 



/**
 * Modela el comportamiento de una lista.
 * 
 * Implementación genérica.
 */
public class ListaSE<E> implements List<E> {

	// Atributos
	
	private NodoListaSE<E> head; // Primera posición de la lista
	private NodoListaSE<E> tail; // Última posición de la lista
	private int size; // Cantidad de elementos en la lista
	
	
	// Constructores
	
	/**
	 * Crea una lista vacía.
	 */
	public ListaSE() {
		head = tail = null;
		size = 0;
	}
	
	
	// Métodos
	
	/**
	 * Devuelve un iterador para recorrer los elementos de esta lista.
	 * 
	 * @returns Un iterador.
	 */
	public Iterator<E> iterator() {
		return new IteradorLista<E>(this);
	}
	
	
	/**
	 * Agrega un elemento como primero de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addFirst(E element) {
		
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element, head);
		
		if (isEmpty())
			// Si la lista está vacía, inicializa head y tail
			head = tail = nodoNuevo;
		else
			// Si la lista no está vacía, actualiza head
			head = nodoNuevo;
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Agrega un elemento como último de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addLast(E element) {
		
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element);
		
		if (isEmpty())
			// Si la lista está vacía, inicializa head y tail
			head = tail = nodoNuevo;
		else {
			// Si la lista no está vacía, actualiza tail
			tail.setNext(nodoNuevo);
			tail = nodoNuevo; // Establece al nuevo nodo como el último nodo de la lista
		}
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Agrega un elemento antes de una posición determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo válido o no pertenece a esta lista.
	 */
	public void addBefore(Position<E> position, E element) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element, nodo);
		
		if (nodo == head)
			
			// Si el nodo es el primero de la lista, se actualiza head
			head = nodoNuevo;
			
		else {
			
			NodoListaSE<E> nodoAnterior = validarPosicion(prev(position));
			nodoAnterior.setNext(nodoNuevo);
			
		}
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Agrega un elemento a continuación de una posición determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo válido.
	 */
	public void addAfter(Position<E> position, E element) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element, nodo.getNext());
		
		nodo.setNext(nodoNuevo);
		
		if (nodo == tail)
			// Si el nodo es el último de la lista, se actualiza tail
			tail = nodoNuevo;
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Establece un elemento en la posición que pasa como parámetro y devuelve el elemento reemplazado.
	 * 
	 * @param position La posición a modificar.
	 * @param element El elemento a establecer.
	 * @return El elemento reemplazado.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo válido.
	 */
	public E set(Position<E> position, E element) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		E elementReturn = nodo.element(); // Almacena el elemento a devolver
		
		nodo.setElement(element); // Establece el nuevo elemento en el nodo
		
		return elementReturn;
	}
	
	
	/**
	 * Elimina la posición que pasa como parámetro y devuelve el elemento correspondiente a la misma.
	 * 
	 * @param position La posición a eliminar.
	 * @return El elemento correspondiente a la posición eliminada.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo válido o no pertenece a esta lista.
	 */
	public E remove(Position<E> position) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		E element = nodo.element(); // Almacena el elemento a devolver
		
		if (nodo == head)
			
			head = nodo.getNext();
			
		else {
			
			NodoListaSE<E> nodoAnterior = validarPosicion(prev(position));
			nodoAnterior.setNext(nodo.getNext());
			
			if (nodo == tail)
				// Si el nodo eliminado es el último, se actualiza tail
				tail = nodoAnterior;
			
		}
		
		// Se anulan las referencias del nodo eliminado
		nodo.setNext(null);
		nodo.setElement(null);
		
		size--; // Decrementa la cantidad de elementos de la lista
		
		if (isEmpty())
			// Si la lista se vació, se anulan las referencias
			head = tail = null;
		
		return element;
	}
	
	
	/**
	 * Devuelve la primera posición.
	 * 
	 * @return La primera posición. Si la lista está vacía, devuelve <code>null</code>.
	 * @throws EmptyListException Si la lista está vacía.
	 */
	public Position<E> first() throws EmptyListException {
		
		if (isEmpty())
			throw new EmptyListException("Se intentó acceder a una posición de una lista vacía. " +
										  "Throwed by: ListaSE.first()");
		
		return head;
	}
	
	
	/**
	 * Devuelve la última posición.
	 * 
	 * @return La última posición. Si la lista está vacía, devuelve <code>null</code>.
	 * @throws EmptyListException Si la lista está vacía.
	 */
	public Position<E> last() throws EmptyListException {
		
		if (isEmpty())
			throw new EmptyListException("Se intentó acceder a una posición de una lista vacía. " +
										  "Throwed by: ListaSE.last()");
		
		return tail;
	}
	
	
	/**
	 * Devuelve la posición anterior a la que pasa como parámetro.
	 * 
	 * @param position La posición de referencia.
	 * @return La posición anterior a la que pasa como parámetro.
	 * @throws InvalidPositionException Si el parámetro es una referencia nula.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo válido o no pertenece a esta lista.
	 */
	public Position<E> prev(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		if (nodo == head)
			// Si el nodo es el primero de la lista, dispara una excepción
			throw new BoundaryViolationException("Se intentó acceder a una posición fuera de límite. " +
												 "Throwed by: ListaSE.prev(Position<E> position)");
		
		NodoListaSE<E> nodoAnterior = head;
		NodoListaSE<E> nodoBuscador = nodoAnterior.getNext();
		
		while (nodoBuscador != nodo && nodoBuscador != null) {
			nodoAnterior = nodoBuscador;
			nodoBuscador = nodoAnterior.getNext();
		}
		
		if (nodoBuscador == null)
			// No se encontró la posición
			throw new InvalidPositionException("Se ingresó una posición no correspondiente a esta lista. " +
			   								   "Throwed by: ListaSE.prev(Position<E> position)");
		
		return nodoAnterior;
	}
	
	
	/**
	 * Devuelve la posición siguiente a la que pasa como parámetro.
	 * 
	 * @param position La posición de referencia.
	 * @return La posición siguiente a la que pasa como parámetro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo válido.
	 * @throws BoundaryViolationException Si la posición de referencia es la última de la lista.
	 */
	public Position<E> next(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		if (nodo == tail)
			// Si el nodo es el último de la lista, se dispara una excepción
			throw new BoundaryViolationException("Se intentó acceder a una posición fuera de límite. " +
												 "Throwed by: ListaSE.next(Position<E> position)");
		
		return nodo.getNext();
	}
	
	
	/**
	 * Devuelve la cantidad de elementos en la lista.
	 * 
	 * @return La cantidad de elementos en la lista.
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * Determina si la lista está vacía.
	 * 
	 * @return
	 * true - Si la lista está vacía.
	 * <BR>
	 * false - Si hay al menos un elemento en la lista.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	
	/**
	 * Verifica que la posición que pasa como parámetro no es una referencia nula,
	 * y que es un nodo utilizable en una lista simplemente enlazada.
	 * 
	 * No verifica que pertenezca a esta lista.
	 */
	private NodoListaSE<E> validarPosicion(Position<E> position) throws InvalidPositionException {
		
		if (position == null)
			// Si la referencia es nula, se dispara una excepción
			throw new InvalidPositionException("Se ingresó una posición nula. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
		
		if (isEmpty())
			// Si la lista está vacía, se dispara una excepción
			throw new InvalidPositionException("Se ingresó una posición no correspondiente a esta lista. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
		
		try {
			
			NodoListaSE<E> nodo = (NodoListaSE<E>)position;
			return nodo;
			
		} catch(ClassCastException exc) {
			
			// La posición no era un nodo válido para esta lista
			throw new InvalidPositionException("Se ingresó una posición inválida en esta lista. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
			
		}
	}

}
