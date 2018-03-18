package dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class MinimumNumberOfCoinsRequiredForChange {
	public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int value = 11;
        System.out.println(findMinimumNumberOfCoinsRequired(coins, value));
	}

	private static int findMinimumNumberOfCoinsRequired(int[] coins, int value) {
		Arrays.sort(coins);
		int table[] = new int[value + 1];
		for(int i = 0; i <= value; i++){
			table[i] = Integer.MAX_VALUE;
		}		
		table[0] = 0;

		for(int i = 1; i <= value; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i == coins[j])
					table[i] = 1;
				else if(i >= coins[j] && table[i - coins[j]] != Integer.MAX_VALUE && table[i] > table[coins[j]] + table[i - coins[j]]) {
						table[i] = table[coins[j]] + table[i - coins[j]];
				}
			}
		}
		
		System.out.println(Arrays.toString(table));
		
	return table[value];	
	}
}
