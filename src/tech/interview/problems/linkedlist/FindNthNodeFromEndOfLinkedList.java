package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;

public class FindNthNodeFromEndOfLinkedList {
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
    	
    	int n = 9;
    	ListNode node = findNthNodeFromEnd(head, n);
    	System.out.println(node != null ? node.val : -1);

	}

	private static ListNode findNthNodeFromEnd(ListNode head, int n) {
		if(head == null)
			return head;
		
		int count = n;
		ListNode slow = head, fast = head;
		while(count-- > 0 && fast != null) {
			fast = fast.next;
		}
		
		if(fast == null) {
			System.out.println("Position does not exist");
			return null;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}
}
