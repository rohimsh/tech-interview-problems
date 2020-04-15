package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 *
 */
public class DiameterOfTree {
	 public static void main(String[] args) 
	    {
	        TreeNode root;
	  
	        root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	  
	        System.out.println("Diameter of tree is : " + getDiameter(root));
	    }

	private static int getDiameter(TreeNode root) {
		
		if(root == null)
			return 0;
			
		
		int lHeight = HeightOfTree.getHeight(root.left);
		int rHeight = HeightOfTree.getHeight(root.right);
		
		int throughRoot = lHeight + rHeight + 1;
		
		int lDiamater = getDiameter(root.left);
		int rDiameter = getDiameter(root.right);
		
		int notThroughRoot = Math.max(lDiamater, rDiameter);
		
		
		return Math.max(throughRoot, notThroughRoot);
	}
}
