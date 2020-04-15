package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;
import tech.interview.problems.utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 *
 */
public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
  	ListNode head, root;
        
        /* Constructed Linked List is 1->4->5->6->8->10->13->14->null */
    	head = new ListNode(1);
    	head.next = new ListNode(4);
    	head.next.next = new ListNode(5);
    	head.next.next.next = new ListNode(6);
    	head.next.next.next.next = new ListNode(8);
    	head.next.next.next.next.next = new ListNode(10);
    	head.next.next.next.next.next.next = new ListNode(13);
    	head.next.next.next.next.next.next.next = new ListNode(14);
    	
        /* Constructed Linked List is 2->4->8->10->11->14->null */
    	root = new ListNode(2);
    	root.next = new ListNode(4);
    	root.next.next = new ListNode(8);
    	root.next.next.next = new ListNode(10);
    	root.next.next.next.next = new ListNode(11);
    	root.next.next.next.next.next = new ListNode(14);
    	
    	ListNode intersectionListHead = getIntersectionOfLists(head, root);
    	Util.printLinkedList(intersectionListHead);
    	
	}

	private static ListNode getIntersectionOfLists(ListNode head, ListNode root) {
		if(head == null && root == null)
			return null;
		if(head == null)
			return root;
		if(root == null)
			return head;
		
		ListNode newHeadNode = null, newCurrentNode = null;
		
		while(head != null && root != null) {
			if(head.val < root.val)
				head = head.next;
			else if(head.val == root.val) {
				ListNode newNode = new ListNode(head.val);
				if(newHeadNode == null) {
					newHeadNode = newNode;
					newCurrentNode = newNode;
				}
				else {
					newCurrentNode.next = newNode;
					newCurrentNode = newNode;
				}
				head = head.next;
				root = root.next;
			}
			else
				root = root.next;
		} 
		
		return newHeadNode;
	}
}
