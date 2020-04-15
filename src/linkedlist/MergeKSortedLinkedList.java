package linkedlist;

import models.ListNode;
import utils.Util;

/**
 * 
 * @author rohitmishra
 */
public class MergeKSortedLinkedList {


	public ListNode mergeKLists(ListNode[] lists) {
		int interval = 1;
		while(interval < lists.length){
			for(int i = 0; i < lists.length - interval; i += interval * 2){
				lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
			}
			interval *= 2;
		}
		return lists.length > 0 ? lists[0] : null;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
