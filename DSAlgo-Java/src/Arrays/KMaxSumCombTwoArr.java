//https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
package Arrays;

public class KMaxSumCombTwoArr {
	public static void main(String[] args) {
		// int aarr[] = { 3, 2 };
		// int barr[] = { 1, 4 };
		// int k = 2;

		// int aarr[] = { 4, 2, 5, 1 };
		// int barr[] = { 8, 0, 3, 5 };
		// int k = 3;

		int aarr[] = { 1, 4, 2, 3 };
		int barr[] = { 2, 5, 1, 6 };
		int k = 4;
		heapSort(aarr);
		heapSort(barr);
		int farr[] = kMaxSumCombination(aarr, barr, k);
		for (int index = farr.length - 1; index >= 0; index--) {
			System.out.println(farr[index]);
		}
	}

	public static int[] kMaxSumCombination(int aarr[], int barr[], int k) {
		int farr[] = new int[k];
		for (int index = 0, jIndex = 0; index < k && jIndex < k && k <= aarr.length
				&& k <= barr.length; index++, jIndex++) {
			if (index > 0 || jIndex > 0) {
				int element = aarr[aarr.length - 1] + barr[barr.length - 1 - jIndex];
				if (element > farr[0]) {
					farr[0] = element;
				}
				heapSort(farr);
				element = aarr[aarr.length - 1 - index] + barr[barr.length - 1];
				if (element > farr[0]) {
					farr[0] = element;
				}
				heapSort(farr);
			} else {
				farr[0] = aarr[aarr.length - 1] + barr[barr.length - 1];
				heapSort(farr);
			}
		}
		return farr;
	}

	public static void heapSort(int[] inputArray) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray);
			heapify(0, index, inputArray);
		}
	}

	public static void heapify(int index, int end, int[] inputArray) {
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < end && inputArray[left] > inputArray[largest]) {
			largest = left;
		}
		if (right < end && inputArray[right] > inputArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest, inputArray);
			heapify(largest, end, inputArray);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] inputArray) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}

}
