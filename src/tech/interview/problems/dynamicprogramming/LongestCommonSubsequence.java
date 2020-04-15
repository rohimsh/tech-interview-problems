package tech.interview.problems.dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    
	    System.out.println("LCS is: " + LCS(s1.toCharArray(), s2.toCharArray()));
	    
	}

	private static String LCS(char[] s1, char[] s2) {
		int n1 = s1.length;
		int n2 = s2.length;
		
		int[][] table = new int[n1 + 1][n2 + 1];
		
		for(int i = 0; i <= n1; i++) {
			for(int j = 0; j <= n2; j++) {
				
			if(i == 0 || j == 0)
				table[i][j] = 0;
			else if(s1[i - 1] == s2[j - 1])
				table[i][j] = table[i - 1][j - 1] + 1;  
			else	
				table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
			}
		}
		
		int lenLCS = table[n1][n2];
		
		StringBuilder sb = new StringBuilder();
		int i = n1, j = n2;
		while(lenLCS > 0) {
			if(s1[i - 1] == s2[j - 1]) {
				sb.append(s1[i - 1]);
				lenLCS--;
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
