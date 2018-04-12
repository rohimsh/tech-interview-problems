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
	
	public static int binarySearchIterative(int[] arr, int start, int end, int key) {
		
		int index = -1;
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}	
		}
		return index;
	}
	
	
	public static int binarySearchRecursive(int[] arr, int start, int end, int key) {
		if(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == key)
				return mid;
			
			if(arr[mid] < key)
				return binarySearchRecursive(arr, mid + 1, end, key);
			else
				return binarySearchIterative(arr, start, mid - 1, key);
			
		}
		return -1;
	}
	
	public static int findPivotInRotatedArray(int[] arr, int lo, int hi) {
		if(hi < lo)
			return -1;
		if(lo == hi)
			return lo;
		
		int mid = (lo + hi) / 2;
		if(mid < hi && arr[mid] > arr[mid + 1])
			return mid;
		if(mid > lo && arr[mid] < arr[mid - 1])
			return mid - 1;
		
		if(arr[lo] < arr[mid])
			return findPivotInRotatedArray(arr, mid + 1, hi);
		else
			return findPivotInRotatedArray(arr, lo, mid - 1);
		
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
