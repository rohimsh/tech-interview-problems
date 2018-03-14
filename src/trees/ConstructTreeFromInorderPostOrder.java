package trees;

import models.TreeNode;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 */
public class ConstructTreeFromInorderPostOrder {

	static int postIndex = 0;

	public static void main(String[] args) {

		   int in[] = {4, 2, 5, 1, 3, 6};
		   int post[] =  {1, 2, 4, 5, 3, 6};
		   int len = in.length;
		   postIndex = len - 1;

		   TreeNode root = constructTree(in, post, 0, len - 1);
		   TraverseInorderRecursive.inOrder(root);
		   System.out.println();
		   TraversePostorderRecursive.postOrder(root);
	}
	

	private static TreeNode constructTree(int[] in, int[] post, int start, int end) {
		if(start > end)
			return null;
		
		TreeNode newTreeNode = new TreeNode(post[postIndex--]);
		
		if(start == end)
			return newTreeNode;
		
		int inIndex = Util.findIndexOfElement(in, newTreeNode.val, start, end);
		
		newTreeNode.left = constructTree(in, post, start, inIndex - 1);
		newTreeNode.right = constructTree(in, post, inIndex + 1, end);
		
		return newTreeNode;
	}
	
}
