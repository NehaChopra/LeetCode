//https://www.geeksforgeeks.org/minimum-product-k-integers-array-positive-integers/
package Arrays;

public class MinProductkInt {
	public static void main(String[] args) {
		// int array[] = { 198, 76, 544, 123, 154, 675 };
		// int k = 2;
		int array[] = { 11, 8, 5, 7, 5, 100 };
		int k = 4;
		heapify(array);
		int product = minPorductOfKIntegers(array, k);
		System.out.println(product);
	}

	public static int minPorductOfKIntegers(int arr[], int k) {
		int product = 1;
		for (int index = 0; index < k; index++) {
			product = product * arr[index];
		}
		return product;
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
