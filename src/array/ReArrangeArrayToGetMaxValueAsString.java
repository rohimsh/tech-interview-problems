package array;

import java.util.Arrays;
import java.util.Comparator;

public class ReArrangeArrayToGetMaxValueAsString {
	public static void main(String[] args) {
		String[] arr = new String[] {"54", "546", "548", "60"};
		sortTogetMaxValue(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortTogetMaxValue(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {
				String xy = x + y;
				String yx = y + x;

				return xy.compareTo(yx) > 0 ? -1 : 1;
			}
		});		
	}
}
