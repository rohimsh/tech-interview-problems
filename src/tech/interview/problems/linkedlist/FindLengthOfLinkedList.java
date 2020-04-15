package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
 */
public class FindLengthOfLinkedList {
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

        
        System.out.println(countNumberOfNodesIteratively(head));
        System.out.println(countNumberOfNodesRecursively(head));
	}

	public static int countNumberOfNodesRecursively(ListNode head) {
		if(head == null)
			return 0;
		return countNumberOfNodesRecursively(head.next) + 1;
	}

	public static int countNumberOfNodesIteratively(ListNode head) {
		int count = 0;
		while(head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
}
