package array;

import sorting.HeapSort;
import utils.Heap;
import utils.Util;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 */
public class KthSmallestElementInArray {
	public static void main(String[] args) {
		 int arr[] = {12, 3, 5, 7, 19, 0, -2, 34, 2, 6};
		 int k = 5;
		 int kthSmallestUsingBubbleSort = findKthSmallestElementUsingBubbleSort(arr, k, arr.length);
		 System.out.println(kthSmallestUsingBubbleSort);
		 int kthSmallestUsingSorting = findKthSmallestElementUsingSorting(arr, k, arr.length);
		 System.out.println(kthSmallestUsingSorting);
		 int kthSmallestUsingMaxHeap = findKthSmallestElementUsingMaxHeap(arr, k, arr.length);
		 System.out.println(kthSmallestUsingMaxHeap);	
		 int kthSmallestUsingMinHeap = findKthSmallestElementUsingMinHeap(arr, k, arr.length);
		 System.out.println(kthSmallestUsingMinHeap);
		 
	}

	private static int findKthSmallestElementUsingBubbleSort(int[] arr, int k, int length) {
		for(int i = 0; i < k; i++) {
			int min = i;
			for(int j = i + 1; j < length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			Util.swap(arr, i, min);
		}
		return arr[k - 1];
	}

	public static int findKthSmallestElementUsingMinHeap(int[] arr, int k, int length) {
		
		Heap.buildMinHeap(arr, 0, length - 1);
		
		int kthMin = Integer.MIN_VALUE;
		for(int i = 0; i < k; i++) {
			kthMin = Heap.extractMin(arr, 0, length - i - 1);
		}
		
		return kthMin;
	}

	public static int findKthSmallestElementUsingMaxHeap(int[] arr, int k, int length) {
		
		Heap.buildMaxHeap(arr, 0, k);
		
 		for(int i = k + 1; i < length; i++) {
			if(arr[i] < arr[0]) {
				Heap.maxHeapify(arr, i, 0, k);
			}
		}

		return Heap.extractMax(arr, 0, k);
	}

	public static int findKthSmallestElementUsingSorting(int[] arr, int k, int length) {
		HeapSort.sort(arr, 0, length - 1);
		return arr[k - 1];
	}
	
}
