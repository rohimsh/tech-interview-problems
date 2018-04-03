package trees;

import models.TreeNode;

public class TraverseInorderMorris {
	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);
        
        morrisInOrder(root);
        System.out.println();
        TraverseInorderRecursive.inOrder(root);
	}

	private static void morrisInOrder(TreeNode root) {
		if(root == null)
			return;
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
			} else {
				TreeNode predecessor = curr.left;
				while(predecessor.right != null && predecessor.right != curr)
					predecessor = predecessor.right; 
				
				if(predecessor.right != null) {
					predecessor.right = null;
					System.out.print(curr.val + " ");
					curr = curr.right;
				} else {
					predecessor.right = curr;
					curr = curr.left;
				}
			}
		}
	}
}
