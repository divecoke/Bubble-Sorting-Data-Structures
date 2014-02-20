import java.util.Random;
import java.util.Scanner;

public class sortArraysClient {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int num;
		Scanner in = new Scanner(System.in);
		int command;
		boolean endProgram = false;
		final int TEST_CAPACITY = 100;
		
		while (!endProgram) {
		
		System.out.println("\nWelcome to the Sort Array Program. Please select the Object you would like to test:\n" +
							"1 ... Simple Arrays\n" +
							"2 ... Linked Arrays\n" +
							"3 ... Linked List\n" +
							"0 ... Exit Program");
		
		command = in.nextInt();
		
		if (command > 3 && command < 0) {
			System.out.println("Please select 0-3 from the menu to continue.");
		} else {
			switch (command) {
			
			case 1:
				System.out.println("\n1. Constructing the simpleArray object with the default capacity of " + 10 + " int(s).");
				SimpleArray myArray = new SimpleArray();
				
				System.out.println("\n2.(a) Adding " + TEST_CAPACITY + " unique random numbers into the array. " +
										"(b) Printing the contents of list.");
				for (int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myArray.add(num);
				}
				System.out.println(myArray.toString());
				
				System.out.println("\n3. Sorting the data using bubble sort algorithm.");
				myArray.bubbleSort();
				
				System.out.println("\n4.(a) Printing the contents of the sorted array. " +
										"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myArray.toString());
				if (myArray.validateOrdered())
					System.out.println("The array is properly sorted from smallest to largest key.");
				else
					System.out.println("The array has not been properly sorted.");
				
				
				System.out.println("\n5.(a) Adding " + TEST_CAPACITY + " MORE unique random numbers into the array. " +
						"(b) Printing the contents of the new array.");
				for (int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myArray.add(num);
				}
				System.out.println(myArray.toString());
				
				System.out.println("\n6. Sorting the data using bubble sort algorithm.");
				myArray.bubbleSort();
				
				System.out.println("\n7.(a) Printing the contents of the sorted array. " +
						"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myArray.toString());
				if (myArray.validateOrdered())
					System.out.println("The array is properly sorted from smallest to largest key.");
				else
					System.out.println("The array has not been properly sorted.");
				
				break; // End Case 1
				
			case 2:
				//Linked Arrays Test Case
				
				System.out.println("\n1.  Constructing the ArrayList Object with the initial default capacity of 25 int(s).");
				ArrayList myAL = new ArrayList();
				
				System.out.println("\n2.(a) Adding " + TEST_CAPACITY + " numbers into the array list. " +
						"(b) Printing the contents of list.");
				for (int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myAL.add(num);
				}	
				System.out.println("The ArrayList contains " + myAL.size() + " nodes.");
				System.out.println(myAL.printArrayList());
				
				System.out.println("\n3.  Sorting the data using bubble sort algorithm.");
				myAL.bubbleSort();
				
				System.out.println("\n4.(a) Printing the contents of the sorted array list. " +
						"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myAL.printArrayList());
				if (myAL.validateOrder())
					System.out.println("The list is properly sorted from smallest to largest key.");
				else
					System.out.println("The list is not sorted.");
				
				System.out.println("\n5.(a) Adding " + TEST_CAPACITY+ " MORE unique random numbers into the list. " +
						"(b) Printing the contents of the new list.");
				for( int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myAL.add(num);
				}
				System.out.println(myAL.printArrayList());

				System.out.println("\n6. Sorting the data using sort algorithm.");
					myAL.bubbleSort();

				System.out.println("\n7.(a) Printing the contents of the new sorted list. " +
						"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myAL.printArrayList());
				if (myAL.validateOrder())
					System.out.println("The list is properly sorted from smallest to largest key.");
				else
					System.out.println("The list is not sorted.");
				
				break;
			case 3:
				//Linked List Test Case
				System.out.println("\n1.  Constructing the Linked List Object.");
				LinkedList myList = new LinkedList();
				
				System.out.println("\n2.(a) Adding " + TEST_CAPACITY + " unique random numbers into the list. " +
										"(b) Printing the contents of list.");
				for (int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myList.add(num);
				}
				System.out.println(myList.printList());
				
				System.out.println("\n3.  Sorting the data using bubble sort algorithm.");
				myList.bubbleSort();
				
				System.out.println("\n4.(a) Printing the contents of the sorted list. " +
										"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myList.printList());
				if (myList.validateOrder())
					System.out.println("The list is properly sorted from smallest to largest key.");
				else
					System.out.println("The list is not sorted.");
				
				System.out.println("\n5.(a) Adding " + TEST_CAPACITY + " MORE unique random numbers into the list. " +
										"(b) Printing the contents of the new list.");
				for( int i = 0; i < TEST_CAPACITY; i++) {
					num = rand.nextInt(999);
					myList.add(num);
				}
				System.out.println(myList.printList());
				
				System.out.println("\n6. Sorting the data using sort algorithm.");
				myList.bubbleSort();
				
				System.out.println("\n7.(a) Printing the contents of the new sorted list. " +
										"(b) Checking to see if the data entered is indeed sorted.");
				System.out.println(myList.printList());
				if (myList.validateOrder())
					System.out.println("The list is properly sorted from smallest to largest key.");
				else
					System.out.println("The list is not sorted.");
				
				break;
				
			case 0:
				System.exit(0);
				break;
				
			} // End Switch
		} // End if
		
		} // End while
		
		
	} // End Main

} // End Client Class
