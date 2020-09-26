//https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
package Arrays;

import java.util.HashSet;
import java.util.Set;

public class KSmallestElementSorted2D {
	public static void main(String[] args) {
		int array[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 24, 29, 37, 48 }, { 32, 33, 39, 50 } };
		Set<Integer> fArray = new HashSet<Integer>();
		for (int index = 0; index < array.length; index++) {
			fArray.add(array[0][index]);
		}
		for (int index = 0; index < array[0].length; index++) {
			fArray.add(array[index][0]);
		}
		Integer arr[] = fArray.toArray(new Integer[fArray.size()]);
		heapify(arr);
		System.out.println(kSmallestElement(arr, 3));
		System.out.println(kSmallestElement(arr, 7));
	}

	public static int kSmallestElement(Integer array[], int K) {
		return array[K - 1];
	}

	public static void heapify(Integer array[]) {
		for (int index = array.length / 2 - 1; index >= 0; index--) {
			heapsort(array, index, array.length);
		}
		for (int index = array.length - 1; index >= 0; index--) {
			swap(array, 0, index);
			heapsort(array, 0, index);
		}
	}

	public static void heapsort(Integer array[], int index, int end) {
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

	public static void swap(Integer array[], int index, int jindex) {
		int temp = array[index];
		array[index] = array[jindex];
		array[jindex] = temp;
	}
}
