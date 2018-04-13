package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        System.out.println(Arrays.toString(stockSpan(price)));
	}

	private static int[] stockSpan(int[] price) {
		Stack<Integer> stack = new Stack<Integer>(); 
		int n = price.length;
		int[] span = new int[n];
		
		span[0] = 1;
		stack.push(0);
		
		for(int i = 1; i < n; i++) {
			int curr = price[i];
			while(!stack.isEmpty() && price[stack.peek()] <= curr) {
				stack.pop();
			}
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}
		
		return span;
	}

}
