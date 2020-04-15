package tech.interview.problems.trees;

import java.util.Arrays;

public class PrintPostOrderFromInAndPre {
	public static void main(String[] args) {
		int in[] = {4, 2, 5, 1, 3, 6};
		int pre[] = {1, 2, 4, 5, 3, 6};
		printPostOrder(in, pre);
	}

	static void printPostOrder(int in[], int pre[]) {
		// The first element in pre[] is
		// always root, search it in in[]
		// to find left and right subtrees
		if(pre.length == 0)
			return;
		int root = search(in, pre[0]);
		if(root != 0){
			printPostOrder(Arrays.copyOfRange(in, 0, root), Arrays.copyOfRange(pre, 1, root + 1));
		}
		if(root + 1 != in.length){
			printPostOrder(Arrays.copyOfRange(in, root + 1, in.length),
					Arrays.copyOfRange(pre, root + 1, pre.length));
		}
		System.out.print(pre[0]);
		System.out.println(" ");
	}

	// A utility function to search x in arr[] of size n
	static int search(int arr[], int x) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == x)
				return i;
		return -1;
	}
}
