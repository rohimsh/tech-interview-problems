package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthChainOfPairs {

	static class Pair{
		int a;
		int b;
		Pair(int x, int y){
			this.a = x;
			this.b = y;
		}
		
	}
	
	public static void main(String[] args) {
		Pair pairs[] = new Pair[] {new Pair(15, 25), new Pair(5,24), new Pair (27, 40), new Pair(50, 60)};
		System.out.println(maximumLength(pairs));
	}

	private static int maximumLength(Pair[] pairs) {
		int n = pairs.length;
		int[] mem = new int[n];

		Arrays.sort(pairs, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.a > p2.a ? 1 : -1;
			}
		});
		
//		System.out.println(Arrays.toString(pairs));
		
		Arrays.fill(mem, 1);
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(pairs[i].a > pairs[j].b && mem[i] < mem[j] + 1)
					mem[i] = mem[j] + 1;
				max = Math.max(max, mem[i]);
			}
		}
		
		
		
		return max;
	}

}
