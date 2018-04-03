package linkedlist;

import models.ListNode;
import utils.Util;

public class _MergeTwoSortedLinkedLists {
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
    	
        /* Constructed Linked List is 2->3->7->9->11->12->null */
    	root = new ListNode(2);
    	root.next = new ListNode(3);
    	root.next.next = new ListNode(7);
    	root.next.next.next = new ListNode(9);
    	root.next.next.next.next = new ListNode(11);
    	root.next.next.next.next.next = new ListNode(12);

    	ListNode mergedHead = mergeSortedLinkedLists(head, root);
    	Util.printLinkedList(mergedHead);
    	
	}

	public static ListNode mergeSortedLinkedLists(ListNode head, ListNode root) {
		if(head == null && root == null)
			return null;
		if(head == null)
			return root;
		if(root == null)
			return head;
		
		if(head.val < root.val) {
			head.next = mergeSortedLinkedLists(head.next, root);
			return head;
		} else {
			root.next = mergeSortedLinkedLists(head, root.next);	
			return root;
		}
	}
}
