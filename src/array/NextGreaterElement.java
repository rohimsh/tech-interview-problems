package array;

import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		int arr[] = {11, 13, 21, 3, 5, 7, 9, 6};
		
		printnextGreaterELements(arr);
	}

	private static void printnextGreaterELements(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			
			while(!stack.isEmpty() && stack.peek() < arr[i]) {
				System.out.println(stack.pop() + " -> "+ arr[i]);
			}
			stack.push(arr[i]);
			
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " -> "+ -1);
		}
	}
}
