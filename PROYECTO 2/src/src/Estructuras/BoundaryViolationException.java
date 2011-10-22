package Estructuras;
/**
 * Esta excepci�n se dispara al violar los l�mites de una lista.
 */
public class BoundaryViolationException extends RuntimeException {

	/**
	 * Crea una excepci�n con una descripci�n del error que la dispar�.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public BoundaryViolationException(String detalles)	{
		super (detalles);
	}

}
