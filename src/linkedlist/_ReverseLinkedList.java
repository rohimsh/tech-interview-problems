package linkedlist;

import models.ListNode;
import utils.Util;

public class _ReverseLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(7);
    	head.next.next.next.next.next.next.next = new ListNode(8);

        Util.printLinkedList(head);
        ListNode reversedHead = reverseListIteratively(head); 
        Util.printLinkedList(reversedHead);
        ListNode originalHead = reverseListRecursively(reversedHead); 
        Util.printLinkedList(originalHead);
        
        
	}

	public static ListNode reverseListIteratively(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prev = null, curr = head, next = head.next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}

	public static ListNode reverseListRecursively(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode headNext = head.next;
		head.next = null;
		ListNode reversedHead = reverseListRecursively(headNext);
		headNext.next = head;
		
		return reversedHead;
	}
}
