package array;

import utils.Util;

public class SearchInSortedRotatedArray {

    public static void main(String args[])
    {
       int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
       int n = arr.length;
       int key = 2;
       //Find Pivot and then search 
       System.out.println("Index of the element is: " + pivotedBinarySearch(arr, n, key));
       //Without finding pivot
       System.out.println("Index of the element is: " + search(arr, 0, n - 1, key));
       
    
    }

	private static int search(int[] arr, int start, int end, int key) {
		
		if(end < start)
			return -1;
		int mid = (start + end) / 2;
		
		if(arr[mid] == key)
			return mid;
		
		if(arr[start] <= arr[mid]) {
			if(arr[start] <= key && key < arr[mid])
				return search(arr, start, mid - 1, key);
			else 
				return search(arr, mid + 1, end, key);			
		} else {
			if(arr[mid] < key && key < arr[end])
				return search(arr, mid + 1, end, key);
			else 
				return search(arr, start, mid - 1, key);
		}
	}

	private static int pivotedBinarySearch(int[] arr, int n, int key) {
		
		int pivot = findPivotInSortedRotatedArray(arr, 0, n);
		if(pivot != -1 && arr[pivot] <= key)
			return Util.binarySearch(arr, pivot, n, key);
		else 
			return Util.binarySearch(arr, 0, pivot, key);
	}

	private static int findPivotInSortedRotatedArray(int[] arr, int start, int end) {
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(mid - 1 >= 0 && arr[mid] < arr[mid - 1] || 
					mid + 1 < end && arr[mid] > arr[mid + 1]) {
				System.out.println("Pivot is at " + mid);
				return mid;
			} else if(arr[mid] > arr[start]) {
				start = mid;
			} else {
				end = mid;
			}			
		}

		return -1;
	}
	
}
