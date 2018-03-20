package trees;

import models.TreeNode;

public class BoundaryTraversalOfTree {
	public static void main(String[] args) {
		TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.left = new TreeNode(10);
        printBoundaryOfTree(root);
        
	}

	private static void printBoundaryOfTree(TreeNode root) {
		if(root == null)
			return;
		printLeftBoundary(root);
		printLeafs(root);
		printRightBoundary(root.right);
	}

	private static void printRightBoundary(TreeNode root) {
		if(root != null && root.right != null) {
			printRightBoundary(root.right);
			if(root.left != null || root.right != null)
				System.out.print(" " + root.val);
		}
	}

	private static void printLeafs(TreeNode root) {
		if(root == null)
			return;
		if(root != null && root.left == null && root.right == null) {
			System.out.print(" " + root.val);
		}
		
		printLeafs(root.left);
		printLeafs(root.right);
	}

	private static void printLeftBoundary(TreeNode root) {
		while(root.left != null) {
			System.out.print(" " + root.val);
			root = root.left;
		}
	}

}
