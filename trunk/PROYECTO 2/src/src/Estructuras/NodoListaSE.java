
package Estructuras;


/**
 * Permite almacenar un elemento y una referencia a un nodo siguiente.
 * Se utiliza en conjunto para generar listas simplemente enlazadas.
 * 
 * Implementación genérica.
 */
public class NodoListaSE<E> extends Nodo<E> {

	// Atributos
	
	private NodoListaSE<E> next; // Referencia al nodo siguiente
	
	
	// Constructores
	
	/**
	 * Crea un nodo con un determinado elemento almacenado y una referencia al nodo siguiente.
	 * 
	 * @param element El elemento a almacenar.
	 * @param next La referencia al nodo siguiente.
	 */
	public NodoListaSE(E element, NodoListaSE<E> next) {
		setElement(element);
		this.next = next;
	}
	
	
	/**
	 * Crea un nodo con un determinado elemento almacenado.
	 * 
	 * @param element El elemento a almacenar.
	 */
	public NodoListaSE(E element) {
		this(element, null);
	}
	
	
	// Métodos
	
	/**
	 * Devuelve el nodo siguiente.
	 * 
	 * @return El nodo siguiente.
	 */
	public NodoListaSE<E> getNext() {
		return next;
	}
	
	
	/**
	 * Establece el nodo siguiente.
	 * 
	 * @param next El nodo siguiente.
	 */
	public void setNext(NodoListaSE<E> next) {
		this.next = next;
	}

}
