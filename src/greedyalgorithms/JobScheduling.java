package greedyalgorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 */
public class JobScheduling {
	public static void main(String[] args) {
		int deadlineProfit[][] =  new int[][]{{2, 100}, {1, 19}, {2, 27}, {1, 25}, {3, 15}};
	    
	    System.out.println(maxProfitEarned(deadlineProfit));
	}

	private static int maxProfitEarned(int[][] arr) {
		int profit = 0, lastSelected  = 0;
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		
		int maxDeadLine = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] > maxDeadLine)
				maxDeadLine = arr[i][0];
		}
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		int[] profits = new int[maxDeadLine];
		
		for(int i = 0; i < arr.length; i++) {
			int deadLine = arr[i][0] - 1;
			while(deadLine >= 0) {
				if(profits[deadLine] == 0) {
					profits[deadLine] = arr[i][1];
					break;
				}
				deadLine--;
			}
		}
		
//		System.out.println(Arrays.toString(profits));
		
		int totalProfit = 0;
		
		for(int i = 0; i < profits.length; i++) {
			totalProfit += profits[i];
		}
	
		return totalProfit;
	}

}
