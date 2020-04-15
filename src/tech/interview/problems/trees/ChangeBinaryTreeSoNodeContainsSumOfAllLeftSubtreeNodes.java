package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.trees.traverse.TraverseInorderRecursive;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/change-a-binary-tree-so-that-every-node-stores-sum-of-all-nodes-in-left-subtree/
 */
public class ChangeBinaryTreeSoNodeContainsSumOfAllLeftSubtreeNodes {

	public static void main(String[] args) {
		
			TreeNode root;
	        root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.left.left.right = new TreeNode(6);
	        
	        TraverseInorderRecursive.inOrder(root);
	        convert(root);
	        System.out.println();
	        TraverseInorderRecursive.inOrder(root);
	        
	}

	private static int convert(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftSum = convert(root.left);
		int rightSum = convert(root.right);
		
		root.val += leftSum;
		
		return root.val + rightSum;
	}
}
