package tech.interview.problems.dynamicprogramming;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 3};
		System.out.println(multiplicationCostRecursive(arr, 1, arr.length - 1));
		System.out.println(multiplicationCostDP(arr, arr.length));
	}

	private static int multiplicationCostDP(int[] arr, int n) {
		int[][] mem = new int[n][n];
		for(int i = 0; i < n; i++)
			mem[i][i] = 0;
		
		for(int l = 2; l < n; l++) {
			for(int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				if(j == n)
					continue;
				mem[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= j - 1; k++) {
					int cost = mem[i][k] + mem[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					mem[i][j] = Math.min(mem[i][j], cost);
				}
			}
		}
		return mem[1][n - 1];
	}

	private static int multiplicationCostRecursive(int[] arr, int i, int j) {
		if(i == j)
			return 0;
		
		int cost = Integer.MAX_VALUE;
		
		for(int k = i; k < j; k++) {
			int res = multiplicationCostRecursive(arr, i, k) 
						+ multiplicationCostRecursive(arr, k + 1, j)
							+ arr[i - 1] * arr[k] * arr[j];
			cost = Math.min(cost, res);
		}
		return cost;
	}
}
