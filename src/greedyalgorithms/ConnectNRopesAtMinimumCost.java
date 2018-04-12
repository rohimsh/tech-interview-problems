package greedyalgorithms;

import java.util.PriorityQueue;

public class ConnectNRopesAtMinimumCost {
	public static void main(String[] args) {
	    int arr[] = {4, 3, 2, 6};
	    System.out.println(minimumCost(arr));
	}

	private static int minimumCost(int[] arr) {
		int totalCost = 0, currCost = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < arr.length; i++)
			pq.add(arr[i]);
		
		while(!pq.isEmpty()) {
			currCost = pq.poll();
			if(!pq.isEmpty()) {
				currCost += pq.poll();
				totalCost += currCost;
				pq.add(currCost);
			}
		}
		
		return totalCost;
	}
}
