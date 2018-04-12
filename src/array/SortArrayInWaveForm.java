package array;

import java.util.Arrays;

import utils.Util;

public class SortArrayInWaveForm {
	public static void main(String[] args) {
	    int arr[] = {10, 90, 49, 2, 1, 5, 23};
		System.out.println("Before: "+ Arrays.toString(arr));
//		sortWavySorting(arr, arr.length);
		sortWavy(arr, arr.length);
		System.out.println("After: "+ Arrays.toString(arr));
	}

	private static void sortWavy(int[] arr, int n) {
		for(int i = 0; i < n; i += 2) {
			int prev = i - 1, next = i + 1;
			if(prev >= 0 && arr[prev] < arr[i]) {
				Util.swap(arr, i, prev);
			}
			if(next < n && arr[next] < arr[i]) {
				Util.swap(arr, i, next);
			}
		}
	}

	private static void sortWavySorting(int[] arr, int n) {
		Arrays.sort(arr);
		for(int i = 0; i + 1 < n; i += 2) {
			Util.swap(arr, i, i + 1);
		}
	}

}
