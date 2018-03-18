package array;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 */
public class MaxDiffSuchThatLargerComesAfter {
	public static void main(String[] args) {
	    int arr[] = {80, 2, 6, 3, 100, 1, 220, 30};
	    
	    System.out.println(findMaxDiffFromPair(arr));
	}

	private static int findMaxDiffFromPair(int[] arr) {
		
		int maxDiff = Integer.MIN_VALUE;
		int minVal = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - minVal > maxDiff) 
				maxDiff = arr[i] - minVal;
			if(minVal > arr[i])
				minVal = arr[i];
		}
		
		return maxDiff;
	}
}
