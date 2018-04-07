package linkedlist;

import models.ListNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 */
public class FindMiddleOfLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(1);
    	head.next = new ListNode(2);
//    	head.next.next = new ListNode(3);
//    	head.next.next.next = new ListNode(4);
//    	head.next.next.next.next = new ListNode(5);
//    	head.next.next.next.next.next = new ListNode(6);
//    	head.next.next.next.next.next.next = new ListNode(7);
//    	head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode midNode = findMiddleOfList(head);
        System.out.println(midNode.val);
	}

	public static ListNode findMiddleOfList(ListNode head) {
		if(head == null || head.next == null)
			return null;
		
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			if(fast != null)
				slow = slow.next;
				
		}
		
		return slow;
	}
}
