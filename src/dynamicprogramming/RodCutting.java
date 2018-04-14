package dynamicprogramming;

public class RodCutting {
	public static void main(String[] args) {
		int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxValueRecursive(price, price.length));
		System.out.println(maxValue(price, price.length));
	}


	private static int maxValueRecursive(int[] price, int n) {
		if(n <= 0)
			return 0;
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			maxValue =  Math.max(maxValue, maxValueRecursive(price, n - i - 1) + price[i]);
		}
		
		return maxValue;
	}

	private static int maxValue(int[] price, int n) {
		int[] mem = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			int maxValue = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++) {
				maxValue = Math.max(maxValue, price[j] + mem[i - j - 1]);
			}
			mem[i] = maxValue;
		}
		
		return mem[n];
	}
	
}
