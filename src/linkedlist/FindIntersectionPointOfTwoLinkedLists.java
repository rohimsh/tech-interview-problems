package linkedlist;

import models.ListNode;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 */
public class FindIntersectionPointOfTwoLinkedLists {
	public static void main(String[] args) {
    	ListNode head, root;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(7);
    	head.next.next.next.next.next.next.next = new ListNode(8);

        
    	root = new ListNode(2);
    	root.next = new ListNode(3);
    	root.next.next = head.next.next.next.next.next.next;
    	root.next.next.next = head.next.next.next.next.next.next.next;

    	
        System.out.println(findIntersectioNodeOfTwoLists(head, root).val);
	}

	private static ListNode findIntersectioNodeOfTwoLists(ListNode head, ListNode root) {
		if(head == null || root == null)
			return null;
		
		int len1 = FindLengthOfLinkedList.countNumberOfNodesRecursively(head);
		int len2 = FindLengthOfLinkedList.countNumberOfNodesRecursively(root);
		
		
		ListNode slow, fast;
		if(len1 < len2) {
			slow = head;
			fast = root;
		}
		else {
			slow = root;
			fast = head;
		}
		
		int diff = len1 - len2;
		
		while(diff-- > 0) {
			fast = fast.next;
		}
		
		while(fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}


}
