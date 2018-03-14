package sorting;

import java.util.Arrays;

import utils.Util;

public class QuickSort {
	public static void main(String[] args) {
		 int arr[] =  {12, 3, 5, 7, 19, 0, -2, 34, 2, 6};

		 System.out.println(Arrays.toString(arr));
		 sort(arr, 1, arr.length - 2);
		 System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int p = partition(arr, low, high);
			sort(arr, low, p - 1);
			sort(arr, p + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low - 1, partition = arr[high];
		
		for(int j = low; j <= high; j++) {
			if(arr[j] < partition) {
				i++;
				Util.swap(arr, i, j);
			}
		}
		
		Util.swap(arr, i + 1, high);
		return i + 1;
	}
	
}
