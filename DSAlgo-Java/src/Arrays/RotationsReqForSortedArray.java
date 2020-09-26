//https://www.geeksforgeeks.org/count-of-rotations-required-to-generate-a-sorted-array/
package Arrays;

public class RotationsReqForSortedArray {
	public static void main(String[] args) {

		// int array[] = { 4, 5, 1, 2, 3 };
		// int array[] = { 5, 6, 1, 2, 3, 4 };
		int array[] = { 2, 1, 2, 2, 2 };
		int deviatedIndex = binarySearchIndex(array, 0, array.length - 1);
		int leftRotation = array.length - deviatedIndex;
		int finalRotation = deviatedIndex < leftRotation ? deviatedIndex : leftRotation;
		System.out.println(finalRotation);
	}

	public static int binarySearchIndex(int array[], int low, int high) {
		while (low <= high) {
			int middleIndex = low + (high - low) / 2;
			if ((middleIndex > low) && (array[middleIndex - 1] > array[middleIndex])) {
				return middleIndex;
			}
			if ((middleIndex < high) && (array[middleIndex] < array[middleIndex + 1])) {
				return middleIndex;
			}
			if (array[middleIndex] < array[low]) {
				return binarySearchIndex(array, low, middleIndex - 1);
			} else {
				return binarySearchIndex(array, middleIndex + 1, high);
			}

		}
		return -1;
	}

}
