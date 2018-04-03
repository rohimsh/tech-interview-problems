package divideconquer;

public class CalculatePower {
	
	public static void main(String[] args) {
		System.out.println(pow(6, 3));
	}

	private static int pow(int x, int y) {
		if(y == 0)
			return 1;
		if(y == 1)
			return x;
		
		int value = pow(x, y / 2);
		if(y % 2 == 0) {
			return value * value; 
		} else {
			return value * value * x;
		}
	}

}
