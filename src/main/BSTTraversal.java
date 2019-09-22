package main;

import java.util.ArrayList;

public class BSTTraversal {

	public static void main(String args[]) {
		
		Node root = new Node(10);
		Node left = new Node(5);
		Node right = new Node(15);
		root.left = left;
		root.right = right;
		
		Node left_1 = new Node(2);
		Node right_1 = new Node(5);
		left.left = left_1;
		left.right = right_1;
		left_1.left = new Node(1);
		right.right = new Node(22);
		ArrayList<Integer> array = new ArrayList<Integer>();
		array = BST.inOrderTraversal(root, array);
		for(Integer res: array) {
			System.out.print(res +" ");
		}
		System.out.println();
		array = new ArrayList<Integer>();
		array = BST.preOrderTraversal(root, array);
		for(Integer res: array) {
			System.out.print(res +" ");
		}
		System.out.println();
		
		array = new ArrayList<Integer>();
		array = BST.postOrderTraversal(root, array);
		for(Integer res: array) {
			System.out.print(res +" ");
		}
		System.out.println();
	}
	
	static class BST{
		public static ArrayList<Integer> inOrderTraversal(Node root, ArrayList<Integer> array){
			if(root.left != null) {
				inOrderTraversal(root.left, array);
			}
			if(root != null) {
				array.add(root.value);
			}
			if(root.right != null) {
				inOrderTraversal(root.right, array);
			}
			return array;
		}
		
		public static ArrayList<Integer> preOrderTraversal(Node root, ArrayList<Integer> array){
			if(root != null) {
				array.add(root.value);
			}
			if(root.left != null) {
				preOrderTraversal(root.left, array);
			}
			if(root.right != null) {
				preOrderTraversal(root.right, array);
			}
			return array;
		}
		
		public static ArrayList<Integer> postOrderTraversal(Node root, ArrayList<Integer> array){
			if(root.left != null) {
				postOrderTraversal(root.left, array);
			}
			if(root.right != null) {
				postOrderTraversal(root.right, array);
			}
			if(root != null) {
				array.add(root.value);
			}
			return array;
		}
	}
	
	static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
