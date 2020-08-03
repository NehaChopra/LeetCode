//https://www.geeksforgeeks.org/sort-array-according-count-set-bits/
package Arrays;

public class SortArrayAccordingCountBits {
	public static void main(String[] args) {
		int arr[] = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		sortByBitsCount(arr);
	}

	public static int countBits(int num) {
		int count = 0;
		while (num > 0) {
			if ((num & 1) > 0) {
				count = count + 1;
			}
			num = num >> 1;
		}
		return count;
	}

	public static void sortByBitsCount(int arr[]) {
		int bitsArr[] = new int[arr.length];
		for (int index = 0; index < arr.length; index++) {
			bitsArr[index] = countBits(arr[index]);
		}
		heapSort(bitsArr, arr);
		for (int index = arr.length - 1; index >= 0; index--) {
			System.out.println(arr[index]);
		}
	}

	public static void heapSort(int[] bitsArray, int[] inputArray) {
		for (int index = bitsArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, bitsArray.length, bitsArray, inputArray);
		}

		for (int index = bitsArray.length - 1; index >= 0; index--) {
			swap(0, index, bitsArray, inputArray);
			heapify(0, index, bitsArray, inputArray);
		}
	}

	public static void heapify(int index, int end, int[] bitsArray, int[] inputArray) {
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < end && bitsArray[left] > bitsArray[largest]) {
			largest = left;
		}
		if (right < end && bitsArray[right] > bitsArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest, bitsArray, inputArray);
			heapify(largest, end, bitsArray, inputArray);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] bitsArray, int[] inputArray) {
		int temp = bitsArray[iIndex];
		bitsArray[iIndex] = bitsArray[jIndex];
		bitsArray[jIndex] = temp;

		int temp1 = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp1;
	}

}
