package com.queueoperations;
import java.util.Scanner;

class QueueOperations{
 public static void main (String[] args)
 {
	 
	 QueueOperations obj=new QueueOperations();
	 System.out.println("\n Queue Operations ");
     
     // To select the size of the array
     
     System.out.println("\n Enter the size of the Enqueue : ");
     Scanner input=new Scanner(System.in);
     Queue bike=new Queue(input.nextInt()); 
     
     // pushing the elements in the array
     
     System.out.println("\nPush Elements : ");

     bike.enqueue("Hero");
     bike.enqueue("Honda");
     bike.enqueue("Suzuki");
     bike.enqueue("RE");


     System.out.println("\nThe front element is : " + bike.peek());

    // bike.getLast();
     
     System.out.println("\nThe queue size is : " + bike.size());

     bike.dequeue();
     bike.dequeue();

     if (bike.isEmpty()) {
         System.out.println("\nThe queue is empty");
     }
     else {
         System.out.println("\nThe queue is not empty");
     }
     
 }
}

