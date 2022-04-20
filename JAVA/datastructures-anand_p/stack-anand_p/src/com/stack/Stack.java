package com.stack;

class Stack {
    private static final String Stack = null;
	String [] arr;
    int top,size;
    Stack(int size) {
        this.size=size;
        arr=new String[size];
        top=-1;
    }

    // push the element into stack
    
    public void push(String carName) {
        if(isFull()) {
            System.out.println("stack is full!");
            return;
        }
        arr[++top]=carName;
        System.out.println("Added element is : "+ arr[top]);
    }

    // method to remove element from the stack
    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }
        System.out.println("Removed element is :" + arr[top--]);
    }

    // method to display stack elements
    
    public void display() {
        if(top==-1) {
            System.out.println("No elements to display !!");
            return;
        }
        for(int i=top;i>=0;i--) {
        	System.out.print(arr[i]+" ");
        }
    }

    // method to return peek element
    
    public void peek() {
        if(!isEmpty()) {
        	System.out.println(arr[top]);
        }
        else { System.out.println("Stack is empty ");
        
        }
    }
    
    // method to display element contain in stack
    
    
    public void contains(String car) {
    String containes = null;
	if(Stack==containes) {
            System.out.println("Yes");
            return;
        }
	else {
		System.out.println();
	}
        int contains = 0;
		for(int i=contains;i>=0;i--) {
        	System.out.print(" ");
        }
    	
    }
    
    
    // method to find if stack is empty or not
    
    public boolean isEmpty() {
        if(top==-1) return true;
        return false;
    }

    // method to find is full or not
    
    public boolean isFull() {
        if(top==size -1) return true;
        return false;
    }
}