package tech.interview.problems.array;

import tech.interview.problems.utils.Util;

public class FindNumberInSortedRotatedArray {
	public static void main(String[] args) {
	   int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
       int n = arr.length - 1;
       int key = 3;
       System.out.println("Index for element is: " + binarySearchInRotatedArray(arr, n, key));
	}

	private static int binarySearchInRotatedArray(int[] arr, int n, int key) {
		int pivot = Util.findPivotInRotatedArray(arr, 0, n);
		
		if(pivot == -1) // tech.interview.problems.array is not rotated
			return Util.binarySearchIterative(arr, 0, n, key);
		if(arr[pivot] == key)
			return pivot;
		if(arr[0] < key)
			return Util.binarySearchIterative(arr, 0, pivot - 1, key);
		else
			return Util.binarySearchIterative(arr, pivot + 1, n, key);
	}
	
}
