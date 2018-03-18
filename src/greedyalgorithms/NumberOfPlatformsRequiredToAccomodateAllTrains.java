package greedyalgorithms;

import java.util.Arrays;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class NumberOfPlatformsRequiredToAccomodateAllTrains {
	public static void main(String[] args) {
		 int arr[] = {900, 940, 950, 1100, 1500, 1800};
		 int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		 
		 System.out.println(findNumOfPlatformsRequired(arr, dep));
		 
	}

	private static int findNumOfPlatformsRequired(int[] arr, int[] dep) {
		int count = 0, in = 0, out = 0, len = arr.length, platformsRequired = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		while(in < len && out < len) {
			if(arr[in] < dep[out]) {
				count++;
				in++;
				if(platformsRequired < count)
					platformsRequired = count;
			} else {
				count--;
				out++;
			}
		}
		
	return platformsRequired;	
	}
}
