package trees;

import models.DLLNode;
import models.TreeNode;
import utils.Util;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
 */
public class ConvertTreeToCircularList {

	static DLLNode lastNode, headNode;
	
	public static void main(String[] args) {
		
        TreeNode root;
    	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        
        DLLNode lastNode = treeToCircularDLL(root);
        System.out.println(lastNode.val);
        Util.printCircularLinkedList(headNode);
        
        
	}

	private static DLLNode treeToCircularDLL(TreeNode root) {
		
		if(root == null)
			return null;
		DLLNode node = new DLLNode(root.val);
		treeToCircularDLL(root.left);
		if(headNode == null)
			headNode = node;
		node.prev = lastNode;
		if(lastNode != null)
			lastNode.next = node;
		lastNode = node;
		treeToCircularDLL(root.right);
		
		return node;
	}
	
}
