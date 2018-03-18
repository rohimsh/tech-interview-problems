package interviewquestions;
/**
 * 
 * @author rohitmishra
 * @see
 *  Given two string str and pat. Find minimum window in str which contains all characters from string pat.
 */
public class MinimumWindowContainingAllChars {
	
	public static final int MAX_NUMBER_OF_CHARS = 256;
	
	public static void main(String[] args) {
		String str = "adcxerytygfhddeacassdtywiyiwpstl";
		String pat = "itrcd";
		
		System.out.println(findPortionContainingAllChars(str, pat));
	}

	private static String findPortionContainingAllChars(String str, String pat) {
		if(str == null || pat == null || str.length() < pat.length()) {
			return null;
		}
		
		int lenPat = pat.length();
		int lenStr = str.length();
		int[] hashPat = new int[MAX_NUMBER_OF_CHARS];
		int[] hashStr = new int[MAX_NUMBER_OF_CHARS];
		int count = 0, start = 0, startIndex = -1, windowLen = Integer.MAX_VALUE;

		for(int i = 0; i < lenPat; i++) {
			hashPat[pat.charAt(i)]++;
		}
		
		
		for(int i = 0; i < lenStr; i++) {
			hashStr[str.charAt(i)]++;
			
			if(hashPat[str.charAt(i)] != 0 && hashPat[str.charAt(i)] >= hashStr[str.charAt(i)])
				count++;
			if(count == lenPat) {
				while(hashPat[str.charAt(start)] == 0 || hashStr[str.charAt(start)] > hashPat[str.charAt(start)]) {
					if(hashStr[str.charAt(start)] > hashPat[str.charAt(start)]) {
						hashStr[str.charAt(start)]--;
						start++;
					}
				}
				
				int updatedLen = i - start + 1;
				if(windowLen > updatedLen) {
					windowLen = updatedLen;
					startIndex = start;
				}
			}
		}
		
		if(startIndex == -1) {
			return null;
		}
		
		
		return str.substring(startIndex, startIndex + windowLen);
	}
	
}
