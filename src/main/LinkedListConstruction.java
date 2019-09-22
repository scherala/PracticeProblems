package main;

public class LinkedListConstruction {

	static class DoublyLinkedList{
		public Node head;
		public Node tail;
		
		//Set Head
		public void setHead(Node node) {
			if(head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head,node);
		}
		//Set Tail
		public void setTail(Node node) {
			if(tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail,node);
		}
		// Insert Before
		
		public void insertBefore(Node node, Node nodeToInsert) {
			if(nodeToInsert == head && nodeToInsert== tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if(node.prev != null) {
				node.prev.next = nodeToInsert;
			}else {
				head = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}
		// Insert After
		public void insertAfter(Node node, Node nodeToInsert) {
			if(nodeToInsert == head && nodeToInsert== tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if(node.next != null) {
				node.next.prev = nodeToInsert;
			}else {
				tail = nodeToInsert;
			}
			node.next = nodeToInsert;
		}
		// Insert at a position
		public void insertAtPosition(int position, Node nodeToInsert) {
			if(position == 1) {
				setHead(nodeToInsert);
				return;
			}
			int currentPostion = 1;
			Node node = head;
			while(node != null && currentPostion++ != position) node = node.next;
			if(node == null) {
				setTail(nodeToInsert);
			}else {
				insertBefore(node,nodeToInsert);
			}
		}
		
		// Remove Nodes with value
		public void removeNodesWithValue(int value) {
			Node current = head;
			while(current != null) {
				Node nodeToRemove = current;
				current = current.next;
				if(nodeToRemove.value == value)
					remove(nodeToRemove);
			}
		}
		// Remove Node
		public void remove(Node node) {
			if(node == head) head = head.next;
			if(node == tail) tail = tail.prev;
			removeBindings(node);
		}
		// Check if the list contains a node with value
		public boolean checkNodesWithValue(int value) {
			Node current = head;
			while(current != null && current.value != value) current = current.next;
			return current != null;
		}
		
		public void removeBindings(Node node)
		{
			if(node.prev != null) node.prev.next = node.next;
			if(node.next != null) node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
					
		}
		
	}
	
	static class Node{
		public int value;
		public Node prev;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
