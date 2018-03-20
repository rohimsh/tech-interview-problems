package dynamicprogramming;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 *
 */
public class BinomialCoefficient {
	public static void main(String[] args) {
	    int n = 5, k = 2;
	    System.out.println(binomialCoeff(n, k));
	}

	private static int binomialCoeff(int n, int k) {
	
		int table[] = new int[k + 1];
		table[0] = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = Math.min(i, k); j > 0; j--) {
				table[j] = table[j] + table[j - 1];
			}
		}
		
		return table[k];
	}

}
