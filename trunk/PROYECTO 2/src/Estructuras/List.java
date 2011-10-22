package Estructuras;

/**
 * Una lista es una colecci�n de elementos ordenada en forma lineal.
 * 
 * Interfaz gen�rica.
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Agrega un elemento como primero de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addFirst(E element);
	
	
	/**
	 * Agrega un elemento como �ltimo de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addLast(E element);
	
	
	/**
	 * Agrega un elemento antes de una posici�n determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public void addBefore(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Agrega un elemento a continuaci�n de una posici�n determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public void addAfter(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Establece un elemento en la posici�n que pasa como par�metro y devuelve el elemento reemplazado.
	 * 
	 * @param position La posici�n a modificar.
	 * @param element El elemento a establecer.
	 * @return El elemento reemplazado.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public E set(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Elimina la posici�n que pasa como par�metro y devuelve el elemento correspondiente a la misma.
	 * 
	 * @param position La posici�n a eliminar.
	 * @return El elemento correspondiente a la posici�n eliminada.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public E remove(Position<E> position) throws InvalidPositionException;
	
	
	/**
	 * Devuelve la primera posici�n.
	 * 
	 * @return La primera posici�n. Si la lista est� vac�a, devuelve <code>null</code>.
	 */
	public Position<E> first() throws EmptyListException;
	
	
	/**
	 * Devuelve la �ltima posici�n.
	 * 
	 * @return La �ltima posici�n. Si la lista est� vac�a, devuelve <code>null</code>.
	 */
	public Position<E> last() throws EmptyListException;
	
	
	/**
	 * Devuelve la posici�n anterior a la que pasa como par�metro.
	 * 
	 * @param position La posici�n de referencia.
	 * @return La posici�n anterior a la que pasa como par�metro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 * @throws BoundaryViolationException Si la posici�n de referencia es la �ltima de la lista.
	 */
	public Position<E> prev(Position<E> position) throws InvalidPositionException, BoundaryViolationException;
	
	
	/**
	 * Devuelve la posici�n siguiente a la que pasa como par�metro.
	 * 
	 * @param position La posici�n de referencia.
	 * @return La posici�n siguiente a la que pasa como par�metro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 * @throws BoundaryViolationException Si la posici�n de referencia es la �ltima de la lista.
	 */
	public Position<E> next(Position<E> position) throws InvalidPositionException, BoundaryViolationException;
	
	
	/**
	 * Devuelve la cantidad de elementos en la lista.
	 * 
	 * @return La cantidad de elementos en la lista.
	 */
	public int size();
	
	
	/**
	 * Determina si la lista est� vac�a.
	 * 
	 * @return
	 * <code>true</code> - Si la lista est� vac�a.
	 * <BR>
	 * <code>false</code> - Si hay al menos un elemento en la lista.
	 */
	public boolean isEmpty();

}
