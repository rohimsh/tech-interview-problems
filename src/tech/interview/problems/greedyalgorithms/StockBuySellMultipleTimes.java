package tech.interview.problems.greedyalgorithms;

import java.util.HashMap;
import java.util.Map;

public class StockBuySellMultipleTimes {
	public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximizeProfit(prices).entrySet());
	}

	private static Map<Integer, Integer> maximizeProfit(int[] prices) {
		Map<Integer, Integer> orders = new HashMap<Integer, Integer>();
		int n = prices.length, localMin = 0, localMax = 0;
		
		for(int i = 1; i < n; i++) {
			while(i < n && prices[i] < prices[i - 1]) {
				i++;
			}
			
			if(i == n) {
				return orders;
			}
			
			localMin = i - 1;
			
			while(i + 1 < n && prices[i] < prices[i + 1]) {
				i++;
			}
			
			
			if(i == n && prices[n - 1] > prices[localMin]) {
				localMax = n - 1;
			} else {
				localMax = i;
			}
			
			if(localMax > localMin)
				orders.put(localMin, localMax);
		}
		
		return orders;
	}
}
