package tech.interview.problems.dynamicprogramming;

public class WaysToReachOnStairs {
	public static void main(String[] args) {
		int n = 20;
		int[] steps = new int[] {3, 5, 10};
		System.out.println(waysToReachRecursive(n, steps));
		System.out.println(waysToReachDP(n, steps));
	}

	private static int waysToReachDP(int n, int[] steps) {
		if(n == 0)
			return 0;
		
		int[] mem = new int[n + 1];
		mem[0] = 1;
		for(int i = 0; i < steps.length; i++) {
			for(int j = steps[i]; j <= n; j++) {
				mem[j] +=  mem[j - steps[i]];
			}
		}
		
		return mem[n];
	}

	private static int waysToReachRecursive(int n, int[] steps) {
		if(n <= 1)
			return n;
		
		int res = 0;
		
		for(int i = 0; i < steps.length; i++) {
			res += waysToReachRecursive(n - steps[i], steps);
		}
		
		return res;
	}
	
	

}
