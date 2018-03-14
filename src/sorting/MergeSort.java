package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		 int arr[] = {12, 3, 5, 7, 19, 0, -2, 34, 2, 6};

		 System.out.println(Arrays.toString(arr));
		 sort(arr, 1, arr.length - 2);
		 System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	} 

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];
		
		
		for(int i = 0; i < left.length; i++)
			left[i] = arr[i + low];
		
		for(int j = 0; j < right.length; j++)
			right[j] = arr[j + mid + 1];
		int i = 0, j = 0, k = low;

		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		
		while(i < left.length) {
			arr[k++] = left[i++];
		}

		while(j < right.length) {
			arr[k++] = right[j++];
		}		
	}
}
