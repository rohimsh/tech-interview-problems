package dynamicprogramming;

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String str = "AABEBCDD";
		System.out.println(LRS(str.toCharArray()));
	}

	private static String LRS(char[] arr) {
		int n = arr.length;
		int[][] table = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			table[i][0] = 0;
			table[0][i] = 0;
		}
		
		for(int i = 0; i <=n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					table[i][j] = 0;
				else if(i != j && arr[i - 1] == arr[j - 1])
					table[i][j] = table[i - 1][j - 1] + 1;
				else 
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
			}
		}
		
		int lenLRS = table[n][n];
		
		StringBuilder sb = new StringBuilder();
		int i = n, j = n;
		while(lenLRS > 0) {
			if(i != j && arr[i - 1] == arr[j - 1]) {
				sb.append(arr[i - 1]);
				lenLRS--;
				i--;
				j--;
			} else {
				if(table[i - 1][j] > table[i][j - 1]) {
					i--;
				} else
					j--;
			}
		}
		
	return sb.reverse().toString();
	}

}
