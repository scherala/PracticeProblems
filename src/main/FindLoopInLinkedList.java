package main;

public class FindLoopInLinkedList {
	public static void main(String args[]) {
		TestLinkedList test = new TestLinkedList(0);
		test.addMany(new int[] {1,2,3,4,5,6,7,8,9});
		test.getNthNode(10).next = test.getNthNode(8);
		System.out.println("Acutal Loop Start "+ test.getNthNode(8).value);
		System.out.println(FindLoopInLinkedList.findLoop(test).value);
	}
	public static LinkedList findLoop(LinkedList head) {
		LinkedList p1 = head.next;
		LinkedList p2 = head.next.next;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p1 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
class TestLinkedList extends FindLoopInLinkedList.LinkedList{
	public TestLinkedList(int value) {
		super(value);
	}
	
	public void addMany(int[] values) {
		FindLoopInLinkedList.LinkedList current = this;
		while(current.next != null) {
			current = current.next;
		}
		for(int value: values) {
			current.next = new FindLoopInLinkedList.LinkedList(value);
			current = current.next;
		}
	}
	
	public FindLoopInLinkedList.LinkedList getNthNode(int n){
		int counter = 1;
		FindLoopInLinkedList.LinkedList current = this;
		while(counter < n) {
			current = current.next;
			counter++;
		}
		return current;
	}
	
}

