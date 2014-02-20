/**
*  @Author 	Magdalene Benson <thecodingbarista@gmail.com>
*  Date: 	02/18/2014  
*  Course: 	WSU-R CS341 Data Structures
*  Assignment: Assignment 3 - Sort Algorithms (ArrayNode.java)
*  
*  Description: A node that contains an int array for the use of a Linked Array List.
*/

/**
 * Class: 	ArrayNode
 * Contains:	ArrayNode() 			// Default Constructor
 * 		ArrayNode(param) 		// User-Defined Constructor
 * 		ArrayNode(param, param) 	// User-Defined Constructor
 * 		setNext()
 * 		setInt(param, param)
 * 		getNext()
 * 		getInt(param, param)
 * Function:	Creates a new ArrayNode.
 */
public class ArrayNode {
	
	/**
	 * The int array stored in the ArrayNode.
	 */
	final int DEFAULT_CAPACITY = 25;
	private int[] array;
	private int size = 0;
	
	/**
	 * A ArrayNode that points to the next element/ArrayNode.
	 */
	private ArrayNode next;
	
	/**
	 * Constructor:		ArrayNode::ArrayNode()
	 * 
	 * Function:		A constructor that initializes a single ArrayNode.
	 * 			No key value assigned.
	 * 
	 * @param 		None
	 */
	public ArrayNode() {
		array = new int[DEFAULT_CAPACITY];	// Sets array capacity to default capacity of 10.
		next = null;				// Pointer is set to null, only one ArrayArrayNode.
		size = array.length;
	}
	
	/**
	 * Method:	ArrayNode::setNext()
	 * 
	 * Function:	Sets the pointer of this ArrayNode to the next ArrayNode.
	 * 
	 * @param 	next The ArrayNode to point to next.
	 */
	public void setNext(ArrayNode next) {
		this.next = next;
	}
	/**
	 * Method:	ArrayNode::setInt()
	 * 
	 * Function:	Sets the key value of this ArrayNode.
	 * 
	 * @param 	myInt	The key value to insert in the ArrayNode's array.
	 */
	public void setArray(int[] array) {
		this.array = array;
	}
	
	/**
	 * Method:	ArrayNode::getNext()
	 * 
	 * Function:	Returns the ArrayNode this ArrayNode is pointing to.
	 * 
	 * @param	None
	 * @return 	Returns the pointer to the next ArrayNode.
	 */
	public ArrayNode getNext() {
		return next;
	}
	
	/**
	 * Method:	ArrayNode:: getArray()
	 * 
	 * Function:	Gets the key value at this index in this ArrayNode.
	 * 
	 * @return 	Returns the int array stored in this ArrayNode.
	 */
	public int[] getArray() {
		return array;
	}
	
	/**
	 * Method:	ArrayNode:: getSize()
	 * 
	 * Function:	Gets the current size of the Array Node
	 * 
	 * @return 	Returns the size of the int array stored in this ArrayNode.
	 */
	public int getSize() {
		return size;
	}
}
