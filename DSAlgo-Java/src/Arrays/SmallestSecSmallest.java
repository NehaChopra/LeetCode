//https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class SmallestSecSmallest {
	public static void main(String[] args) {
		Integer arr[] = { 12, 13, 1, 10, 34, 1 };
		Integer[] arr1 = new HashSet<>(Arrays.asList(arr)).stream().toArray(Integer[]::new);
		int k = 2;
		heapify(arr1);
		Integer farr[] = smallestList(arr1, k);
		for (int index = 0; index < k; index++) {
			System.out.println(farr[index]);
		}
	}

	public static Integer[] smallestList(Integer arr[], int k) {
		Integer farr[] = new Integer[k];
		for (int index = 0; index < k; index++) {
			farr[index] = arr[index];
		}
		return farr;
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
