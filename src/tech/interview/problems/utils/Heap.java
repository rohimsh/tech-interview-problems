package tech.interview.problems.utils;

public class Heap {
	
	public static void buildMaxHeap(int[] arr, int low, int high) {
		for(int i = high / 2 - 1; i >= low; i--) {
			maxHeapify(arr, i, low, high);
		}
	}

	public static void maxHeapify(int[] arr, int i, int low, int high) {
		int largest = i;
		int left = 2*i + 1 - low;
		int right = 2*i + 2 - low;
		
		if(left <= high && arr[left] > arr[largest]) {
			largest = left;
		}
		if(right <= high && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			Util.swap(arr, i, largest);
			maxHeapify(arr, largest, low, high);
		}
	}

	public static void buildMinHeap(int[] arr, int low, int high) {
		for(int i = high / 2 - 1; i >= low; i--) {
			minHeapify(arr, i, low, high);
		}
	}

	public static void minHeapify(int[] arr, int i, int low, int high) {
		int smallest = i;
		int left = 2*i + 1 - low;
		int right = 2*i + 2 - low;
		
		if(left <= high && arr[left] < arr[smallest]) {
			smallest = left;
		}
		if(right <= high && arr[right] < arr[smallest]) {
			smallest = right;
		}
		
		if(smallest != i) {
			Util.swap(arr, i, smallest);
			minHeapify(arr, smallest, low, high);
		}
	}

	public static int extractMin(int[] arr, int low, int high) {
		int min = arr[0];
		Util.swap(arr, 0, high);
		minHeapify(arr, 0, low, high - 1);
		return min;
	}

	public static int extractMax(int[] arr, int low, int high) {
		int max = arr[0];
		Util.swap(arr, 0, high);
		maxHeapify(arr, 0, low, high - 1);
		return max;
	}
}
