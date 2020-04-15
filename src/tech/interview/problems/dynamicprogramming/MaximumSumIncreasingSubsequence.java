package tech.interview.problems.dynamicprogramming;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
	public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(maximumSumIncreasingSubsequence(arr, arr.length));
	}

	private static int maximumSumIncreasingSubsequence(int[] arr, int n) {
		int[] mem = new int[n];
		Arrays.fill(mem, 0);
		int maxSum = 0;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && mem[i] < mem[j] + arr[i]) { 
					mem[i] = mem[j] + arr[i];
					maxSum = Math.max(maxSum, mem[i]);
				}
			}
		}
		
		return maxSum;
	}
}
