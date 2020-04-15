package tech.interview.problems.trees.convert;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.trees.traverse.TraverseLevelorderIterative;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 *
 */
public class ConvertBinaryTreeToItsMirrorTree {
	
	public static void main(String[] args) {
		TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        
        TraverseLevelorderIterative.levelOrderPrintOnDifferentLevelsWithTwoQueues(root);
        convertToMirror(root);
        System.out.println();
        TraverseLevelorderIterative.levelOrderPrintOnDifferentLevelsWithSingleQueue(root);
	}

	private static TreeNode convertToMirror(TreeNode root) {
		if(root == null)
			return root;
		
		TreeNode right = convertToMirror(root.right);
		TreeNode left = convertToMirror(root.left);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
}
