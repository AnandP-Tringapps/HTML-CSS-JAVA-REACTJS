package com.stack;
import java.util.Scanner;

public class StackOperations {
    public static void main(String[] args) {
    	StackOperations obj=new StackOperations();
        
        System.out.println("\n Stack Operations ");
        
        // To select the size of the array
        
        System.out.println("\n Enter the size of the stack : ");
        Scanner input=new Scanner(System.in);
        Stack car=new Stack(input.nextInt());  
        
        // pushing the elements in the array
        
        System.out.println("\nPush Elements : ");
        car.push("BMW");
        car.push("Audi");
        car.push("Benz");
        car.push("Jaguar");
        car.push("RR");
        
        // poping the elements in the array
        
        System.out.println("\nPop Elements : ");
        car.pop();
        car.pop();  
        
        // peek the elements in the array
        
        System.out.println("\nPeek Elements : ");
        car.peek();
      
        
        System.out.println("\nContains Elements : ");
        car.contains("RR");
    }
}