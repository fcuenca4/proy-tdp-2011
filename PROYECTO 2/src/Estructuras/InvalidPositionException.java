package Estructuras;

/**
 * Esta excepción se dispara al utilizar una posición inválida.
 * El significado de "inválida" dependerá del contexto en el que se dispare.
 */
public class InvalidPositionException extends RuntimeException {

	/**
	 * Crea una excepción con una descripción del error que la disparó.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public InvalidPositionException(String detalles)	{
		super (detalles);
	}

}
