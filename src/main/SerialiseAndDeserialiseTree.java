package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialiseTree {
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(4);
		TreeNode root_l = new TreeNode(3);
		TreeNode root_r = new TreeNode(2);
		root.left = root_l;
		root.right = root_r;
		
		TreeNode root_ll = new TreeNode(1);
		root_l.left = root_ll;
		TreeNode root_lr = new TreeNode(5);
		root_l.right = root_lr;
		TreeNode root_rl = new TreeNode(6);
		root_r.left = root_rl;
		TreeNode root_rr = new TreeNode(7);
		root_r.right = root_rr;
		TreeNode root_rll = new TreeNode(9);
		root_rl.left = root_rll;
		
		
		String serialisedData = serialize(root);
		TreeNode deserialisedData = deserialise(serialisedData);
		System.out.println(deserialisedData.val);
				
	}
	
	public static String serialize(TreeNode root) {
		//Remember to think that you have only root node
		// What if it is null?
		if(root == null) {
			return null;
		}
		//If root is not null, your job is to print the roots value and defer
		// the rest of work to recursive call of left and right functions
		return root.val + "," + serialize(root.left)+","+ serialize(root.right);
	}
	
	public static TreeNode deserialise(String data) {
		//Edge case
		if(data == null) {
			return null;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.addAll(Arrays.asList(data.split(",")));
		return deserialiseHelper(queue);
	}
	
	public static TreeNode deserialiseHelper(Queue<String> state) {
		// Remember again -A Single Node
		String first = state.poll();
		if(first.equals("null")) {
			return null;
		}
		TreeNode newNode = new TreeNode(Integer.valueOf(first));
		newNode.left = deserialiseHelper(state);
		newNode.right = deserialiseHelper(state);
		return newNode;
		
	}
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
