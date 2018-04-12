package dynamicprogramming;

public class DivideArrayIntoEqualSumSubsets {
	public static void main(String[] args) {
		int arr[] = {3, 1, 1, 2, 2, 1};
		System.out.println(canBeDivided(arr, arr.length));
	}

	private static boolean canBeDivided(int[] arr, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += arr[i];
		if(sum % 2 == 0) {
			return FindSubsetWithSum.hasSubsetWithSum(arr, sum / 2);
		} else
			return false;
	}
}
