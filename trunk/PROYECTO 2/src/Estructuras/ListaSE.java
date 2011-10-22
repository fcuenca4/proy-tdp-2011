
package Estructuras;

import java.util.Iterator; 



/**
 * Modela el comportamiento de una lista.
 * 
 * Implementaci�n gen�rica.
 */
public class ListaSE<E> implements List<E> {

	// Atributos
	
	private NodoListaSE<E> head; // Primera posici�n de la lista
	private NodoListaSE<E> tail; // �ltima posici�n de la lista
	private int size; // Cantidad de elementos en la lista
	
	
	// Constructores
	
	/**
	 * Crea una lista vac�a.
	 */
	public ListaSE() {
		head = tail = null;
		size = 0;
	}
	
	
	// M�todos
	
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
			// Si la lista est� vac�a, inicializa head y tail
			head = tail = nodoNuevo;
		else
			// Si la lista no est� vac�a, actualiza head
			head = nodoNuevo;
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Agrega un elemento como �ltimo de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addLast(E element) {
		
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element);
		
		if (isEmpty())
			// Si la lista est� vac�a, inicializa head y tail
			head = tail = nodoNuevo;
		else {
			// Si la lista no est� vac�a, actualiza tail
			tail.setNext(nodoNuevo);
			tail = nodoNuevo; // Establece al nuevo nodo como el �ltimo nodo de la lista
		}
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Agrega un elemento antes de una posici�n determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo v�lido o no pertenece a esta lista.
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
	 * Agrega un elemento a continuaci�n de una posici�n determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo v�lido.
	 */
	public void addAfter(Position<E> position, E element) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		NodoListaSE<E> nodoNuevo = new NodoListaSE<E>(element, nodo.getNext());
		
		nodo.setNext(nodoNuevo);
		
		if (nodo == tail)
			// Si el nodo es el �ltimo de la lista, se actualiza tail
			tail = nodoNuevo;
		
		size++; // Incrementa la cantidad de elementos de la lista
	}
	
	
	/**
	 * Establece un elemento en la posici�n que pasa como par�metro y devuelve el elemento reemplazado.
	 * 
	 * @param position La posici�n a modificar.
	 * @param element El elemento a establecer.
	 * @return El elemento reemplazado.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo v�lido.
	 */
	public E set(Position<E> position, E element) throws InvalidPositionException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		E elementReturn = nodo.element(); // Almacena el elemento a devolver
		
		nodo.setElement(element); // Establece el nuevo elemento en el nodo
		
		return elementReturn;
	}
	
	
	/**
	 * Elimina la posici�n que pasa como par�metro y devuelve el elemento correspondiente a la misma.
	 * 
	 * @param position La posici�n a eliminar.
	 * @return El elemento correspondiente a la posici�n eliminada.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo v�lido o no pertenece a esta lista.
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
				// Si el nodo eliminado es el �ltimo, se actualiza tail
				tail = nodoAnterior;
			
		}
		
		// Se anulan las referencias del nodo eliminado
		nodo.setNext(null);
		nodo.setElement(null);
		
		size--; // Decrementa la cantidad de elementos de la lista
		
		if (isEmpty())
			// Si la lista se vaci�, se anulan las referencias
			head = tail = null;
		
		return element;
	}
	
	
	/**
	 * Devuelve la primera posici�n.
	 * 
	 * @return La primera posici�n. Si la lista est� vac�a, devuelve <code>null</code>.
	 * @throws EmptyListException Si la lista est� vac�a.
	 */
	public Position<E> first() throws EmptyListException {
		
		if (isEmpty())
			throw new EmptyListException("Se intent� acceder a una posici�n de una lista vac�a. " +
										  "Throwed by: ListaSE.first()");
		
		return head;
	}
	
	
	/**
	 * Devuelve la �ltima posici�n.
	 * 
	 * @return La �ltima posici�n. Si la lista est� vac�a, devuelve <code>null</code>.
	 * @throws EmptyListException Si la lista est� vac�a.
	 */
	public Position<E> last() throws EmptyListException {
		
		if (isEmpty())
			throw new EmptyListException("Se intent� acceder a una posici�n de una lista vac�a. " +
										  "Throwed by: ListaSE.last()");
		
		return tail;
	}
	
	
	/**
	 * Devuelve la posici�n anterior a la que pasa como par�metro.
	 * 
	 * @param position La posici�n de referencia.
	 * @return La posici�n anterior a la que pasa como par�metro.
	 * @throws InvalidPositionException Si el par�metro es una referencia nula.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula, no es de un tipo v�lido o no pertenece a esta lista.
	 */
	public Position<E> prev(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		if (nodo == head)
			// Si el nodo es el primero de la lista, dispara una excepci�n
			throw new BoundaryViolationException("Se intent� acceder a una posici�n fuera de l�mite. " +
												 "Throwed by: ListaSE.prev(Position<E> position)");
		
		NodoListaSE<E> nodoAnterior = head;
		NodoListaSE<E> nodoBuscador = nodoAnterior.getNext();
		
		while (nodoBuscador != nodo && nodoBuscador != null) {
			nodoAnterior = nodoBuscador;
			nodoBuscador = nodoAnterior.getNext();
		}
		
		if (nodoBuscador == null)
			// No se encontr� la posici�n
			throw new InvalidPositionException("Se ingres� una posici�n no correspondiente a esta lista. " +
			   								   "Throwed by: ListaSE.prev(Position<E> position)");
		
		return nodoAnterior;
	}
	
	
	/**
	 * Devuelve la posici�n siguiente a la que pasa como par�metro.
	 * 
	 * @param position La posici�n de referencia.
	 * @return La posici�n siguiente a la que pasa como par�metro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula o no es de un tipo v�lido.
	 * @throws BoundaryViolationException Si la posici�n de referencia es la �ltima de la lista.
	 */
	public Position<E> next(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
		
		NodoListaSE<E> nodo = validarPosicion(position);
		
		if (nodo == tail)
			// Si el nodo es el �ltimo de la lista, se dispara una excepci�n
			throw new BoundaryViolationException("Se intent� acceder a una posici�n fuera de l�mite. " +
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
	 * Determina si la lista est� vac�a.
	 * 
	 * @return
	 * true - Si la lista est� vac�a.
	 * <BR>
	 * false - Si hay al menos un elemento en la lista.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	
	/**
	 * Verifica que la posici�n que pasa como par�metro no es una referencia nula,
	 * y que es un nodo utilizable en una lista simplemente enlazada.
	 * 
	 * No verifica que pertenezca a esta lista.
	 */
	private NodoListaSE<E> validarPosicion(Position<E> position) throws InvalidPositionException {
		
		if (position == null)
			// Si la referencia es nula, se dispara una excepci�n
			throw new InvalidPositionException("Se ingres� una posici�n nula. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
		
		if (isEmpty())
			// Si la lista est� vac�a, se dispara una excepci�n
			throw new InvalidPositionException("Se ingres� una posici�n no correspondiente a esta lista. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
		
		try {
			
			NodoListaSE<E> nodo = (NodoListaSE<E>)position;
			return nodo;
			
		} catch(ClassCastException exc) {
			
			// La posici�n no era un nodo v�lido para esta lista
			throw new InvalidPositionException("Se ingres� una posici�n inv�lida en esta lista. " +
											   "Throwed by: ListaSE.validarPosicion(Position<E> position)");
			
		}
	}

}
