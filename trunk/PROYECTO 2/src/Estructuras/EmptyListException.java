
package Estructuras;
/**
 * Esta excepción se dispara al intentar acceder a un elemento de una lista vacía.
 */
public class EmptyListException extends RuntimeException {

	/**
	 * Crea una excepción con una descripción del error que la disparó.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public EmptyListException(String detalles)	{
		super (detalles);
	}

}
