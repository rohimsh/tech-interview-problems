package linkedlist;

import models.ListNode;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 */
public class PairwiseSwapElements {
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
//    	head.next.next.next.next.next.next.next = new ListNode(8);

    	Util.printLinkedList(head);
    	ListNode modifiedHeadRecursive = pairWiseSwapRecursively(head);
    	Util.printLinkedList(modifiedHeadRecursive);
    	ListNode modifiedHeadIterative = pairWiseSwapIteratively(modifiedHeadRecursive);
    	Util.printLinkedList(modifiedHeadIterative);   	
    	
	}

	private static ListNode pairWiseSwapIteratively(ListNode head) {
		if(head == null)
			return null;
		ListNode prevNode = null, nextNode = null, newHead = null;
		
		while(head != null && head.next != null) {
			nextNode = head.next;
			head.next = nextNode.next;
			nextNode.next = head;
			if(newHead == null) {
				newHead = nextNode;
			} else {
				prevNode.next = nextNode;
			}
			
			prevNode = head;
			head = head.next;
		}
		
		return newHead;
	}

	private static ListNode pairWiseSwapRecursively(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode curr = head, next = head.next;
		
		if(curr != null && curr.next != null) {
			curr.next = pairWiseSwapRecursively(next.next);
			next.next = curr;
		}
		
		return next;
	}
}
