package tech.interview.problems.trees.construct;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.trees.traverse.TraverseInorderRecursive;
import tech.interview.problems.trees.traverse.TraverseLevelorderIterative;
import tech.interview.problems.utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 */
public class ConstructTreeFromInorderLevelOrder {

	public static void main(String[] args) {

		   int in[] = {4, 8, 10, 12, 14, 20, 22};
		   int level[] = {20, 8, 22, 4, 12, 10, 14};
		   int len = in.length;

		   TreeNode root = constructTree(in, level, 0, len - 1);
		   TraverseInorderRecursive.inOrder(root);
		   System.out.println();
		   TraverseLevelorderIterative.levelOrder(root);
	}
	

	private static TreeNode constructTree(int[] in, int[] level, int start, int end) {
		if(start > end)
			return null;

		TreeNode newTreeNode = new TreeNode(level[0]);
		
		int inIndex = Util.findIndexOfElement(in, newTreeNode.val, start, end);

		
		int[] left = extractArray(in, level, start, inIndex - 1);
		int[] right = extractArray(in, level, inIndex + 1, end);
		
		newTreeNode.left = constructTree(in, left, start, inIndex - 1);
		newTreeNode.right = constructTree(in, right, inIndex + 1, end);
		
		return newTreeNode;
	}


	private static int[] extractArray(int[] in, int[] level, int start, int end) {
		int[] result = new int[end - start + 1];
		int nextIndex = 0;
		for(int i = 1; i < level.length; i++) {
			int searchIndex = Util.findIndexOfElement(in, level[i], start, end);
			if(searchIndex != -1) {
				result[nextIndex++] = in[searchIndex];
			}
		}
		return result;
	}
	
}
