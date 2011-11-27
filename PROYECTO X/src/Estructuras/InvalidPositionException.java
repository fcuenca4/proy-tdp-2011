package Estructuras;

/**
 * Esta excepci�n se dispara al utilizar una posici�n inv�lida.
 * El significado de "inv�lida" depender� del contexto en el que se dispare.
 */
public class InvalidPositionException extends RuntimeException {

	/**
	 * Crea una excepci�n con una descripci�n del error que la dispar�.
	 * 
	 * @param detalles Los detalles del error.
	 */
	public InvalidPositionException(String detalles)	{
		super (detalles);
	}

}
