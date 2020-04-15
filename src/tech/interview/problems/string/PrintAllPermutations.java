package tech.interview.problems.string;

public class PrintAllPermutations {
	public static void main(String[] args) {
		String str = "ABCDA";
		char[] arr = str.toCharArray();
		
		printPermutationsWithRepetitions(arr, 0, arr.length - 1);
	}

	private static void printPermutationsWithRepetitions(char[] arr, int lo, int hi) {
		if(lo == hi)
			System.out.println(String.valueOf(arr));
		else {	
			for(int i = 1; i <= hi; i++) {
				swap(arr, lo, i);
				printPermutationsWithRepetitions(arr, lo + 1, hi);
				swap(arr, lo, i);
			}
		}
	}

	private static void swap(char[] arr, int x, int y) {
		char tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

	
}
