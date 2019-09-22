package main;

public class RemoveKthNodeFromEnd {

	//Removing Kth Node from end of a Singly LinkedList
	// Using Two pointer Technique
	
	public static void removeKthNode(LinkedList head, int k) {
		LinkedList first = head;
		LinkedList second = head;
		int counter = 0;
		while(counter++ < k) {
			second = second.next;
		}
		if(second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while(second.next != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
		
	}
	static class LinkedList{
		int value;
		LinkedList next;
		public LinkedList(int value) {
			this.value= value;
		}
	}
}
