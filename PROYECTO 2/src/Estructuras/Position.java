package Estructuras;


/**
 * Una posici�n es un TDA utilizado, en general, por otras estructuras.
 * Se define en t�rminos de otras posiciones y almacena un elemento.
 * 
 * Interfaz gen�rica.
 */
public interface Position<E> {

	/**
	 * Devuelve el elemento almacenado.
	 * 
	 * @return El elemento almacenado.
	 */
	public E element();

}
