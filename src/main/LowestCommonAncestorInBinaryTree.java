package main;


public class LowestCommonAncestorInBinaryTree {
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
		
		
		TreeNode result = lca(root, root_rr,root_rl);
		System.out.println(result.val);
	}
	
	public static TreeNode lca(TreeNode root, TreeNode x, TreeNode y) {
		if(root == null) {
			return null;
		}
		
		if(root.val == x.val || root.val == y.val) {
			return root;
		}
		
		TreeNode leftSearchResult = lca(root.left, x, y);
		TreeNode rightSearchResult = lca(root.right, x, y);
		if(leftSearchResult != null && rightSearchResult !=  null) {
			return root;
		}if(leftSearchResult == null) return rightSearchResult;
		
		return leftSearchResult;
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
