/**
*  @Author 	Magdalene Benson <thecodingbarista@gmail.com>
*  Date:	02/18/2014  
*  Course: 	WSU-R CS341 Data Structures
*  Assignment: Assignment 3 - Sorting Algorithms (SimpleArray.java)
*  
*  Description: Implements a dynamic iny array.
*/

import java.util.Arrays;
import java.util.Random;
/**
 * Class:	SimpleArray
 * Contains:	SimpleArray()	// Default Constructor
 * 		add()
 * 		validateOrdered()
 * 		findIndexed()
 * 		bubbleSort()
 * 		expand()
 * 		toString()
 * Function:	Creates a SimpleArray object.
 */
public class SimpleArray {

	// Absolutes
	final int SIZE = 10;
	
	// Instance Variables
	Random rand = new Random();
	int[] data;
	int myInt;
	int size;
	
	/**
	 * Constructor:	SimpleArray::SimpleArray()
	 * 
	 * Function:	Sets the instance variables for the data object created.
	 * 
	 * @param	None
	 */
	public SimpleArray() {
		data = new int[SIZE]; 	// initialize the array
		myInt = 0;		// set the instance variables
		size = 0;		// nothing in the array yet
		
	} // End Default Constructor
	
	/**
	 * Method:	SimpleArray::add()
	 * 
	 * Function:	Adds the key value to the next position in the data.
	 * 		Copies contents to bigger storage allocation if needed.
	 * 
	 * @param	myInt 		The key value to add to the data.
	 * @return	boolean		Return true if the int was successfully added to the array.
	 */
	public void add(int myInt) {
		
		// first check to see if int already exists in the array
		for (int i = 0; i < data.length; i++) {
			if (data[i] == myInt) {
				myInt = rand.nextInt(399);
			}
		}
		
		expand(size + 1);		// Expand capacity
		data[size++] = myInt;		// Add int to the array
		
	} // End add() method
	
	/**
	 * Method:	SimpleArray::validateOrdered()
	 * 
	 * Function:	Checks the value at this index and returns value to the user.
	 * 
	 * @param	None
	 * @return	Returns true if the array has been ordered properly, false otherwise.
	 */
	public boolean validateOrdered() {
		boolean result = false;
		
		for (int i = 1; i < data.length; i++) {
			if (findIndexed(i-1) > findIndexed(i))
				result = false;
			else
				result = true;
		}
		return result;
	} // End validateOrdered() method
	
	// The helper method for the validateOrder method.
	private int findIndexed(int myIndex)
					throws IndexOutOfBoundsException {
			
		if (myIndex > data.length)
			throw new IndexOutOfBoundsException("The index " + myIndex + " does not exists.");
		else
			return data[myIndex];
			
	} // End findIndexed() method
	
	/**
	 * Method:	SimpleArray::bubbleSort()
	 * 
	 * Function:	Sorts the contents of the data using a bubble sort algorithm.
	 * 
	 * @param	None
	 */
	public void bubbleSort() {
		int in, out;
		for (out = size-1; out > 1; out--) {	// outer loop (backwards)
			for (in = 0; in < out; in++) {		// inner loop (forwards)
				if (data[in] > data[in+1])		// out of order?
					swap(in, in+1);				// swap them!
			}
		}
	} // End bubbleSort() method
	
	// A helper method for the bubble sort
	private void swap(int one, int two) {
		int temp = data[one];
		data[one] = data[two];
		data[two] = temp;
	}  // End swap() method
	
	// A method to expand the array when more space is required in the array.
	private void expand(int minCapacity) {
		
		int oldCapacity = data.length;		// Get current capacity
		
	    if (minCapacity > oldCapacity) {		// If more storage is needed
	      int newCapacity = oldCapacity + 1;	// Increase capacity
	      
	      if (newCapacity < minCapacity)
	        newCapacity = minCapacity;
	      
	      data = Arrays.copyOf(data, newCapacity);	// Copy data from old array into new array
	    }
	} // End expand() method
	
	/**
	 * Method:	SimpleArray::toString()
	 * 
	 * Function:	Generates a String to print for the user 
	 * 		to show contents of the  SimpleArray.
	 * 
	 * @return	result	The String of data from the array.
	 * @overrides	java.lang.Object.toString
	 */
	public String toString() {
		
		String result = "";
		
		for (int i = 0; i < data.length; i++) {
			result += "[" + i + "]" + data[i] + " ";
		}
		
		return result;
	} // End toString() method
	
} // End SimpleArray Class
