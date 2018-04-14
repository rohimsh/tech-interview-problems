package dynamicprogramming;

public class CountOfAStringAppearingAsSubsequenceInOther {
	public static void main(String[] args) {
		String text = "thisandthat";
		String pattern = "tht";
		System.out.println(countFrequencyRecursive(text, pattern, text.length(), pattern.length()));
		System.out.println(countFrequency(text, pattern));
	}

	
	
	private static int countFrequencyRecursive(String text, String pattern, int m, int n) {

		if(m == 0 && n == 0 || n == 0)
			return 1;
		if(m == 0)
			return 0;
		
		if(text.charAt(m - 1) == pattern.charAt(n - 1))
			return countFrequencyRecursive(text, pattern, m - 1, n - 1) + countFrequencyRecursive(text, pattern, m - 1, n);
		else
			return countFrequencyRecursive(text, pattern, m - 1, n);
	}



	private static int countFrequency(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();
		int[][] mem = new int[m + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			mem[0][i] = 0;
		}
		for(int i = 0; i <= m ; i++) {
			mem[i][0] = 1;
		}
	
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(text.charAt(i - 1) != pattern.charAt(j - 1))
					mem[i][j] = mem[i - 1][j - 1];
				else
					mem[i][j] = mem[i - 1][j - 1] + mem[i - 1][j];
			}
		}
		
		return mem[m][n];
	}
}
