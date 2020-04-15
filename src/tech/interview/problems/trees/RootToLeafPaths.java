package tech.interview.problems.trees;

import tech.interview.problems.models.TreeNode;
import tech.interview.problems.utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 */
public class RootToLeafPaths {

	public static void main(String[] args) {
        TreeNode root;
  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        
        printAllRootToLeafPaths(root);
        
	}

	private static void printAllRootToLeafPaths(TreeNode root) {
		int height = HeightOfTree.getHeight(root);
		int arr[] = new int[height];
		printRootToLeafPath(root, arr, 0);		
	}

	private static void printRootToLeafPath(TreeNode root, int[] arr, int len) {
		
		if(root == null)
			return;
		
		arr[len] = root.val;

		if(root.left == null && root.right == null) {
			Util.printArray(arr, 0, len);
			System.out.println();
			return;
		}
		
		printRootToLeafPath(root.left, arr, len + 1);
		printRootToLeafPath(root.right, arr, len + 1);
		
	}
	
	
	
	
}
