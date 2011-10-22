
package Estructuras;

/**
 * Permite almacenar un elemento y referencias a otras estructuras.
 * Se utiliza en conjunto para generar estructuras dinámicas de almacenamiento.
 * 
 * Implementación genérica.
 */
public abstract class Nodo<E> implements Position<E> {

	// Atributos
	
	private E element; // Elemento almacenado
	
	
	// Métodos
	
	/**
	 * Devuelve el elemento almacenado.
	 * 
	 * @return El elemento almacenado.
	 */
	public E element() {
		return element;
	}
	
	
	/**
	 * Establece el elemento almacenado.
	 * 
	 * @param element El elemento a almacenar.
	 */
	public void setElement(E element) {
		this.element = element;
	}

}
