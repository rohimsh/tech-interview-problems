package dynamicprogramming;

public class EditDistance {
	public static void main(String[] args) {
		String str1 = "sunday";
	    String str2 = "saturday";
	    System.out.println(minEditsRecursive(str1, str2, str1.length(), str2.length()));
	    System.out.println(minEdits(str1, str2));
	}

	
	private static int minEditsRecursive(String str1, String str2, int len1, int len2) {
		if(len1 < 0 || len2 < 0)
			return 0;
		if(len1 == 0)
			return len2;
		if(len2 == 0)
			return len1;
		
		if(str1.charAt(len1 - 1) == str2.charAt(len2 - 1))
			return minEditsRecursive(str1, str2, len1 - 1, len2 - 1);
		
		return Math.min(minEditsRecursive(str1, str2, len1 - 1, len2 - 1), 
					Math.min(minEditsRecursive(str1, str2, len1 - 1, len2), minEditsRecursive(str1, str2, len1, len2 - 1))) + 1;
	}


	private static int minEdits(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] mem = new int[len1 + 1][len2 + 1];
		
		for(int i = 0; i <= len1; i++) {
			for(int j = 0; j <= len2; j++) {
				if(i == 0)
					mem[i][j] = j;
				else if(j == 0)
					mem[i][j] = i;
				else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1];
				} else {
					mem[i][j] = Math.min(mem[i - 1][j - 1]  , Math.min(mem[i - 1][j], mem[i][j - 1])) + 1;
				}
			}
		}
		
		return mem[len1][len2];
	}
}
