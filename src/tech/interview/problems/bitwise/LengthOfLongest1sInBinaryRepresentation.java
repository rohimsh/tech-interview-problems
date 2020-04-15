package tech.interview.problems.bitwise;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/length-longest-consecutive-1s-binary-representation/
 */
public class LengthOfLongest1sInBinaryRepresentation {
	public static void main(String[] args) {
		System.out.println(findMaxConsecutive1s(14));
		System.out.println(findMaxConsecutive1s(222));
		
	}

	private static int findMaxConsecutive1s(int n) {
		int count = 0;
		while(n != 0) {
			n = (n & (n << 1));
			count++;
		}
		return count;
	}
}
