package linkedlist;

import java.util.Stack;

import models.ListNode;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
public class _CheckIfLinkedListIsPalindrome {

	public static void main(String[] args) {
		ListNode head;
	    
	    /* Constructed Linked List is 1->2->3->4->5->4->3->2->1->null */
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next = new ListNode(1);
		
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
		
		prev.next = _ReverseLinkedList.reverseListIteratively(slow);
		slow = head;
		fast = prev.next;
		while(slow.val == fast.val && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		if(fast.next == null) {
			isPalindrome = true;
		}
		
		prev.next = _ReverseLinkedList.reverseListIteratively(prev.next);
		
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
		
		if(fast != null && fast.next == null)
			slow = slow.next;

			
		while(!stack.isEmpty()) {
			if(stack.pop().val != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
