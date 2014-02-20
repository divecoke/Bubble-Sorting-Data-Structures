/**
* @author 	Magdalene Benson <mebenson12@winona.edu>
* @version 	1.1
* @since	01/18/2014
*
* @description	A class that defines an int Node.
*
*/

/**
 * Class: 		Node
 * Contains:	Node() 				// Default Constructor
 * 				Node(param) 		// User-Defined Constructor
 * 				Node(param, param) 	// User-Defined Constructor
 * 				setNext()
 * 				setInt()
 * 				getNext()
 * 				getInt()
 * Function:	Creates a new Node.
 */
public class Node {
	
	/**
	 * An int value to add to the Node.
	 */
	private int myInt;
	
	/**
	 * A Node that points to the next element/Node.
	 */
	private Node next;
	
	/**
	 * Constructor:		Node::Node()
	 * 
	 * Function:		A constructor that initializes a single Node.
	 * 					No key value assigned.
	 * 
	 * @param 			None
	 */
	public Node() {
		myInt = 0;
		next = null;	// Pointer is set to null, only one Node.
	}
	
	/**
	 * Constructor:		Node::Node(param)
	 * 
	 * Function:		A constructor that initializes a Node with a key value.
	 * 
	 * @param 			myInt	The key value to assign to the Node value.
	 */
	public Node(int myInt) {
		this.myInt = myInt;
		next = null;		//Pointer is set to null, only one Node.
	}
	
	/**
	 * Constructor:		Node::Node(param, param)
	 * 
	 * Function:		A constructor that initializes a Node with a key value and assigns
	 * 					the pointer to the 'next' Node.
	 * 
	 * @param 			myInt	The key value to assign to the Node value.
	 * @param 			next	The Node to point to 'next'.
	 */
	public Node(int myInt, Node next) {
		this.myInt = myInt;
		this.next = next;
	}
	
	/**
	 * Method:		Node::setNext()
	 * 
	 * Function:	Sets the pointer of this Node to the next Node.
	 * 
	 * @param 		next The Node to point to next.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	/**
	 * Method:		Node::setInt()
	 * 
	 * Function:	Sets the key value of this Node.
	 * 
	 * @param 		myInt	The key value to insert in the Node.
	 */
	public void setInt(int myInt) {
		this.myInt = myInt;
	}
	
	/**
	 * Method:		Node::getNext()
	 * 
	 * Function:	Returns the Node this Node is pointing to.
	 * 
	 * @param		None
	 * @return 		Returns the pointer to the next Node.
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * Method:		Node:: getInt()
	 * 
	 * Function:	Gets the key value for this Node.
	 * 
	 * @param		None
	 * @return 		Returns the key value of this Node.
	 */
	public int getInt() {
		return myInt;
	}
}
