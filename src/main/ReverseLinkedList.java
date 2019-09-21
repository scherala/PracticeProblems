package main;

import main.ReverseLinkedList.LinkedList.Node;

public class ReverseLinkedList {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(); 
        Node head = new Node(85); 
        list.head = head;
        list.head.next = new Node(15); 
        list.head.next.next = new Node(4); 
        list.head.next.next.next = new Node(20); 
  
        System.out.println("Given Linked list"); 
        list.printList(head); 
        head = list.reverseList(head); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        list.printList(head); 
	}
	
	static class LinkedList{
		static Node head;
		
		public static Node reverseList(Node head) {
			//Initialise two variables for storing the previous and current Nodes
			Node prev = null;
			Node current = head;
			
			while(current != null) {
				Node next = current.next;
				current.next = prev;
				
				prev = current;
				current = next;
			}
			return prev;
		}
		
		public static void printList(Node head) {
			Node current = head;
			while(current != null) {
				System.out.print(current.value + " ");
				current = current.next;
			}
		}
		static class Node{
			int value;
			Node next;
			
			public Node(int value) {
				this.value = value;
				this.next = null;
			}
		}
	}
	
}
