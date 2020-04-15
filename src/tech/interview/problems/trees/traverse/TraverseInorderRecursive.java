package tech.interview.problems.trees.traverse;

import java.util.ArrayList;
import java.util.List;

import tech.interview.problems.models.TreeNode;

public class TraverseInorderRecursive {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);

        inOrder(root);
	}

	public static void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static Object[] getInOrderInArray(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		traverseInOrderAndAddToList(root, list);
		return list.toArray();
	}

	private static void traverseInOrderAndAddToList(TreeNode root, List<Integer> list) {
		if(root == null)
			return;
		traverseInOrderAndAddToList(root.left, list);
		list.add(root.val);
		traverseInOrderAndAddToList(root.right, list);
	}
}
