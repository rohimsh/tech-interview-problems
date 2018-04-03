package linkedlist;

import models.ListNode;

public class PrintReverseOfListRecursively {
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
			
			printReverseOfList(head);
			
		}

		private static void printReverseOfList(ListNode head) {
			if(head == null)
				return;
			printReverseOfList(head.next);
			System.out.println(head.val);
		}
}
