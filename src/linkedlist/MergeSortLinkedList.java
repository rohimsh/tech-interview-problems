package linkedlist;

import models.ListNode;
import utils.Util;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class MergeSortLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
    	head = new ListNode(5);
    	head.next = new ListNode(6);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(2);
    	head.next.next.next.next = new ListNode(1);
    	head.next.next.next.next.next = new ListNode(4);
    	head.next.next.next.next.next.next = new ListNode(8);
    	head.next.next.next.next.next.next.next = new ListNode(7);
    	
    	Util.printLinkedList(head);
    	ListNode mergedHead = mergeSortForLinkedList(head);
    	Util.printLinkedList(mergedHead);
		
	}

	private static ListNode mergeSortForLinkedList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		Util.printLinkedList(head);
		ListNode midNode = FindMiddleOfLinkedList.findMiddleOfList(head);
		ListNode nextToMidNode = midNode.next;
		midNode.next = null;
		
		ListNode start = mergeSortForLinkedList(head);
		ListNode mid = mergeSortForLinkedList(nextToMidNode);
		
		return merge(start, mid);
	}

	private static ListNode merge(ListNode head, ListNode root) {
		return _MergeTwoSortedLinkedLists.mergeSortedLinkedLists(head, root);
	}
}
