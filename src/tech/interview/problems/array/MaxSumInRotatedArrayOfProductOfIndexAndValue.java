package tech.interview.problems.array;

public class MaxSumInRotatedArrayOfProductOfIndexAndValue {
	// Driver program
	public static void main(String[] args)
	{
	    int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	    
	    System.out.println("Max possible sum in all possible rotations is : " + maxPossibleSum(arr)); 

	}

	private static int maxPossibleSum(int[] arr) {
		int nextSum, curSum = 0, n = arr.length, cumSum = 0, max = Integer.MIN_VALUE; 
		for(int i = 0; i < n; i++)
			cumSum += arr[i];
		for(int i = 0; i < n; i++)
			curSum += i * arr[i];		
		
		for(int i = 1; i <= n; i++) {
			nextSum = curSum - cumSum + arr[i - 1]*n;
			max = Math.max(max, curSum);
			curSum = nextSum;
		}
		
		return max;
	}
}
