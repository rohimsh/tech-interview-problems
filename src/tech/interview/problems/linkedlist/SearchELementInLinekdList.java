package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;

public class SearchELementInLinekdList {
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
    	

    	ListNode resultIterative = searchElementIteratively(head, 6);
    	ListNode resultRecursive = searchElementRecursively(head, 6);
    	System.out.println(resultIterative == null ? resultIterative : resultIterative.val);
    	System.out.println(resultRecursive == null ? resultRecursive : resultRecursive.val);
    	
	}

	private static ListNode searchElementIteratively(ListNode head, int element) {
		if(head == null)
			return null;
		while(head != null) {
			if(head.val == element)
				return head;
			head = head.next;
		}
		
		return null;
	}

	private static ListNode searchElementRecursively(ListNode head, int element) {
		if(head == null)
			return null;
		if(head.val == element)
			return head;
		return searchElementRecursively(head.next, element);
	}
}
