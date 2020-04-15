package tech.interview.problems.trees.traverse;

import java.util.Stack;

import tech.interview.problems.models.TreeNode;

public class TraversePreorderIterative {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);

        preOrder(root);
	}

	private static void preOrder(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tmp = root;
		while(true) {
			while(tmp != null) {
				System.out.print(tmp.val + " ");
				stack.push(tmp);
				tmp = tmp.left;
			}

			if(!stack.isEmpty()) {
				TreeNode parent = stack.pop();
				if(parent.right != null)
					tmp = parent.right;				
			}
			else 
				break;

		}
	}
}
