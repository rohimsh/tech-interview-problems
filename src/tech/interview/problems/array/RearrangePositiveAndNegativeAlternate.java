package tech.interview.problems.array;

import java.util.Arrays;

import tech.interview.problems.utils.Util;

public class RearrangePositiveAndNegativeAlternate {
	public static void main(String[] args) {
		int[] arr = new int[] {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		System.out.println("Before: "+ Arrays.toString(arr));
		reArrange(arr, arr.length);
		System.out.println("After: "+ Arrays.toString(arr));
	}

	private static void reArrange(int[] arr, int n) {
		int pivot = partitionArray(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));
		int neg = 0, pos = pivot;
		
		while(neg < pivot) {
			neg++;
			pos++;
			Util.swap(arr, neg, pos);
			neg++;
			pos++;
		}
		
	}

	private static int partitionArray(int[] arr, int lo, int hi) {
		int pivot = 0, i = lo - 1;
		
		for(int j = lo; j <= hi; j++) {
			if(arr[j] <= pivot) {
				i++;
				Util.swap(arr, i, j);
			}
		}
		
		i++;
		Util.swap(arr, i, hi);
		
		return i;
	}

}
