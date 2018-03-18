package linkedlist;

import models.ListNode;
import utils.Util;

public class RearrangeOddPositionedNodesBeforeEvenPositionsNodes {
	public static void main(String[] args) {
		ListNode head;
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		//Even length list
		rearrangeList(head);
		Util.printLinkedList(head);
		
		//Odd length List
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		rearrangeList(head);
		Util.printLinkedList(head);

	}

	private static void rearrangeList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return;
		ListNode tmp = head, curr = head.next, evenHead = head.next, oddHead = head, lastOddNode = null;
		
		//find the last even node
		while(curr != null && curr.next != null && curr.next.next != null) {
			curr = curr.next.next;
		}
		evenHead = curr;
		lastOddNode = evenHead.next;
		evenHead.next = null;
		
		boolean isOdd = false;
		curr = head;
		while(oddHead != null && oddHead.next != null && oddHead.next != evenHead) {
			if(isOdd) {
				tmp = oddHead.next;
				oddHead.next = tmp.next;
				tmp.next = evenHead.next;
				evenHead.next = tmp;
				oddHead = oddHead.next;
			} else {
				tmp = oddHead.next;
				oddHead.next = oddHead.next.next;
				oddHead = oddHead.next;
				tmp.next = evenHead.next;
				evenHead.next = tmp;
			}
			isOdd = !isOdd;
		}
		
		if(lastOddNode != null) {
			oddHead.next = lastOddNode;
			lastOddNode.next = evenHead;
		}
		
	}
}
