package tech.interview.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 * 
 */
public class PopulateLevelOrderSuccessor {

	static class Node 
	{
	    int data;
	    Node left, right, nextRight;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = nextRight = null;
	    }
	}
	
	static Node lastNode;
	
	public static void main(String[] args) {
		Node root;
	  	  
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.right = new Node(36);
        
        populateNextRightOnLevel(root);
        
        printNodesFromLevelOrderBasedOnNextRight(root);
	}

	private static void populateNextRightOnLevel(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> order = new LinkedList<Node>();
		queue.add(root);
		order.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll(); 
			while(!order.isEmpty()) {
				System.out.println();
				order.poll().nextRight = order.peek();
			}
				
			if(node.left != null) {
				queue.add(node.left);
				order.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
				order.add(node.right);
			}
		}
	}
	
	private static void printNodesFromLevelOrderBasedOnNextRight(Node root) {
		if(root == null)
			return;
				
		while(root != null) {
			Node tmp = root;
			while(tmp != null) {
				System.out.print(tmp.data + " ");
				tmp = tmp.nextRight;
			}
			System.out.println();
			root = root.left;
		}
	}
}
