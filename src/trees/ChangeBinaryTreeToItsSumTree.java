package trees;

import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 */
public class ChangeBinaryTreeToItsSumTree {

	public static void main(String[] args) {
		TreeNode root;
        root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        
        TraverseInorderRecursive.inOrder(root);
        convertToSumTree(root);
        System.out.println();
        TraverseInorderRecursive.inOrder(root);
        
	}

	private static int convertToSumTree(TreeNode root) {
		if(root == null)
			return 0;
		
		int value = root.val;
		
		int leftSum = convertToSumTree(root.left);
		int rightSum = convertToSumTree(root.right);
		
		root.val = leftSum + rightSum;
		
		return value + root.val;
	}
	
	
}
