package greedyalgorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 */
public class ActivitySelectionProblem {
	public static void main(String[] args) {
		int startFinish[][] =  new int[][]{{0, 6}, {1, 2}, {3, 4}, {5, 7}, {8, 9}, {5, 9}};
	    
	    System.out.println(maxNumberOfTaskDone(startFinish));
	}

	private static int maxNumberOfTaskDone(int[][] arr) {
		int count = 0, lastSelected  = 0;
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i][0] >= arr[lastSelected][1]) {
				count++;
				lastSelected = i;
			}
		}
	
		return count;
	}
	
}
