package tech.interview.problems.array;

import tech.interview.problems.utils.Util;

public class ThreeWayPartitioning {

	 public static void main (String[] args) 
	    {
	        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
	         
	        threeWayPartition(arr, 10, 20);
	  
	        System.out.println("Modified tech.interview.problems.array : ");
	        for (int i=0; i < arr.length; i++)
	        {
	            System.out.print(arr[i] + " ");
	        }    
	    }

	private static void threeWayPartition(int[] arr, int l, int h) {
		int start = 0, end = arr.length - 1;
		for(int i = start; i <= end;) {
			if(arr[i] < l) {
				Util.swap(arr, i, start++);
				i++;
			} else if(arr[i] > h) {
				Util.swap(arr, i, end--);
			} else
				i++;
		}
	}
}
