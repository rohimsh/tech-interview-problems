package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 *
 */
public class SizeOfTree {

	 public static void main(String[] args) 
	    {
	        TreeNode root;
	  
	        root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	  
	        System.out.println("Size of tree is : " + getSize(root));
	    }

	private static int getSize(TreeNode root) {
		if(root == null)
			return 0;
		
		return getSize(root.left) + getSize(root.right) + 1;
	}
}
