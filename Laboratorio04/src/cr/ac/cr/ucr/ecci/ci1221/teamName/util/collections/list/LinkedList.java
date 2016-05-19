package cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.list;

import cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.Iterator;


import java.util.NoSuchElementException;

/**
 * Implementation of a List model using a linked list data structure.
 *
 * @param <E> the type of the elements that the list holds.
 */
public class LinkedList<E extends Comparable<E>> implements List<E> {
	
	private int size = 0; //Cantidad de elementos en la lista
	private ListNode<E> head = null; //Puntero a cabeza
	private ListNode<E> tail = null; //Puntero a cola
	
	/**
	* Adds the given element to the given position.
	*
	* @param element  the element.
	* @param position the position.
	* 
	* @throws IndexOutOfBoundsException if the index is out of range
	*/
	@Override
	public void add(E element, int position) {		
		
		if(position < 0 || position > size-1){ //Index is out of range
			throw new IndexOutOfBoundsException();
		}
		
		ListNode<E> elementNode = new ListNode<E>(); //El nuevo nodo a ser agregado
		elementNode.setTag(element); //Se asigna el elemento que contiene el nodo
		
		ListNode<E> prevElement = head; //Puntero para iterar hasta donde debe ir el nuevo nodo
		
		if(position != 0){ //No estoy agregando en la cabeza.
			for(int i=0; i<position-1; i++){ //Avanzo hasta el nodo que corresponde a la posición anterior a la deseada.
				prevElement = prevElement.getNext();		
			}	
			
			if(prevElement.hasNext() == true){ //Estoy insertando entre 2 nodos?
				elementNode.setNext(prevElement.getNext());
			}
			
			prevElement.setNext(elementNode);
		}else{ //Quiero modificar la cabeza			
			
			elementNode.setNext(head); //Pongo el nuevo nodo antes de la cabeza.
			head = elementNode; //El nuevo nodo es la cabeza ahora.
		}
		
		size++;	
	}
	
	/**
	* Removes the element at the given position.
	*
	* @param position the position.
	* 
	* @throws IndexOutOfBoundsException if the index is out of range
	*/
	@Override
	public void remove(int position) {
		
		if(position < 0 || position > size-1){ //Index is out of range
			throw new IndexOutOfBoundsException();
		}
		
		if(position == 0 || position == size-1){ //Estoy eliminando la cabeza o la cola
			
			if(position == 0){ // Quiero borrar la cabeza
			
				head = head.getNext(); //Borro la cabeza
				if(size==1){ //Si borré el unico elemento de la lista, aseguro que la cola no apunte hacia ese elemento
					tail = head;
				}
			
			}else{ //Quiero borrar la cola
			
				ListNode<E> prevElement = head; //Nodo para iterar
				for(int i=0; i<position-1; i++){ //Avanzo hasta el nodo anterior al que deseo borrar
					prevElement = prevElement.getNext();	
				}
				
				prevElement.setNext(null); 
				tail = prevElement; 
			}
			
		}else{ //Estoy eliminindo un elemento entre la cabeza y la cola(no es cabeza ni cola)
		
			ListNode<E> prevElement = head; //Nodo anterior al que deseo borrar
			
			for(int i=0; i<position-1; i++){ //Avanzo hasta el nodo anterior al que deseo borrar
				prevElement = prevElement.getNext();
			}
			
			prevElement.setNext(prevElement.getNext().getNext()); //Me brinco el elemento que deseo borrar y asigno el siguiente.
		}
		
		size--;		
	}
	
	/**
	* Returns the initial position of the given element.
	*
	* @param element the element to find.
	* @return the position of the found element if the element belongs to the list, -1 otherwise.
	*/
	@Override
	public int find(E element) {
	
		ListNode<E> nodeElement = head; //Nodo para iterar
		int position = 0; //Guarda la posición que voy a devolver
		
	/*	if(head != null){ //Lista no está vacia
			while(nodeElement.getTag().compareTo(element) != 0 && nodeElement != tail){ //Mientras no encuentre el elemento y no llegue a la cola
				nodeElement = nodeElement.getNext();
				position++;
			}
			if(nodeElement.getTag().compareTo(element) != 0){ //Si paré el while porque llegué a la cola y aun no encontré el elemento
				position = -1;
			}
		}else{ //La lista está vacia
			position = -1;
		}
		*/
		return position;
	}
	
	/**
	* Returns the element at the given position.
	*
	* @param position the position.
	* @return the element at the given position.
	* 
	* @throws IndexOutOfBoundsException if the index is out of range
	*/
	@Override
	public E get(int position) {
		
		if(position < 0 || position > size-1){ //Index out of range
			throw new IndexOutOfBoundsException();
		}
		
		ListNode<E> element = head; //Nodo para iterar
		
		for(int i=0; i<position; i++){ //Avanzo hasta la posición
			element = element.getNext();
		}
		
		return element.getTag(); //Regreso el contenido del nodo
			
	}
	
	/**
	* Replaces the element in the given position with the given element.
	*
	* @param position the position
	* @param element  the element to replace.
	* @return the replaced element.
	* 
	* @throws IndexOutOfBoundsException if the index is out of range
	*/
	@Override
	public E set(int position, E element) {
		
		if(position < 0 || position > size-1){
			throw new IndexOutOfBoundsException();
		}
		
		ListNode<E> oldElement = head; //Nodo para modificar e iterar hasta el nodo que voy a modificar
		E oldTag = element; //Guarda el contenido que voy a borrar en el nodo seleccionado
		
		for(int i=0; i<position; i++){ // Llego hasta el nodo deseado
			oldElement = oldElement.getNext();
		}
		
		oldTag = oldElement.getTag();
		oldElement.setTag(element);
	
		return oldTag;
	}
	
	/**
	* Adds an element to the end of the collection.
	*
	* @param element the element to add to the collection.
	*/
	@Override
	public void add(E element) {
		
        ListNode<E> elementNode = new ListNode<E>(); //Nuevo nodo por agregar
        elementNode.setTag(element); //Asigno el contenido del nodo
		
        if (head==null){ //La lista está vacia
            	head = elementNode;		
            	tail = elementNode;	
				
        }else{ //La lista ya tiene elementos
            	tail.setNext(elementNode);
                tail = elementNode;
        }
		
        size++;
	}
	
	/**
	* Removes an element to the collection.
	*
	* @param element the element to remove to the collection.
	*/
	@Override
	public void remove(E element) {
		
        int position = this.find(element); //Obtengo la posicion de la primera aparicion del elemento en la lista
        this.remove(position); //Remuevo esa posición
	}
	
	/**
	* Checks if the collection contains the given Element.
	*
	* @param element the element to look for.
	* @return true if the element is in the collection, false otherwise.
	*/
	@Override
	public boolean contains(E element) {
		
	/*	ListNode<E> nodeElement = head; //Nodo para iterar
		
		if(head != null){//Lista no está vacia
		
			while(nodeElement.getTag().compareTo(element) != 0 && nodeElement != tail){// Mientras no lo encuentre y no llegue a la cola
				nodeElement = nodeElement.getNext();
			}
			if(nodeElement.getTag().compareTo(element) == 0){ //Verifico si encontré el elemento en caso de parar la busqueda por llegar a la cola
				return true;
			}
		}*/
		
		return this.find(element) != -1;
	}
	
	/**
	* Returns the size of the collection.
	*
	* @return the size of the collection.
	*/
	@Override
	public int size() {
		return size;
	}
	
	/**
	* Whether the collection is empty or not.
	*
	* @return Whether the collection is empty or not
	*/
	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}
	
	/**
	* Removes all the elements from the collection.
	*/
	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;
	}
	
	/**
	* Returns an iterator over elements of type {@code T}.
	*
	* @return an Iterator.
	*/
	@Override
	public Iterator<E> iterator() {
	 myIterator it = new myIterator();	
	 return it;
	}
	
	/**
	* Sorts a collection.
	*/
	@Override
	public void sort() {
		LinkedList<E> sorted = this.mergeSort(); //Ordeno por mergesort
		head = sorted.head;	//Cabeza apunta a la cabeza de la nueva lista
		tail = sorted.tail; //Cola apunta a la cola de la nueva lista
	}
	
	/**
	* Ordenamiento mergeSort.
	* @return la lista ordenada.
	*/
	private LinkedList<E> mergeSort(){
		
		if(size < 2){ //Si es menor que 2 ya está ordenada.
			return this;
			
		}else{
			LinkedList<E> subLEven = new LinkedList<E>(); //Sublista que contiene a impares.
			LinkedList<E> subLOdd = new LinkedList<E>();  //Sublista que contiene a pares.
			ListNode<E> itNode = head;                    //Nodo utilizado para iterar.
			
			for(int i=0; i<size; i++){ //Recorro la lista dividiendola en pares e impares segun su posicion.
				
				if (i % 2 == 0) {
					  subLEven.add(itNode.getTag());
				} else {
					  subLOdd.add(itNode.getTag());
				}
				
				itNode = itNode.getNext();				
			}
			
			subLEven.sort(); //Ordeno cada sublista
			subLOdd.sort();  // de forma recursiva.
			
			return merge(subLEven, subLOdd);
		}
	}
	
	/**
	* Ordenamiento mergeSort.
	* @param evens lista de pares, odds lista de impares.
	* @return la union ordenada de evens y odds.
	*/
	private LinkedList<E> merge(LinkedList<E> evens, LinkedList<E> odds){
		
		LinkedList<E> mergedL = new LinkedList<E>(); //Lista ordenada donde se unen evens y odds.
		ListNode<E> itENode = evens.head;            //Nodo iterador para evens.
		ListNode<E> itONode = odds.head;             //Nodo iterador para odds.
		
		while(evens.isEmpty() != true && odds.isEmpty() != true){ //Recorro las listas agregando el menor entre ambos a la nueva lista.
		
		/*	if(itENode.getTag().compareTo(itONode.getTag()) < 0) { //Agrego al menor a la nueva lista y lo elimino de su lista original
				mergedL.add(itENode.getTag());
				itENode = itENode.getNext();
				evens.remove(0);
			}else{
				mergedL.add(itONode.getTag());
				itONode = itONode.getNext();
				odds.remove(0);
			}*/
		}
		
		while(evens.isEmpty() != true){ //Agrego los elementos restantes en evens.*Si este ciclo ejecuta el siguiente no.
			mergedL.add(itENode.getTag());
			itENode = itENode.getNext();
			evens.remove(0);
		}
		
		while(odds.isEmpty() != true){ //Agrego los elementos restantes en odds.*Si este ciclo ejecuta el anterior no.
			mergedL.add(itONode.getTag());
			itONode.getNext();
			odds.remove(0);
		}
		return mergedL;
	}
	
	/**
	* Implementation of an Iterator for a linked list.
	*
	*/						
	private class myIterator implements Iterator<E> {
		
		ListNode<E> usedNode = new ListNode<E>(); //Nodo para iterar
		public myIterator(){
			usedNode.setNext(head);
		}
		/**
		* Returns true if the iteration has more elements.
		*
		* @return {@code true} if the iteration has more elements.
		*/
		public boolean hasNext(){
			return usedNode.hasNext();
		}
		
		/**
		* Returns the next element in the iteration.
		*
		* @return the next element in the iteration
		* @throws NoSuchElementException if the iteration has no more elements
		*/
		public E next(){
			
			if(usedNode.hasNext()==true){
				usedNode = usedNode.getNext();
				return usedNode.getTag();
				
			}else{
				throw new NoSuchElementException();
			}

		}
		
	}
	
}
