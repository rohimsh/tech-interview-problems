package tech.interview.problems.dynamicprogramming;

public class FindSubsetWithSum {
	public static void main(String[] args) {
		int[] arr = new int[]{ 1, 2, 3, 0, 2, 6, 4, 2, 5, 7};
		int sum = 16;
		System.out.println(hasSubsetWithSumRecursive(arr, arr.length - 1, sum));
		System.out.println(hasSubsetWithSum(arr, sum));
	}

	public static boolean hasSubsetWithSum(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] mem = new boolean[sum + 1][n + 1];
		
		for(int i = 0; i <= n; i++)
			mem[0][i] = true;
		
		for (int i = 1; i <= sum; i++)
			mem[i][0] = false;
		
		for(int i = 1; i <= sum; i++) {
			for(int j = 1; j <= n; j++) {
				mem[i][j] = mem[i][j - 1];
				if(i >= arr[j - 1]) {
					mem[i][j] = mem[i][j] || mem[i - arr[j - 1]][j - 1];
				}
			}
		}
		
		return mem[sum][n];
	}
	
	private static boolean hasSubsetWithSumRecursive(int[] arr, int n, int sum) {
		if(sum == 0)
			return true;
		if(n < 0 || sum < 0)
			return false;
		
		return hasSubsetWithSumRecursive(arr, n - 1, sum - arr[n]) || hasSubsetWithSumRecursive(arr, n - 1, sum);
	}

}
