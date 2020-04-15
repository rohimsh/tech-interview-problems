package tech.interview.problems.dynamicprogramming;

public class EggDropping {
	public static void main(String[] args) {
		int numberOfEggs = 2;
		int numberOfFloors = 10;
		System.out.println(findMinimumTrials(numberOfEggs, numberOfFloors));
		System.out.println(findMinimumTrialsusingDP(numberOfEggs, numberOfFloors));
	}

	private static int findMinimumTrials(int n, int f) {
		if(f == 0 || f == 1)
			return f;
		if(n == 1)
			return f;
		
		int min = Integer.MAX_VALUE, cur = 0;
		
		for(int i = 1; i <= f; i++) {
			cur = Math.max(findMinimumTrials(n - 1, i - 1), findMinimumTrials(n, f - i));
			if(cur < min)
				min = cur;
		}
		
		return min + 1;
	}
	
	private static int findMinimumTrialsusingDP(int n, int f) {
		int[][] mem = new int[n + 1][f + 1];
		
		for(int i = 1; i <= n ; i++) {
			mem[i][0] = 0;
			mem[i][1] = 1;
		}
		
		for(int j = 1; j <= f; j++) {
			mem[1][j] = j;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= f; j++) {
				
				mem[i][j] = Integer.MAX_VALUE;
				
				for(int k = 1; k <= j; k++) {
					int curr = 1 + Math.max(mem[i - 1][k - 1], mem[i][j - k]);
					if(curr < mem[i][j])
						mem[i][j] = curr;
				}
			}
		}
		
		
		
		return mem[n][f];
	}


}
