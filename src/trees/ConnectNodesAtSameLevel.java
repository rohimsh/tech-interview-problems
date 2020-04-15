package trees;

import java.util.LinkedList;
import java.util.Queue;

import models.TreeLinkNode;

public class ConnectNodesAtSameLevel {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);
		root.left.right.left = new TreeLinkNode(7);
		root.right.right.left = new TreeLinkNode(8);

//		linkedNodesOnSameLevel(root);
		connectAdjacentNodes(root);
		printNodesOnSameLevel(root);
	}

	private static void connectAdjacentNodes(TreeLinkNode root) {
		if(root == null)
			return;
		root.next = null;
		connectAdjacentNodesUtil(root);
	}

	
	
	private static void connectAdjacentNodesUtil(TreeLinkNode root) {
		if(root == null)
			return;

		connectAdjacentNodesUtil(root.next);

		if(root.left != null) {
			if(root.right != null){
				root.left.next = root.right;
			}
			else
				root.left.next = getNextElement(root);
		}
		
		if(root.right != null) {
			root.right.next = getNextElement(root);
		}
		
		connectAdjacentNodesUtil(root.left);
		connectAdjacentNodesUtil(root.right);
	}

	private static TreeLinkNode getNextElement(TreeLinkNode root) {
		if(root == null)
			return null;
		root = root.next;
		while(root != null) {
			if(root.left != null)
				return root.left;
			if(root.right != null)
				return root.right;
			root = root.next;
		}
		return root;
	}

	//This method only works for complete binary trees
	private static void linkedNodesOnSameLevel(TreeLinkNode root) {
        
        if(root == null)
            return;
        
        TreeLinkNode prev = null;
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
        que.add(root);
        que.add(null);
        
        while(!que.isEmpty()){
            TreeLinkNode node = que.poll();
            if(node == null) {
            	prev = null;
            	que.add(null);
            	if(que.peek() == null)
            		break;
            	continue;
            }
            node.next = prev;
            prev = node;

            if(node.right != null){
                que.add(node.right);
            }
            
            if(node.left != null){
                que.add(node.left);
            }
                        
        }		
	}
	
	
	
	
	public static void printNodesOnSameLevel(TreeLinkNode root) {
       
		if(root == null)
			return;
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();

    	que.add(root);
        while(!que.isEmpty()) {
        	TreeLinkNode tmp = que.poll();
        	System.out.println();
        	while(tmp != null) {
        		System.out.print(tmp.val+ "->");
    			if(que.isEmpty()) {
    	        	if(tmp.left != null)
    	        		que.add(tmp.left);
    	        	else if(tmp.right != null)
    	        		que.add(tmp.right);
    	        	}
    			tmp = tmp.next;
        	}
        }
    }
        

}
