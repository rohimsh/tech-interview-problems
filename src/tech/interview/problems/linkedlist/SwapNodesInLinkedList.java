package tech.interview.problems.linkedlist;

import tech.interview.problems.models.ListNode;
import tech.interview.problems.utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 */
public class SwapNodesInLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(4);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(1);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(7);
    	head.next.next.next.next.next.next.next = new ListNode(8);

    	int x = 4;
    	int y = 1;
    	
    	Util.printLinkedList(head);
    	ListNode headSwapped = swapNodes(head, x, y);
    	System.out.println();
    	Util.printLinkedList(headSwapped);
    	
	}

	private static ListNode swapNodes(ListNode head, int x, int y) {
		if(head == null || x == y)
			return head;
		ListNode xPrev = null, xNode = null, yNode = null, yPrev = null, prev = null, tmp = head;
		
		while(tmp != null) {
			if(tmp.val == x) {
				xNode = tmp;
				xPrev = prev;
			} 
			if(tmp.val == y) {
				yNode = tmp;
				yPrev = prev;
			}
			
			if(xNode != null && yNode != null) {
				if(yPrev != null) {
					ListNode xNext = xNode.next;
					yPrev.next = xNode;
					xNode.next = yNode.next;
					yNode.next = xNext;
					
					if(head == xNode) {
						head = yNode;
					}					
				} else if(xPrev != null) {
					ListNode yNext = yNode.next;
					xPrev.next = yNode;
					yNode.next = xNode.next;
					xNode.next = yNext;
					
					if(head == yNode) {
						head = xNode;
					}					
				}
				

				break;
			}
				
			prev = tmp;
			tmp = tmp.next;
		}
		
		return head;
	}
}
