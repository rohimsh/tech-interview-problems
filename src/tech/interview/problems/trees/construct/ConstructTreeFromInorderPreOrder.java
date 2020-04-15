package tech.interview.problems.trees.construct;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.trees.traverse.TraverseInorderRecursive;
import tech.interview.problems.trees.traverse.TraversePreorderRecursive;
import tech.interview.problems.utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 * @see
 * Time Complexity: O(n^2). Worst case occurs when tree is left skewed. 
 * Example Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B, A}
 */
public class ConstructTreeFromInorderPreOrder {

	static int preIndex = 0;

	public static void main(String[] args) {

		   int in[] = {4, 2, 5, 1, 3, 6};
		   int pre[] =  {1, 2, 4, 5, 3, 6};
		   int len = in.length;

		   TreeNode root = constructTree(in, pre, 0, len - 1);
		   TraverseInorderRecursive.inOrder(root);
		   System.out.println();
		   TraversePreorderRecursive.preOrder(root);
	}
	

	private static TreeNode constructTree(int[] in, int[] pre, int start, int end) {
		if(start > end)
			return null;
		
		TreeNode newTreeNode = new TreeNode(pre[preIndex++]);
		
		if(start == end)
			return newTreeNode;
		
		int inIndex = Util.findIndexOfElement(in, newTreeNode.val, start, end);
		
		newTreeNode.left = constructTree(in, pre, start, inIndex - 1);
		newTreeNode.right = constructTree(in, pre, inIndex + 1, end);
		
		return newTreeNode;
	}
	
}
