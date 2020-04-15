package linkedlist;

import models.ListNode;
import utils.Util;

public class _ReverseListInGroupsofkSize {
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
    	head.next.next.next.next.next.next.next.next = new ListNode(9);
    	head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    	head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
    	
    	int K = 3;
    	ListNode reversedHeadHybrid = reverseListInKSize(head, K);
    	Util.printLinkedList(reversedHeadHybrid);
    	ListNode reversedHeadRecursive = reverseListInKSizeRecursively(reversedHeadHybrid, K);
    	Util.printLinkedList(reversedHeadRecursive);
		ListNode reversedHead = reverseRecursively(head, K);
		Util.printLinkedList(reversedHead);
	}

	private static ListNode reverseRecursively(ListNode head, int k){
		if(head == null || head.next == null)
			return head;
		int count = 0;
		ListNode prev = null, curr = head, tmp = curr;
		while(count < k && tmp != null){
			tmp = tmp.next;
			count++;
		}
		if(count < k){
			return head;
		}
		ListNode reverseHead = reverseRecursively(tmp, k);
		count = 0;
		while(count < k){
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		head.next = reverseHead;
		return prev;
	}

	private static ListNode reverseListInKSizeRecursively(ListNode head, int K) {
		ListNode currNode = head;
		ListNode prevNode = null;
		ListNode nextNode = null;
		
		int count = 0; 
		//verify there are K nodes available
		ListNode tmp = currNode;
		while(count < K && tmp != null) {
			tmp = tmp.next;
			count++;
		}
		if(count < K)
			return head;
		
		//verified for availability of K nodes, now reverse
		count = 0;
		while(count < K && currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			count++;
		}
		
		if(nextNode != null)
			head.next = reverseListInKSizeRecursively(nextNode, K);
		
		return prevNode;
	}

	private static ListNode reverseListInKSize(ListNode head, int K) {
        if(head == null || head.next == null)
			return head;
		ListNode newHead = null, prevHead = null, curr = head;

		while(curr != null) {
			int count = 1;
			ListNode startNode = curr;
			for(; count < K && curr != null; count++) {
				curr = curr.next;
			}
			if(count == K && curr != null) {
				ListNode nextHead = curr.next;
				ListNode reversedHead = reverseList(startNode, curr);
				if(newHead == null)
					newHead = reversedHead;
				else
					prevHead.next = reversedHead;
				prevHead = startNode;
				curr = nextHead;
			} else if(prevHead != null) {
				prevHead.next = startNode;
			} else{
                return head;
            }
		}

		return newHead;
	}

	private static ListNode reverseList(ListNode startNode, ListNode curr) {
		if(curr == null && startNode == null)
			return null;
		if(curr == null)
			return startNode;
		if(startNode == null)
			return curr;
		
		if(startNode == curr)
			return curr;
		ListNode nextNode = startNode.next;
		startNode.next = null;
		ListNode reversed = reverseList(nextNode, curr);
		nextNode.next = startNode;
		
		return reversed;
	}

}
