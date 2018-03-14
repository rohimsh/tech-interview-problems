package linkedlist;

import java.util.Stack;

import models.ListNode;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
public class CheckIfLinkedListIsPalindrome {

	public static void main(String[] args) {
		ListNode head;
	    
	    /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next = new ListNode(1);
		
		System.out.println(isListPalindromeUsingStack(head));
		System.out.println(isListPalindromeByReversingFromMid(head));
		Util.printLinkedList(head);

	}

	private static boolean isListPalindromeByReversingFromMid(ListNode head) {
		if(head == null || head.next == null)
			return true;
		
		ListNode slow = head, fast = head, prev = null;
		boolean isPalindrome = false;
		while(fast != null  && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = ReverseLinkedList.reverseListIteratively(slow);
		slow = head;
		fast = prev.next;
		while(slow.val == fast.val && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		if(fast.next == null) {
			isPalindrome = true;
		}
		
		prev.next = ReverseLinkedList.reverseListIteratively(prev.next);
		
		return isPalindrome;
	}

	private static boolean isListPalindromeUsingStack(ListNode head) {
		if(head == null || head.next == null)
			return true;
		Stack<ListNode> stack = new Stack<ListNode>();
		
		ListNode slow = head, fast = head;
		
		while(fast != null  && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop().val != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
