package trees;

import java.util.Stack;

import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see 
 * https://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
 */
public class TraversePostorderIterative {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);
        
        postOrderWithoutModifyingTree(root);
        System.out.println();
        postOrderWithoutModifyingTreeWithTwoStacks(root);
        System.out.println();
        postOrderThatModifiesTree(root);

	}
	

	private static void postOrderWithoutModifyingTreeWithTwoStacks(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			TreeNode tmp = stack1.pop();
			stack2.push(tmp);
			
			if(tmp.left != null) {
				stack1.push(tmp.left);
			}
			if(tmp.right != null) {
				stack1.push(tmp.right);
			}
		}

		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().val + " ");
		}
		
	}


	private static void postOrderWithoutModifyingTree(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.peek();
			
			if(prev == null || prev.left == tmp || prev.right == tmp) {
				if(tmp.left != null) {
					stack.push(tmp.left);
				} else if(tmp.right != null) {
					stack.push(tmp.right);
				} else {
					System.out.print(stack.pop().val + " ");
				}
			} else if(tmp.left == prev) {
				if(tmp.right !=  null) {
					stack.push(tmp.right);
				} else {
					System.out.print(stack.pop().val + " ");
				}
			} else if(tmp.right == prev) {
				System.out.print(stack.pop().val + " ");
			}
			
			prev = tmp;
		}
	}


	private static void postOrderThatModifiesTree(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.peek();
			
			if(tmp.left == null && tmp.right == null) {
				System.out.print(stack.pop().val + " ");
			} else if(tmp.left == null) {
				stack.push(tmp.right);
				tmp.right = null;
			} else {
				stack.push(tmp.left);
				tmp.left = null;				
			}
		}
	}
	
	
}
