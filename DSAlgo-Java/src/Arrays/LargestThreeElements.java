//https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/
package Arrays;

public class LargestThreeElements {
	public static void main(String[] args) {
		int arr[] = { 10, 4, 3, 50, 23, 90 };
		heapify(arr);
		printLargestNElements(arr, 3);
	}

	public static void printLargestNElements(int arr[], int N) {
		for (int index = 1; index <= N; index++) {
			System.out.println(arr[arr.length - index]);
		}
	}

	public static void heapify(int array[]) {
		for (int index = array.length / 2 - 1; index >= 0; index--) {
			heapsort(array, index, array.length);
		}
		for (int index = array.length - 1; index >= 0; index--) {
			swap(array, 0, index);
			heapsort(array, 0, index);
		}
	}

	public static void heapsort(int array[], int index, int end) {
		int largest = index;
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRighChild(index);

		if (leftChildIndex < end && array[largest] < array[leftChildIndex]) {
			largest = leftChildIndex;
		}
		if (rightChildIndex < end && array[largest] < array[rightChildIndex]) {
			largest = rightChildIndex;
		}
		if (largest != index) {
			swap(array, index, largest);
			heapsort(array, largest, end);
		}
	}

	public static int getLeftChild(int index) {
		return (index + 1);
	}

	public static int getRighChild(int index) {
		return (index + 2);
	}

	public static void swap(int array[], int index, int jindex) {
		int temp = array[index];
		array[index] = array[jindex];
		array[jindex] = temp;
	}
}
