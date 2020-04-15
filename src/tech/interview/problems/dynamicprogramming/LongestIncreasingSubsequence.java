package tech.interview.problems.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(longestIncreasingSubsequence(arr, arr.length));
	}

	private static int longestIncreasingSubsequence(int[] arr, int n) {
		int[] mem = new int[n];
		Arrays.fill(mem, 1);
		int maxLen = 1;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && mem[i] < mem[j] + 1) { 
					mem[i] = mem[j] + 1;
					maxLen = Math.max(maxLen, mem[i]);
				}
			}
		}
		
		return maxLen;
	}
}
