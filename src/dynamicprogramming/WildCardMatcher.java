package dynamicprogramming;

public class WildCardMatcher {

	public static void main(String args[])
    {
        String str = "baaabab";
        String pattern = "*****ba*****ab";

      
        if (matcher(str.toCharArray(), pattern.toCharArray()))
            System.out.println("Yes");
        else
            System.out.println("No");
      
    }

	private static boolean matcher(char[] text, char[] pattern) {
		int patLen = pattern.length;
		int textLen = text.length;
		
		boolean tab[][] = new boolean[textLen + 1][patLen + 1];
		
		tab[0][0] = true;
		
		for(int i = 1; i <= patLen; i++) {
			if(pattern[i - 1] == '*')
				tab[0][i] = tab[0][i - 1];
		}
		
		
		for(int i = 1; i <= textLen; i++) {
			for(int j = 1; j <= patLen; j++) {
				
				if(pattern[j - 1] == '*') {
					tab[i][j] = tab[i][j - 1] || tab[i - 1][j];
				}
				else if(pattern[j - 1] == text[i - 1] || pattern[j - 1] == '.') {
					tab[i][j] = tab[i - 1][j - 1];
				}
				else {
					tab[i][j] = false;
				}
				
			}
		}
		
		
		return tab[textLen][patLen];
		
		
	}
	
}
