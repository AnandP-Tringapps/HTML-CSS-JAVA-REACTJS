package com.linkedlist;

import java.util.Scanner;


public class linkedlistOperations{
	public static void main(String[] args) {
		LinkedList head = null;
		
		// using scanner class we get input
        
		Scanner element = new Scanner(System.in); 
		
		// create temporary object for node class
		
		LinkedList temp = new LinkedList(); 
		
		while (true) {
			System.out.println(" 1.Insert\n 2 Delete \n 3 Display \n 4 Exit");
			System.out.println("\nSelect the option : ");
			int choice = element.nextInt();
			if (choice == 4) {
				System.out.println(" ");
				break;
			}
			switch (choice) {
			case 1:
				System.out.print("Add The element : ");
				String value = element.next();
				head = temp.insertion(head, value);
				break;
			case 2:
				System.out.print("Select the index position : ");
				int position = element.nextInt();
				head = temp.deletion(head, position);
				break;
			case 3:

				temp.print(head);
				break;
			default:
				System.out.println("Select Correct input !!");
				break;
			}
		}
	}
}