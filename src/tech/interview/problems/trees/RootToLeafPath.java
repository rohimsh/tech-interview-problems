package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 *
 */
public class RootToLeafPath {

	/* Driver program to test the above functions */
    public static void main(String args[]) 
    {
        int sum = 14;
         
        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        TreeNode root;
  	  
        root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
  
  
        if (hasPathSum(root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }

	private static boolean hasPathSum(TreeNode root, int sum) {
		
		if(root == null) {
			if(sum == 0)
				return true;
			else
				return false;
		}
			
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
