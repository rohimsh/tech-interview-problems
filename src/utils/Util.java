package utils;

import models.DLLNode;
import models.ListNode;
import models.TreeNode;

public class Util {
	
	public static int gcd(int a, int b) {
		if(b == 0) 
			return a;
		return gcd(b, a % b);
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		
		while(start <= end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start ++;
			end --;
		}
		
	}
	
	public static int binarySearch(int[] arr, int start, int end, int key) {
		
		int index = -1;
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] > arr[start]) {
				start = mid;
			} else {
				end = mid;
			}	
		}
		return index;
	}

	public static void swap(int[] arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

	public static void printCircularLinkedList(DLLNode circularDoublyLinkedList) {

		if(circularDoublyLinkedList == null)
			return;
		DLLNode tmp = circularDoublyLinkedList;
		
		while(circularDoublyLinkedList.prev != tmp) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
        System.out.println();
	}

	public static void printLinkedList(DLLNode headNode) {
		
		while(headNode != null) {
			System.out.print(headNode.val + " ");
			headNode = headNode.next;
		}
        System.out.println();
		
	}
	
	public static void printArray(int[] arr, int start, int end) {
		for(int i = start; i <= end; i++)
			System.out.print(arr[i] + " ");
	}
	
	
	public static int findIndexOfElement(int arr[], int element, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(arr[i] == element)
				return i;
		}
		
		return -1;
	}

	public static TreeNode createBinaryTreeFromArray(Object[] arr, int index, int len) {
		if(index >= len)
			return null;
		TreeNode root = new TreeNode((int) arr[index]);
		int left = 2*index + 1;
		int right = 2*index + 2;
		root.left = createBinaryTreeFromArray(arr, left, len);
		root.right = createBinaryTreeFromArray(arr, right, len);
			
		return root;
	}

	public static void printLinkedList(ListNode headNode) {
		while(headNode != null) {
			System.out.print(headNode.val + " ");
			headNode = headNode.next;
		}		
        System.out.println();
	}


	
}
