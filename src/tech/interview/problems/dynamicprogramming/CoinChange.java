package tech.interview.problems.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
	    int arr[] = {2, 1, 3};
	    int n = 5;
	    
	    System.out.println(possibleWaysRecursive(arr, n, arr.length));
	    System.out.println(possibleWays(arr, n));
	    System.out.println(betterPossibleWays(arr, n));
	    
	}


	private static int possibleWaysRecursive(int[] arr, int n, int m) {
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(m <= 0 && n > 0)
			return 0;
		
		return possibleWaysRecursive(arr, n - arr[m - 1], m) + possibleWaysRecursive(arr, n, m - 1);
	}


	private static int betterPossibleWays(int[] arr, int n) {
	
		int[] table = new int[n + 1];
		table[0] = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr[i]; j <= n; j++) {
				table[j] += table[j - arr[i]];
			}
		}
		
		return table[n];
	}

	private static int possibleWays(int[] arr, int n) {
		int len = arr.length;
		Arrays.sort(arr);
		int table[][] = new int[len + 1][n + 1];
		
		for(int i = 0; i <= len; i++) {
			table[i][0] = 1;
		}
		for(int i = 1; i <= n; i++) {
			table[0][i] = 0;
		}
		
		for(int i = 1; i <= len; i++) {
			for(int j = 0; j <=n; j++) {
				if(i > 0){
					if(j >= arr[i - 1])
						table[i][j] = table[i - 1][j] + table[i][j - arr[i - 1]];					
					else
						table[i][j] = table[i - 1][j];
				}
			}
		}
		
//		for(int i = 0; i < table.length; i++)
//			System.out.println(Arrays.toString(table[i]));
		
		return table[len][n];
	}
	
	
	
	
}
