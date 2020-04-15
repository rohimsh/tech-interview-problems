package tech.interview.problems.array;

public class MaximumSumOfIXArrIForAllRoations {
	public static void main(String[] args) {
        int arr[] = {8, 3, 1, 2};
        System.out.println(maximumPossibleSum(arr, arr.length));
	}

	private static int maximumPossibleSum(int[] arr, int n) {
		int totalSum = 0, curValue = 0, maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			totalSum += arr[i];
			curValue += i * arr[i];
		}
			
		for(int i = 1; i < n; i++) {
			curValue = curValue - (totalSum - arr[i - 1]) + arr[i - 1] * (n - 1);
			maxValue = Math.max(maxValue, curValue);
		}
		
		return maxValue;
	}
}
