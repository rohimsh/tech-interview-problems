package dynamicprogramming;

public class CoinChange {
	public static void main(String[] args) {
	    int arr[] = {1, 2, 3};
	    int n = 4;
	    
	    System.out.println(possibleWays(arr, n));
	}

	private static int possibleWays(int[] arr, int n) {
		int len = arr.length;
		int table[] = new int[len + 1];
		table[0] = 1;
		for(int i = 0; i < len; i++) {
			for(int j = arr[i]; j <=n; j++) {
				table[j] += table[j - arr[i]];
			}
		}
		
		return table[n];
	}
	
}
