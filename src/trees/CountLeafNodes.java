package trees;

import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */
public class CountLeafNodes {
	/* Driver program to test above functions */
    public static void main(String args[]) 
    {
        /* create a tree */
        TreeNode root;
  	  
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
  
        /* get leaf count of the above tree */
        System.out.println("The leaf count of binary tree is : " + getLeafCount(root));
    }

	private static int getLeafCount(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return getLeafCount(root.left) + getLeafCount(root.right);
		
	}
}
