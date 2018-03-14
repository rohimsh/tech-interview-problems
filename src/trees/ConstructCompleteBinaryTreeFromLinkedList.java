package trees;

import java.util.LinkedList;
import java.util.Queue;
import models.ListNode;
import models.TreeNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 */
public class ConstructCompleteBinaryTreeFromLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		TreeNode root = convertListToTree(head);
		TraverseInorderRecursive.inOrder(root);
		 
	}

	private static TreeNode convertListToTree(ListNode head) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(head.val);
		queue.add(root);
		head = head.next;
		while(head != null && !queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			
			if(head != null) {
				tmp.left = new TreeNode(head.val);
				queue.add(tmp.left);
				head = head.next;
			}
			if(head != null) {
				tmp.right = new TreeNode(head.val);
				queue.add(tmp.right);
				head = head.next;
			}
		}
		
		return root;
	}
}
