/**
 * @author 		Magdalene Benson <mebenson12@winona.edu>
 * @version		1.0
 * @since		02/03/2014
 * 
 * @description	Implements a Linked Array List class.
 */

/**
 * Class: 		ArrayList
 * Contains:	ArrayList() 		// Default Constructor
 * 				add()
 * 				bubbleSort()
 * 				swap()
 * 				printArrayList()
 * 				size()
 * Function:	Creates a new Array List.
 */
public class ArrayList {
	
	// Instance Variables
	final int NODE_CAPACITY = 25;
	int size;	// the count of nodes in the list
	ArrayNode head, current, previous;
	int[] currentArray, nextArray;
	int arrayContains; // the count of int(s) current in the node arrays
	
	/**
	 * Constructor: ArrayList::ArrayList().
	 * 
	 * Function: 	Creates a new empty Array List with one ArrayNode.
	 * 				Sets instance variables.
	 * 
	 * @param 		None
	 */
	public ArrayList() {
		head = new ArrayNode();
		size = 1;
		arrayContains = 0;
	}
	
	/**
	 * Method: 		ArrayList::add().
	 * 
	 * Function: 	Adds the number entered by user to the Array List.
	 * 				If full capacity is reached the list is expanded.
	 * 
	 * @param 		myKey The int to be added to the Array List.
	 */
	public void add(int myKey) {
		
		if (arrayContains == NODE_CAPACITY) { 	// If this array has reached capacity
			increaseCapacity();		// increase the capacity
			arrayContains = 0;		// reset the capacity counter
		}
		
		// Start at the head
		current = head;
		previous = null;
		
		// Iterate through each Node to the last one
		while (current != null && current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		
		// Copy the array of this node
		currentArray = current.getArray();
		// if the capacity is still greater than the index, then insert the key
		if (arrayContains < currentArray.length)
			currentArray[arrayContains++] = myKey;
		
		// Return the array back to THIS node
		current.setArray(currentArray);
		
	}// Ends add() method
	
	/**
	 * Method: 		ArrayList::findIndexed().
	 * 
	 * Function: 	Returns to the user the key value located at the desired
	 * 				index being searched for.
	 * 				Throws IndexOutOfBoundsException when index entered is
	 * 				invalid or does not exist.
	 * 
	 * @param 		myIndex 	The index of the data to be returned.
	 * @return		result		Returns the key value at this index.
	 * @exception	IndexOutOfBoundsException	
	 */
	/*public int findIndexed(int myIndex)
					throws IndexOutOfBoundsException {
		
		if (myIndex > (size*NODE_CAPACITY) || myIndex < 0)
			throw new IndexOutOfBoundsException("That index does not exists.");
		
		// Start at the head
		current = head;
		previous = null;
		
		int result = 0;
		int dataIndex = 0;
		
		while ( current != null ) {						// go through each node
			currentArray = current.getArray();			// copy the array in that node
			for (int i = 0; i < NODE_CAPACITY; i++) {	// go through every data in the array
				if (dataIndex == myIndex) {				// until the index matches the desired spot
					result = currentArray[i];			// and store the result...
				}
				dataIndex++;
			}
			previous = current;
			current = current.getNext();
		}
		return result;									// ...to return to the user
		
	}// Ends add() method*/
	
	/**
	 * Method: 		ArrayList::printArrayList().
	 * 
	 * Function: 	Returns a pretty String representation of the full list array for the user.
	 * 
	 * @param 		None
	 * @return		result	The String to be printed back to the user.
	 */
	public String printArrayList() {
		String result = "";
		
		current = head;
		previous = null;
		int arrayCount = 0;
		while (current != null) {
			
			currentArray = current.getArray();
			for (int j = 0; j < currentArray.length; j++) {
				result += "[" + arrayCount + "]" + currentArray[j] + " ";
				arrayCount++;
			}
			previous = current;
			current = current.getNext();
		}
		return result;
	}// Ends printArrayList() method
	
	// Increases the size/capacity of the list with a new NodeArray
	private void increaseCapacity() {
			  
		ArrayNode newNode = new ArrayNode();
			
		current = head;
		previous = null;
			
		while (current != null && current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
			
		current.setNext(newNode);
		size++;

	}// Ends increaseCapacity() method
		
	/**
	* Method:		ArrayList::bubbleSort()
	* 
	* Function:		Sorts the contents of the data using a bubble sort algorithm.
	* 
	* @param		None
	*/
	public void bubbleSort() {
		
		int in, out, index;
		
		// loop through all the total amount of data
		for (out = (size*NODE_CAPACITY); out > 0; out--) {
			
			// start at/return to the head node
			current = head;
			// get the array of this node and the next node
			currentArray = current.getArray();
			nextArray = current.getNext().getArray();
			
			// loop through an exponential times to ensure completely sorted
			for (in = 0; in < out; in++) {
				
				// while there is still data in the current array
				// and it has not reached the end
				for (index = 1; index < currentArray.length; index++) {
						
					// check and compare each data and swap if necessary
					if (currentArray[index-1] > currentArray[index]) {
						int temp = currentArray[index];
						currentArray[index] = currentArray[index-1];
						currentArray[index-1] = temp;
					}
					// once at the last data in the array
					// compare with the first data in the next array
					// swap if necessary
					if (index == (currentArray.length-1)) {
						if (currentArray[index] > nextArray[0]) {
							int temp = nextArray[0];
							nextArray[0] = currentArray[index];
							currentArray[index] = temp;
						}
						// while there are still more nodes to sort through
						if (current.getNext() != null && current.getNext().getNext() != null) {
							// change to the next node
							current = current.getNext();
							// and get the arrays in the current and next node
							currentArray = current.getArray();
							nextArray = current.getNext().getArray();
							// continue
						}
					}
				} // End INDEX loop 
			} // End IN loop
		} // End OUT loop
		
	}// End bubbleSort() method
	
	/**
	 * Method:			ArrayList.validateOrder()
	 * 
	 * Function:		Checks to see that the ArrayList is indeed sorted.
	 * 
	 * @param			None
	 * @return			True is sorted, false otherwise.
	 */
	public boolean validateOrder() {
		boolean result = false;
		
		current = head;
		for (int i = 0; i < size; i++) {
			currentArray = current.getArray();
			
			for (int j = 1; j < currentArray.length; j++) {
				if (currentArray[j-1] > currentArray[j]) {
					result = false; 
					break;
				} else
					result = true;
			}
		}
		return result;
	}
	
	/**
	 * Method:			ArrayList::size()
	 * 
	 * Function:		Returns the number of ArrayNodes currently in the list.
	 * 
	 * @return			size	The int variable size of the Array List.
	 */
	public int size() { 
		return size; 
	}
	
	
} // End LinkedArray Class
