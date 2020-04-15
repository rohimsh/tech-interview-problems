package tech.interview.problems.trees.check;

import tech.interview.problems.models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-tech.interview.problems.trees-are-identical/
 */
public class CheckIfTreesAreIdentical {
	
	 public static void main(String[] args) {
		 
		 TreeNode root1, root2;
		  
	     root1 = new TreeNode(1);
	     root1.left = new TreeNode(2);
	     root1.right = new TreeNode(3);
	     root1.left.left = new TreeNode(4);
	     root1.left.right = new TreeNode(5);
	
	     
	     root2 = new TreeNode(1);
	     root2.left = new TreeNode(2);
	     root2.right = new TreeNode(3);
	     root2.left.left = new TreeNode(4);
	     root2.left.right = new TreeNode(5);
	
	     System.out.println("Height of tree is : " + checkIfIdentical(root1, root2));
	}

	private static boolean checkIfIdentical(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return root1.val == root2.val && checkIfIdentical(root1.left, root2.left) && checkIfIdentical(root1.right, root2.right);		
	}

}
