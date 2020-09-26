//https://www.geeksforgeeks.org/c-program-find-largest-element-array/
package Arrays;

public class LargestElement {

	public static void main(String[] args) {
		int array[] = { 10, 20, 4 };
		heapify(array);
		System.out.println(array[array.length - 1]);
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
