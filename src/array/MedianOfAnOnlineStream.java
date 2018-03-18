package array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfAnOnlineStream {
	private static float median = 0; 
	
	public static void main(String[] args) {
	    int arr[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
	    printMedianForStream(arr);
	}

	private static void printMedianForStream(int[] arr) {
		
		Queue<Integer> minHeap = new PriorityQueue<Integer>(); 
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); 
		
	    for(int i = 0; i < arr.length; i++) {
	    	printMedian(arr, i, minHeap, maxHeap);
	    	System.out.println(median);
	    }
		
	}

	private static void printMedian(int[] arr, int index, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
			if(minHeap.size() > maxHeap.size()) {
				if(arr[index] < median) {
					maxHeap.add(arr[index]);
				} else {
					maxHeap.add(minHeap.poll());
					minHeap.add(arr[index]);
				}
				median = getAverage(minHeap.peek(), maxHeap.peek());
			} else if(minHeap.size() == maxHeap.size()) {
				if(arr[index] < median) {
					maxHeap.add(arr[index]);
					median = maxHeap.peek();
				} else {
					minHeap.add(arr[index]);
					median = minHeap.peek();
				}
			} else if(minHeap.size() < maxHeap.size()) {
				if(arr[index] < median) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(arr[index]);
				} else {
					minHeap.add(arr[index]);
				}
				median = getAverage(minHeap.peek(), maxHeap.peek());
			}
			

	}

	private static float getAverage(Integer n, Integer m) {
		return (n + m) / 2;
	}
}
