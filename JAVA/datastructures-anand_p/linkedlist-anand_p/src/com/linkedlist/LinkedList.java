package com.linkedlist;

import com.linkedlist.LinkedList;

public class LinkedList{
	String data;
	LinkedList next;

	public LinkedList insertion(LinkedList head, String data) {
		if (head == null) {
			LinkedList newNode = new LinkedList();
			newNode.data = data;
			newNode.next = null;
			return newNode;
		} else {
			LinkedList newNode = new LinkedList();
			newNode.data = data;
			newNode.next = null;
			LinkedList last = head;
			while (last.next != null)
				last = last.next;
			last.next = newNode;
		}
		return head;
	}

	public LinkedList deletion(LinkedList head, int position) {
		if (head == null) {
			System.out.println("List is Empty, No elements here ");
			return head;
		}
		LinkedList temp = head;
		if (position == 0) {
			head = temp.next; // Change head
			return head;
		}
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		if (temp == null || temp.next == null) {
			System.out.println("Select correct position !1");
			return head;
		}

		LinkedList next = temp.next.next;
		temp.next = next;
		return head;
	}

	public void print(LinkedList head) {
		LinkedList current = head;
		if (head == null) {
			System.out.println("No items in list");
			return;
		}
		System.out.println("The values inside linkedlist : ");
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.println(current.data + " ");
			current = current.next;
		}
	}
}