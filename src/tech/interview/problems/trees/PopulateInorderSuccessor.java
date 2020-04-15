package tech.interview.problems.trees;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 */
public class PopulateInorderSuccessor {
	
	static class Node 
	{
	    int data;
	    Node left, right, next;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = next = null;
	    }
	}
	
	static Node nextNode;
	public static void main(String[] args) {
		Node root;
  	  
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        
        populateNext(root);
        
        Node tmp = root.left.left;
        while(tmp != null) {
        	System.out.print(tmp.data + " ");
        	tmp = tmp.next;
        }
	}

	private static void populateNext(Node root) {
		if(root == null)
			return;
		
		populateNext(root.right);
		root.next = nextNode;
		nextNode = root;
		populateNext(root.left);
		
	}
}
