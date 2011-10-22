
package Estructuras;
/**
 * Esta excepci�n se dispara al intentar acceder a un elemento de una lista vac�a.
 */
public class EmptyListException extends RuntimeException {

	/**
	 * Crea una excepci�n con una descripci�n del error que la dispar�.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public EmptyListException(String detalles)	{
		super (detalles);
	}

}
