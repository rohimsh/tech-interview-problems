package dynamicprogramming;

import java.util.Arrays;

public class GoldMining {
	public static void main(String[] args) {
		int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };

        System.out.print(getMaxGold(gold));
	}

	private static int getMaxGold(int[][] gold) {
		int m = gold.length;
		int n = gold[0].length;
		int maxValRow = 0;
		
		int[][] mem = new int[m][n];
		
		 for (int col = n-1; col >= 0; col--)
	        {
	            for (int row = 0; row < m; row++)
	            {
	                int right = (col == n-1) ? 0
	                        : mem[row][col+1];
	     
	                int right_up = (row == 0 ||
	                               col == n-1) ? 0 :
	                            	   mem[row-1][col+1];
	     
	                int right_down = (row == m-1
	                            || col == n-1) ? 0 :
	                            	mem[row+1][col+1];
	     
	                mem[row][col] = gold[row][col]
	                 + Math.max(right, Math.max(right_up, 
	                                       right_down));
	                                                        ;
	            }
	        }
		 
		 for(int i = 0; i < m; i++) {
			 if(mem[i][0] > mem[maxValRow][0])
				 maxValRow = i;
		 }
		 
		return mem[maxValRow][0];
	}

}
