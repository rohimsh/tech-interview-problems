package dynamicprogramming;

public class _01KnapSack {

	public static void main(String[] args) {
		int profit[] = {10, 60, 120, 60};
	    int weight[] = {10, 20, 5, 30};
	    
	    int size = 35;
	    int gain = 0;
	    
	    int n = profit.length;
	    System.out.println(maxProfitRecursive(profit, weight, size, gain, n - 1));
	    System.out.println(maxProfitUsingDP(profit, weight, size, n - 1));
	    System.out.println(betterMaxProfitUsingDP(profit, weight, size, n - 1));
	}


	private static int betterMaxProfitUsingDP(int[] profit, int[] weight, int size, int n) {
		int[] mem = new int[size + 1];
		for(int i = 0; i < n; i++) {
			for(int j=size; j>=weight[i]; j--)
				mem[j] = Math.max(mem[j] , profit[i] + mem[j - weight[i]]);
		}
		return mem[size];
	}


	private static int maxProfitRecursive(int[] profit, int[] weight, int size, int gain, int n) {
		if(n < 0)
			return 0;
	
		int includingThis = 0, excludingThis = 0;
		
		if(weight[n] <= size) {
			 includingThis = maxProfitRecursive(profit, weight, size - weight[n], gain + profit[n], n - 1);
			 includingThis += profit[n];
		}
	
		excludingThis = maxProfitRecursive(profit, weight, size, gain, n - 1);
		
		return Math.max(includingThis, excludingThis);
	}

	private static int maxProfitUsingDP(int[] profit, int[] weight, int size, int n) {
		
		int[][] mem = new int[n + 1][size + 1];
		
		for(int i = 0; i <= n; i++) {
			for(int w = 0; w <= size; w++) {
				
				if(i == 0 || w == 0)
					mem[i][w] = 0;
				else if(weight[i - 1] <= w)
					mem[i][w] = Math.max(profit[i - 1] + mem[i - 1][size - weight[i - 1]], mem[i - 1][w]);
				else
					mem[i][w] = mem[i - 1][w];
					
			}
		}
		
		return mem[n][size];
		
	}
	
}
