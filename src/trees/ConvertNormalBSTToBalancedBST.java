package trees;

import java.util.Arrays;

import models.TreeNode;

public class ConvertNormalBSTToBalancedBST {
	
	public static void main(String[] args) {
		
		TreeNode root;
        root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(5);
  
        TreeNode balancedRoot = convertToBalancedBST(root);
        TraversePreorderRecursive.preOrder(balancedRoot);
        
	}

	private static TreeNode convertToBalancedBST(TreeNode root) {
		
		Object[] inOrder = TraverseInorderRecursive.getInOrderInArray(root);
		System.out.println(Arrays.toString(inOrder));
		//TreeNode balancedRoot = Util.createBinaryTreeFromArray(inOrder, 0, inOrder.length);
		TreeNode balancedRoot = createBalancedTreeFromSortedArray(inOrder, 0, inOrder.length - 1);

		return balancedRoot;
		
	}

	private static TreeNode createBalancedTreeFromSortedArray(Object[] sortedArr, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode((int) sortedArr[mid]);
		try {
			root.left = createBalancedTreeFromSortedArray(sortedArr, start, mid - 1);
			root.right = createBalancedTreeFromSortedArray(sortedArr, mid + 1, end);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return root;
	}
}
