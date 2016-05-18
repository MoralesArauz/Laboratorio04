package cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.list;




/**
 * List node for a linked list.
 *
 * @param <E> the type of the elements that the node holds.
 */
public class ListNode<E> {
	
	private E tag = null;	//Contenido del nodo
	private ListNode<E> next = null; //Puntero a siguiente nodo
	
	/**
	* Sustituye el contenido del nodo
	*
	* @param newTag el nuevo contenido.
	*/
	public void setTag(E newTag){
		tag = newTag;
	}
	
	/**
	* Regresa el contenido del nodo
	*
	* @return el contenido.
	*/
	public E getTag(){
		return tag;
	}
	
	/**
	* Regresa el siguiente nodo
	*
	* @return el siguiente nodo.
	*/
	public ListNode<E> getNext(){
		return next;
	}
	
	/**
	* Cambia a cual es el nodo que apunta este nodo
	*
	* @param element el nodo al cual apuntar.
	*/
	public void setNext(ListNode<E> element){
		next = element;
	}
	
	/**
	* Regresa true si apunta a un siguiente nodo
	*
	* @return el nodo al cual apunta.
	*/
	public boolean hasNext(){
		
		if(next == null){			
			return false;
		}
		
		return true;
	}
	
	
	

}