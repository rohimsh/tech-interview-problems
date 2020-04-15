package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 *
 */
public class HeightOfTree {

	 public static void main(String[] args) 
	    {
	        TreeNode root;
	  
	        root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	  
	        System.out.println("Height of tree is : " + getHeight(root));
	    }

	public static int getHeight(TreeNode root) {
		if(root == null)
			return 0;
		
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		
		return Math.max(lHeight, rHeight) + 1;
	}
	 
	 
}
