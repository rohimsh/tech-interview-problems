package array;

import utils.Util;

public class FindPairWithSumInSortedRotatedArray {
	public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        System.out.println(checkIfHasPair(arr, sum));
	}

	private static boolean checkIfHasPair(int[] arr, int sum) {
		int lo = -1, hi = -1, n = arr.length;
		int pivot = Util.findPivotInRotatedArray(arr, 0, n - 1);
		
		if(pivot == -1) {
			lo = 0;
			hi = n - 1;
		} else {
			lo = pivot + 1;
			hi = pivot;
		}
		
		while(lo != hi) {
			if(arr[lo] + arr[hi] == sum)
				return true;
			else {
				if(arr[lo] + arr[hi] < sum)
					lo = (lo + 1) % n;
				else
					hi = (hi - 1 + n) % n;
			}
		}
			
		return false;
	}

}
