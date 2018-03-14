package trees;

import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 *
 */
public class CheckIfTreeIsHeightBalanced {
	
	 public static void main(String[] args) {
		 
		 TreeNode root;
		  
		 root = new TreeNode(1);
	     root.left = new TreeNode(2);
	     root.right = new TreeNode(3);
	     root.left.left = new TreeNode(4);
	     root.left.right = new TreeNode(5);
	     //root.left.left.left = new TreeNode(6);
	
	     System.out.println("Is tree Height balanced: " + checkIfHeightBalanced(root));
	}

	private static boolean checkIfHeightBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int lHeight = HeightOfTree.getHeight(root.left);
		int rHeight = HeightOfTree.getHeight(root.right);
		
		if(Math.abs(lHeight - rHeight) > 1)
			return false;
		
		return checkIfHeightBalanced(root.left) && checkIfHeightBalanced(root.right);
	}
}
