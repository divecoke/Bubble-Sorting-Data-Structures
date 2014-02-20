import java.util.Random;

/** 
 * @author 		Magdalene Benson <mebenson12@winona.edu>
 * @since		02/10/2014
 * @version		1.3
 * 
 * @description	A class that implements a Linked List.
 */

/**
 * Class: 		LinkedList
 * Contains:	LinkedList() 		// Default Constructor
 * 				LinkedList(param) 	// User-Defined Constructor
 * 				add()
 * 				findIndexed()
 * 				bubbleSort()
 * 				printList()
 * 				toString() 			// Overrides default
 * 				isEmpty()
 * 				size()
 * Function:	Creates a new  Linked List.
 */
public class LinkedList {
	
	// Instance Variables
	Node head, previous, current;
	int size;
	Random rand = new Random();
	
	/**
	 * Constructor: LinkedList::LinkedList().
	 * 
	 * Function: 	Creates a new empty Linked List.
	 * 				Sets instance variables.
	 * 
	 * @param 		None
	 */
	public LinkedList() {
		head = null;
	    size = 0;
	} // End Constructor method
	
	/**
	 * Method: 		LinkedList::add().
	 * 
	 * Function: 	Adds the number entered by user to the Linked List.
	 * 				It is added into the list in order from smallest to largest.
	 * 
	 * @param 		myKey The int to be added to the  Linked List.
	 */
	public void add(int myKey) {
	    
		// If the list is empty, insert the first Node as the head
		if (isEmpty()) {
			Node newNode = new Node(myKey);
			head = newNode;
			size++;
		} else {
		
		// Start at the head Node
	    current = head;
	    previous = null;
	    
	    // Check through each Node and make sure the
	    // key being entered does not already exists.
	    for (int i = 0; i < size; i++) {
	    	while (current != null && current.getNext() != null) {
	    		if (current.getInt() == myKey || current.getNext().getInt() == myKey)
	    			myKey = rand.nextInt(399);
	    		
	    		previous = current;
	    		current = current.getNext();
	    		
	    		//if (current.getInt() == myKey)
	    		//	myKey = rand.nextInt(399);
	    	}
	    }
	    
	    // Create the new Node with the unique key to insert into the list
	 	Node newNode = new Node(myKey, null);	
	    current.setNext(newNode);
	    size++;		// Increase the size of the List
	    
		}
	    
	} // End add() method
	
	/**
	 * Method: 		LinkedList::findIndexed().
	 * 
	 * Function: 	Finds the key at the user-defined index and prints the
	 * 				key value found back to the user.
	 * 
	 * @param 		myIndex 					The Key int to be removed from the Linked List.
	 * @exception	IndexOutOfBoundsException 	Thrown when index does not exist in the list.
	 * @exception	EmptyListException 			Thrown when the list is empty.
	 */
	public int findIndexed(int myIndex)
			throws IndexOutOfBoundsException	{
		
		if (myIndex > size || myIndex < 0)
			throw new IndexOutOfBoundsException("The index " + myIndex + " does not exist.");
		
		int result = 0;
		current = head;
		
		for (int i = 0; i < size; i++) {
			if (i == myIndex)
				return current.getInt();
			else {
				current = current.getNext();
			}
		}
		return result;
	} // End findIndexed() method

	/**
	 * Method: 		LinkedList::validateOrder().
	 * 
	 * Function: 	Goes through each Node in the list to validate
	 * 				it is ordered from smallest to largest key int.
	 * 
	 * @param 		None
	 * @return		Returns true if the list has been sorted properly, false otherwise.
	 */
	public boolean validateOrder() {
		
		boolean result = true;
		current = head;
		
		for (int i = 1; i < size; i++) {
			if (findIndexed(i-1) > findIndexed(i))
				result = false;
			else
				result = true;
		}
		
		return result;
	}
	
	/**
	 * Method: 		LinkedList::printList().
	 * 
	 * Function: 	Returns a pretty String representation of the list for the user.
	 * 
	 * @param 		None
	 * @return		result	The String to be printed back to the user.
	 */
	public String printList() {
	    
	    current = head;							// Start at the head,
	    String result = "";
	    int nodeIndex = 0;
	    
	    while (current != null){				// iterate through each Node
	       result += "[" + nodeIndex + "]" + current.getInt() + " ";	// and get the value
	       current = current.getNext();
	       nodeIndex++;
	    }  
	    
	    return result;							// to print back to the user.

	} // End printList() method
	
	/**
	 * Method:			LinkedList::bubbleSort()
	 * 
	 * Function:		Sorts the contents of the data using a bubble sort algorithm.
	 * 
	 * @param			None
	 */
	public void bubbleSort() {
		
		if (isEmpty())
	        System.out.println("An empty list is already sorted."); 
	    else if (head.getNext() == null)
	        System.out.println("A one-link list is already sorted.");
	    else {
	        current = head;
	        boolean swapDone = true;
	        while (swapDone) {
	            
	        	swapDone = false;
	            while (current != null) {
	                
	            	if (current.getNext() != null && current.getInt() > current.getNext().getInt()) {
	                    int temp = current.getInt();
	                    current.setInt(current.getNext().getInt());
	                    current.getNext().setInt(temp);
	                    swapDone = true;
	                }
	                current = current.getNext();
	            }
	            current = head;
	        } // End swapDone while
	    } // End else
		
	} // End bubbleSort() method
	
	/**
	 * Method:			LinkedList::size()
	 * 
	 * Function:		Returns the size variable of the Linked List.
	 * 
	 * @return			size	The int variable size of the Linked List.
	 */
	public int size() { 
		return size;
	}

	//Checks to see if List is Empty
	private boolean isEmpty() { 
		if (head == null)
	       return true;
	    else
	       return false;
	} // End isEmpty() method
	
} // End LinkedList Class

