package tech.interview.problems.array;

public class FindMissingElementFromDuplicateArray {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 3, 4, 5};
		int[] dupArr = new int[]{1, 2, 3, 4, 5};
		
		System.out.println(printExtraValue(arr, dupArr, dupArr.length));
		System.out.println(printExtraValueUsingXOR(arr, dupArr));
		
	}

	private static int printExtraValueUsingXOR(int[] arr, int[] dupArr) {
		int xor = dupArr[0];
		
		for(int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
			xor ^= dupArr[i + 1];
		}
		
		return xor;
	}

	private static int printExtraValue(int[] dupArr, int[] arr, int n) {
		
		if(n == 0) {
			return dupArr[0];
		}
		
		if(arr[0] != dupArr[0])
			return arr[0];
		
		int lo = 0, hi = n - 1;
		
		while (lo < hi)
	    {
	        int mid = (lo + hi) / 2;
	 
	        if (arr[mid] == dupArr[mid])
	            lo = mid;
	        else
	            hi = mid;
	 
	        if (lo == hi - 1)
	            break;
	    }
	 
	    return arr[hi];	
	}

}
