package trees;

import models.DLLNode;
import models.TreeNode;
import utils.Util;

/**
 * 
 * @author rohitmishra
 * @see 
 * https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 * 
 */
public class ConvertTreeToDoublyLinkedList {
	
	public static void main(String[] args) {
		
        TreeNode root;
    	  
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(0);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        
        treeToDLLUsingStaticVariable(root);
        Util.printLinkedList(headNodeStatic);
        
	}


	static DLLNode lastNode, headNodeStatic;
	
	private static void treeToDLLUsingStaticVariable(TreeNode root) {
		if(root == null)
			return;
		
		DLLNode newNode = new DLLNode(root.val);
		treeToDLLUsingStaticVariable(root.left);
		if(lastNode != null)
			lastNode.next = newNode;
		if(headNodeStatic == null)
			headNodeStatic = newNode;
		newNode.prev = lastNode;
		lastNode = newNode;
		treeToDLLUsingStaticVariable(root.right);

	}

}
