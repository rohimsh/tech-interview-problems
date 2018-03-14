package sorting;

import java.util.Arrays;

import utils.Heap;
import utils.Util;

public class HeapSort {

	public static void main(String[] args) {
		 int arr[] = {12, 3, 5, 7, 19, 0, -2, 34, 2, 6};

		 System.out.println(Arrays.toString(arr));
		 sort(arr, 1, arr.length - 2);
		 System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		
		Heap.buildMaxHeap(arr, low, high);
		 
		for(int i = high; i >= low; i--) {
			Util.swap(arr, low, i);
			Heap.maxHeapify(arr, low, low, i - 1);
		}
 	}

	

	

}
