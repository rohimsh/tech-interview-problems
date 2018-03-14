package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import models.TreeNode;

public class TraverseLevelorderInReverseOrder {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);

        levelOrderInReverseOrder(root);
        System.out.println();

	}


	private static void levelOrderInReverseOrder(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			stack.push(tmp);
			
			if(tmp.right != null)
				queue.add(tmp.right);
			if(tmp.left != null)
				queue.add(tmp.left);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().val + " ");
		}
	}
}
