package tech.interview.problems.trees.check;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.trees.HeightOfTree;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 *
 */
public class CheckIfTreeIsHeightBalanced {

	static class Height{
		int height;
	}

	public static void main(String[] args) {
		 
		 TreeNode root;
		  
		 root = new TreeNode(1);
	     root.left = new TreeNode(2);
	     root.right = new TreeNode(3);
	     root.left.left = new TreeNode(4);
	     root.left.right = new TreeNode(5);
	     root.left.left.left = new TreeNode(6);

		 System.out.println("Is tree Height balanced: " + checkIfHeightBalanced(root));
		 System.out.println("Is tree Height balanced: " + isBalancedTree(root, new Height()));
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

	private static boolean isBalancedTree(TreeNode root, Height height){
	 	if(root == null)
	 		return true;
	 	Height leftHeight = new Height();
	 	Height rightHeight = new Height();
		boolean leftBalanced = isBalancedTree(root.left, leftHeight);
		boolean rightBalanced = isBalancedTree(root.right, rightHeight);

		height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

		if(Math.abs(leftHeight.height - rightHeight.height) > 1)
			return false;

		return leftBalanced && rightBalanced;
	}
}
