package Estructuras;


/**
 * Una posición es un TDA utilizado, en general, por otras estructuras.
 * Se define en términos de otras posiciones y almacena un elemento.
 * 
 * Interfaz genérica.
 */
public interface Position<E> {

	/**
	 * Devuelve el elemento almacenado.
	 * 
	 * @return El elemento almacenado.
	 */
	public E element();

}
