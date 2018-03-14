package linkedlist;

import java.util.HashSet;
import java.util.Set;

import models.ListNode;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */
public class RemoveDuplicatesFromUnSortedLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
    	head = new ListNode(4);
    	head.next = new ListNode(4);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(2);
    	head.next.next.next.next = new ListNode(3);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(8);
    	head.next.next.next.next.next.next.next = new ListNode(8);

    	Util.printLinkedList(head);
    	ListNode modifiedListHead = removeDuplicates(head);
    	Util.printLinkedList(modifiedListHead);
    	
	}

	private static ListNode removeDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode curr = head.next, prev = head;
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.val);
		
		while(curr != null) {
			if(set.contains(curr.val)) {
				prev.next = curr.next;
				curr = prev.next;
			} else {
				set.add(curr.val);
				prev = curr;
				curr = curr.next;
			}
		}
		
		return head;
		
	}
}
