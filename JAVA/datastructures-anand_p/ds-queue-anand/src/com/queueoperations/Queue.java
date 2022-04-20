package com.queueoperations;

class Queue
{
 private String[] arr;      // array to store queue elements
 private int first;      // first element in the queue
 private int last;       // last element in the queue
 private int capacity;   // capacity of the queue
 private int count;      // size of the queue

 // initialize the queue
 Queue(int size)
 {
     arr = new String[size];
     capacity = size;
     first = 0;
     last = -1;
     count = 0;
 }

 // add an item to the queue
 
 public void enqueue(String bike)
 {
     // check for queue overflow
     if (isFull())
     {
         System.out.println("Overflow");
         System.exit(-1);
     }
     
     
     System.out.println("Enqueue adding : " + bike);
     last = (last + 1) % capacity;
     arr[last] = bike;
     count++;
 }
 
 // dequeue the front element
 public String dequeue()
 {
     // check for queue underflow
     if (isEmpty())
     {
         System.out.println("Underflow");
         System.exit(-1);
     }

     String name = arr[first];

     System.out.println("\nRemoving Element : " + name);

     first = (first + 1) % capacity;
     count--;

     return name;
 }


 // return the front element of the queue
 public String peek()
 {
     if (isEmpty())
     {
         System.out.println("Underflow");
         System.exit(-1);
     }
     return arr[first];
 }

 // return the size of the queue
 public int size() {
     return count;
 }

 // check if the queue is empty or not
 public boolean isEmpty() {
     return (size() == 0);
 }

 // check the queue is full or not
 public boolean isFull() {
     return (size() == capacity);
 }


}
