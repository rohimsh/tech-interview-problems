package trees;

import java.util.Stack;

import models.TreeNode;

public class TraverseInorderIterative {

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

	private static void inOrder(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		while(true) {
			while(tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}

			if(!stack.isEmpty()) {
				TreeNode parent = stack.pop();
				System.out.print(parent.val + " ");
				if(parent.right != null)
					tmp = parent.right;				
			}
			else 
				break;

		}
	}
}
