package tech.interview.problems.dynamicprogramming;

public class MobileNumericKeyPad {
	public static void main(String[] args) {
		char[][] keypad = new char[][]{{'1','2','3'},
						               {'4','5','6'},
						               {'7','8','9'},
						               {'*','0','#'}};
						            
		int n = Integer.MAX_VALUE;				               
						               
   		System.out.println(recursiveApproach(keypad, n));	
		
	}

	private static int recursiveApproach(char[][] keypad, int n) {
		
		// Base cases
	    if (keypad == null || n <= 0)
	        return 0;
	    if (n == 1)
	        return 10;
		
	    int totalCount = 0;
	    for (int i = 0; i < 4; i++)  // Loop on keypad row
	    {
	        for (int j = 0; j < 3; j++)   // Loop on keypad column
	        {
	            // Process for 0 to 9 digits
	            if (keypad[i][j] != '*' && keypad[i][j] != '#')
	            {
	                // Get count when number is starting from key
	                // position (i, j) and add in count obtained so far
	                totalCount += getCountUtil(keypad, i, j, n);
	            }
	        }
	    }
	    return totalCount;
	}

	
	private static int getCountUtil(char[][] keypad, int i, int j, int n) {
		if (keypad == null || n <= 0)
	        return 0;
	 
		if(n == 1)
			return 1;
		
		int X[] = {0, 0, -1, 0, 1};
		int Y[] = {0, -1, 0, 1, 0};
	    int row = 0, col = 0, totalCount = 0;
	    
	    for (int move = 0; move < 5; move++)
	    {
	        row = i + X[move];
	        col = j + Y[move];
	        if (row >= 0 && row < 4 && col >=0 && col < 3 &&
	           keypad[row][col] != '*' && keypad[row][col] != '#')
	        {
	            totalCount += getCountUtil(keypad, row, col, n-1);
	        }
	    }
	 
	    return totalCount;
	}
	
}
