package tech.interview.problems.misc;

import java.util.Arrays;

public class KMPStringSearch {
	public static void main(String[] args) {
		String text = "abxabcabcabyx";
		String pattern = "abcaby";
		
		KMP(text.toCharArray(), pattern.toCharArray());
	}

	public static void KMP(char[] text, char[] pattern) {
		int i = 0, j = 0, n = text.length, m = pattern.length;
		int[] lps = createLPSArray(pattern, m);
		System.out.println(Arrays.toString(lps));
		
		while(i < n) {
			
			if(text[i] == pattern[j]) {
				i++;
				j++;
			}
			
			if(j == m) {
				System.out.println("Pattern found at: " + (i - j));
				j = lps[j - 1];
			} else if (i < n && pattern[j] != text[i]) {
	            if (j == 0)
	            	i++;
	            else
	                j = lps[j - 1];
	        }
			
		}
	}

	private static int[] createLPSArray(char[] pattern, int m) {
		int i = 1, j = 0;
		int[] lps = new int[m];

		while(i < m) {
			if(pattern[i] == pattern[j]) {
				j++;
				lps[i] = j;
				i++;
			} else {
				if(j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
		}
		return lps;
	}
	
}
