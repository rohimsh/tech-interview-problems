package dynamicprogramming;

public class LongestCommonSubsequenceOfThreeStrings {
	public static void main(String[] args) {
		String a = "TEDREX";
	    String b = "TREXL";
	    String c = "TIRAEXE";
	    
	    System.out.println(lcs(a, b, c));
	}

	private static String lcs(String a, String b, String c) {
		int x = a.length();
		int y = b.length();
		int z = c.length();
		
		int[][][] mem = new int[x + 1][y + 1][z + 1];
		
		for(int i = 0; i <= x; i++) {
			for(int j = 0; j <= y; j++) {
				for(int k = 0; k <= z; k++) {
					if(i == 0 || j == 0 || k == 0)
						mem[i][j][k] = 0;
					else if(a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1))
						mem[i][j][k] = 1 + mem[i - 1][j - 1][k - 1];
					else 
						mem[i][j][k] = Math.max(mem[i - 1][j][k], Math.max(mem[i][j - 1][k], mem[i][j][k - 1]));
				}
			}
		}
		
		int lcs = mem[x][y][z];
		int i = x, j = y, k = z;
		StringBuilder sb = new StringBuilder();
		
		while(lcs > 0) {
			if(a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
				sb.append(a.charAt(i - 1));
				lcs--;
				i--;
				j--;
				k--;
			} else {
				if(mem[i - 1][j][k] > mem[i][j - 1][k] && mem[i - 1][j][k] >  mem[i][j][k - 1]) {
					i--;
				} else if(mem[i][j - 1][k] > mem[i - 1][j][k] && mem[i][j - 1][k] > mem[i][j][k - 1]) {
					j--;
				} else {
					k--;
				}
			}
		}
		
		return sb.reverse().toString();
	}
}
