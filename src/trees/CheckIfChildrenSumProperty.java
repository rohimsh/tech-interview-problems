package trees;

import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 *
 */
public class CheckIfChildrenSumProperty {
	 public static void main(String[] args) 
	    {
	        TreeNode root;
	  
	        root = new TreeNode(10);
	        root.left = new TreeNode(8);
	        root.right = new TreeNode(2);
	        root.left.left = new TreeNode(3);
	        root.left.right = new TreeNode(5);
	        root.right.left = new TreeNode(2);
	        //root.right.right = new TreeNode(1);
	  
	        System.out.println("Follows children sum property of tree is : " + followsChildrenSumProperty(root));
	    }

	private static boolean followsChildrenSumProperty(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return true;
		
		int left = root.left != null ? root.left.val : 0;
		int right = root.right != null ? root.right.val : 0;
		
		if(left + right != root.val)
			return false;
		
		return followsChildrenSumProperty(root.left) && followsChildrenSumProperty(root.right);
	}
}
