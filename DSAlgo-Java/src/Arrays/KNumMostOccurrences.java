//https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class KNumMostOccurrences {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int k = 2;
		Map<Integer, Integer> hmap = occ(arr);
		Integer arrayKeys[] = hmap.keySet().stream().toArray(Integer[]::new);
		Integer arrayValues[] = hmap.values().stream().toArray(Integer[]::new);
		heapify(arrayKeys, arrayValues);
		System.out.println(arrayKeys);
		System.out.println(arrayValues);
	}

	public static Map<Integer, Integer> occ(int array[]) {
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int index = 0; index < array.length; index++) {
			if (hmap.containsKey(array[index])) {
				hmap.put(array[index], hmap.get(array[index]) + 1);
			} else {
				hmap.put(array[index], 1);
			}
		}
		return hmap;
	}

	public static void heapify(Integer arrayKeys[], Integer arrayValues[]) {
		for (int index = arrayValues.length / 2 - 1; index >= 0; index--) {
			heapsort(arrayKeys, arrayValues, index, arrayValues.length);
		}
		for (int index = arrayValues.length - 1; index >= 0; index--) {
			swap(arrayKeys, arrayValues, 0, index);
			heapsort(arrayKeys, arrayValues, 0, index);
		}
	}

	public static void heapsort(Integer arrayKeys[], Integer arrayValues[], int index, int end) {
		int largest = index;
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRighChild(index);

		if (leftChildIndex < end && arrayValues[largest] < arrayValues[leftChildIndex]) {
			largest = leftChildIndex;
		}
		if (rightChildIndex < end && arrayValues[largest] < arrayValues[rightChildIndex]) {
			largest = rightChildIndex;
		}
		if (largest != index) {
			swap(arrayKeys, arrayValues, index, largest);
			heapsort(arrayKeys, arrayValues, largest, end);
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

	public static void swap(Integer arrayKeys[], Integer arrayValues[], int index, int jindex) {
		int temp = arrayKeys[index];
		arrayKeys[index] = arrayKeys[jindex];
		arrayKeys[jindex] = temp;

		int temp1 = arrayValues[index];
		arrayValues[index] = arrayValues[jindex];
		arrayValues[jindex] = temp1;
	}

	public static void swap(int array[], int index, int jindex) {
		int temp = array[index];
		array[index] = array[jindex];
		array[jindex] = temp;

	}
}
