//https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
package Arrays;

public class FindNextGreaterNumber {
	public static void main(String[] args) {
		int arr[] = findNextLargestNumber(new int[] { 5, 3, 4, 9, 7, 6 });
		for (int index = 0; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
		}
		System.out.println();
	}

	public static void swap(int index, int jindex, int arr[]) {
		int temp = arr[index];
		arr[index] = arr[jindex];
		arr[jindex] = temp;
	}

	public static int[] findNextLargestNumber(int arr[]) {
		/*
		 * when all the digits are in desc order number is already the largest
		 */
		int jindex = 1;
		for (int index = 0; index < arr.length - 1; index++) {
			if (arr[index] > arr[index + 1]) {
				jindex++;
			}
		}
		if (jindex == arr.length) {
			return arr;
		}

		/*
		 * when all the digits are in asc order number is the smallest Need to swap the
		 * last 2 digits
		 */
		jindex = 1;
		for (int index = 0; index < arr.length - 1; index++) {
			if (arr[index] < arr[index + 1]) {
				jindex++;
			}
		}
		if (jindex == arr.length) {
			swap(arr.length - 1, arr.length - 2, arr);
		}

		jindex = 0;
		int smallestDigit = -1;
		for (int index = arr.length - 1; index > 0; index--) {
			if (arr[index] > arr[index - 1]) {
				jindex = index - 1;
				smallestDigit = arr[index - 1];
				break;
			}
		}

		if (jindex == 0 || smallestDigit == -1) {
			return arr;
		} else {
			int smallLargestDigit = Integer.MAX_VALUE;
			int smallLargestIndex = -1;
			for (int index = jindex + 1; index < arr.length; index++) {
				if (smallLargestDigit > arr[index]) {
					smallLargestDigit = arr[index];
					smallLargestIndex = index;
				}
			}
			if (smallLargestIndex != -1) {
				swap(jindex, smallLargestIndex, arr);
			}
			int k = 0;
			int subArr[] = new int[(arr.length) - (jindex + 1)];
			for (int index = jindex + 1; index < arr.length; index++) {
				subArr[k++] = arr[index];
			}
			heapSort(subArr);
			k = 0;
			for (int index = jindex + 1; index < arr.length; index++) {
				arr[index] = subArr[k++];
			}
		}
		return arr;
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
}
