package Estructuras;
/**
 * Esta excepción se dispara al violar los límites de una lista.
 */
public class BoundaryViolationException extends RuntimeException {

	/**
	 * Crea una excepción con una descripción del error que la disparó.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public BoundaryViolationException(String detalles)	{
		super (detalles);
	}

}
