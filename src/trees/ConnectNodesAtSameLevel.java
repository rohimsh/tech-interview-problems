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
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		
		linkedNodesOnSameLevel(root);
		printNodesOnSameLevel(root);
	}

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
        	TreeLinkNode tmp = root;
            while(tmp != null) {
            	System.out.print(tmp.val + "->");
            	tmp = tmp.next;
            }
            System.out.println();
    		printNodesOnSameLevel(root.left);
    }
        

}
