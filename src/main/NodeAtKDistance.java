package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeAtKDistance {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(2);
		TreeNode root_l = new TreeNode(1);
		TreeNode root_r = new TreeNode(6);
		root.left = root_l;
		root.right = root_r;

		TreeNode root_ll = new TreeNode(3);
		root_l.left = root_ll;
		TreeNode root_lr = new TreeNode(4);
		root_l.right = root_lr;
		TreeNode root_rr = new TreeNode(7);
		root_r.right = root_rr;
		TreeNode root_ll_l = new TreeNode(5);
		root_ll.left = root_ll_l ;

		List<TreeNode> result = getNodesAtKthDistanceFromStart(root, root_l, 2);

		for (TreeNode res : result) {
			System.out.println(res.val);
		}
	}

	private static List<TreeNode> getNodesAtKthDistanceFromStart(TreeNode root, TreeNode start, int k) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		HashMap<TreeNode, TreeNode> map = new HashMap<>();
		populateNodeToParentMap(map, root, null);
		HashSet<TreeNode> explored = new HashSet<TreeNode>();
		explored.add(start);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(start);

		int currentLayer = 0;
		while (!queue.isEmpty()) {
			if (currentLayer == k) {
				for (TreeNode n : queue) {
					result.add(n);
				}
				return result;
			}

			int layerSize = queue.size();
			for (int i = 0; i < layerSize; i++) {
				TreeNode curr = queue.poll();

				if (curr.left != null && !explored.contains(curr.left)) {
					explored.add(curr.left);
					queue.offer(curr.left);
				}

				if (curr.right != null && !explored.contains(curr.right)) {
					explored.add(curr.right);
					queue.offer(curr.right);
				}

				if (map.get(curr) != null && !explored.contains(map.get(curr))) {
					explored.add(map.get(curr));
					queue.offer(map.get(curr));
				}
			}
			currentLayer++;
		}
		return result;
	}

	private static void populateNodeToParentMap(HashMap<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
		if (root == null) {
			return;
		}
		map.put(root, parent);
		populateNodeToParentMap(map, root.left, root);
		populateNodeToParentMap(map, root.right, root);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
