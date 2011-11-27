package Estructuras;

/**
 * Una lista es una colección de elementos ordenada en forma lineal.
 * 
 * Interfaz genérica.
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Agrega un elemento como primero de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addFirst(E element);
	
	
	/**
	 * Agrega un elemento como último de la lista.
	 * 
	 * @param element El elemento a agregar.
	 */
	public void addLast(E element);
	
	
	/**
	 * Agrega un elemento antes de una posición determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public void addBefore(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Agrega un elemento a continuación de una posición determinada.
	 * 
	 * @param element El elemento a agregar.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public void addAfter(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Establece un elemento en la posición que pasa como parámetro y devuelve el elemento reemplazado.
	 * 
	 * @param position La posición a modificar.
	 * @param element El elemento a establecer.
	 * @return El elemento reemplazado.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public E set(Position<E> position, E element) throws InvalidPositionException;
	
	
	/**
	 * Elimina la posición que pasa como parámetro y devuelve el elemento correspondiente a la misma.
	 * 
	 * @param position La posición a eliminar.
	 * @return El elemento correspondiente a la posición eliminada.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 */
	public E remove(Position<E> position) throws InvalidPositionException;
	
	
	/**
	 * Devuelve la primera posición.
	 * 
	 * @return La primera posición. Si la lista está vacía, devuelve <code>null</code>.
	 */
	public Position<E> first() throws EmptyListException;
	
	
	/**
	 * Devuelve la última posición.
	 * 
	 * @return La última posición. Si la lista está vacía, devuelve <code>null</code>.
	 */
	public Position<E> last() throws EmptyListException;
	
	
	/**
	 * Devuelve la posición anterior a la que pasa como parámetro.
	 * 
	 * @param position La posición de referencia.
	 * @return La posición anterior a la que pasa como parámetro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 * @throws BoundaryViolationException Si la posición de referencia es la última de la lista.
	 */
	public Position<E> prev(Position<E> position) throws InvalidPositionException, BoundaryViolationException;
	
	
	/**
	 * Devuelve la posición siguiente a la que pasa como parámetro.
	 * 
	 * @param position La posición de referencia.
	 * @return La posición siguiente a la que pasa como parámetro.
	 * @throws InvalidPositionException Si <code>position</code> es una referencia nula.
	 * @throws BoundaryViolationException Si la posición de referencia es la última de la lista.
	 */
	public Position<E> next(Position<E> position) throws InvalidPositionException, BoundaryViolationException;
	
	
	/**
	 * Devuelve la cantidad de elementos en la lista.
	 * 
	 * @return La cantidad de elementos en la lista.
	 */
	public int size();
	
	
	/**
	 * Determina si la lista está vacía.
	 * 
	 * @return
	 * <code>true</code> - Si la lista está vacía.
	 * <BR>
	 * <code>false</code> - Si hay al menos un elemento en la lista.
	 */
	public boolean isEmpty();

}
