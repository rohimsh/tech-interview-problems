package tech.interview.problems.dynamicprogramming;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
 		String str = "TECHINTERVIEWPROBLEMSINTECH";
		System.out.println(findLongestPalindromicSubsequence(str.toCharArray(), 0, str.length() - 1));
		System.out.println(findLongestPalindromicSubsequenceusingDP(str.toCharArray(), str.length()));
		
	}

	private static int findLongestPalindromicSubsequence(char[] str, int lo, int hi) {
		if(lo == hi)
			return 1;
		if(str[lo] == str[hi] && lo + 1 == hi)
			return 2;
		
		if(str[lo] != str[hi])
			return Math.max(findLongestPalindromicSubsequence(str, lo + 1, hi), findLongestPalindromicSubsequence(str, lo, hi - 1));
		
		return findLongestPalindromicSubsequence(str, lo + 1, hi - 1) + 2;
	}
	
	private static int findLongestPalindromicSubsequenceusingDP(char[] str, int n) {
		int[][] mem = new int[n + 1][n + 1];
	      
	       for (int i = 0; i < n; i++)
	    	   mem[i][i] = 1;
	       
	        for (int l = 2; l <= n; l++)
	        {
	            for (int i=0; i < n - l + 1; i++)
	            {
	                int j = i + l - 1;
	                if (str[i] == str[j] && l == 2)
	                   mem[i][j] = 2;
	                else if (str[i] == str[j])
	                   mem[i][j] = mem[i+1][j-1] + 2;
	                else
	                   mem[i][j] = Math.max(mem[i][j-1], mem[i+1][j]);
	            }
	        }
	              
	        return mem[0][n-1];
	}


}
