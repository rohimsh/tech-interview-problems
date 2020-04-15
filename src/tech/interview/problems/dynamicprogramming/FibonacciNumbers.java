package tech.interview.problems.dynamicprogramming;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class FibonacciNumbers {
	public static void main(String[] args) {
		System.out.println(fibonacci(25));
	}

	private static int fibonacci(int n) {
		int table[] = new int[n + 1];
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2; i <=n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
	return table[n];
	}

}
