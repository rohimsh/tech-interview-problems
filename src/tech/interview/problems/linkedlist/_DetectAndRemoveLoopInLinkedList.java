package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;
import tech.interview.problems.utils.Util;

public class _DetectAndRemoveLoopInLinkedList {
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

    	head.next.next.next.next.next.next.next.next = head.next.next.next.next; // create loop from 8 to 5
    	
        ListNode loopRemovedHead = detectAndRemoveLoop(head); 
        Util.printLinkedList(loopRemovedHead);
	}

	private static ListNode detectAndRemoveLoop(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		
		// Detect Loop
		ListNode slow = head, fast = head;

		slow = slow.next;
		fast = fast.next.next;
		
		while(fast != null && fast.next != null) {
			if(slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow == fast) {
			System.out.println("Loop found");
			//Start removing loop
			slow = head;
			while(slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			
			fast.next = null;
		} else {
			System.out.println("No Loop found");			
			return head;
		}

		return head;
	}
}
