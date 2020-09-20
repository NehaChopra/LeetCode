//https://www.geeksforgeeks.org/count-of-array-elements-greater-than-all-the-elements-on-its-left-and-at-least-k-elements-on-its-right/
package Arrays;

public class CountArrayElementsGreaterLeftAndLeastKRight {
	public static void main(String[] args) {
		// int array[] = { 2, 5, 1, 7, 3, 4, 0 };
		// int k = 3;

		int array[] = { 11, 2, 4, 7, 5, 9, 6, 3 };
		int k = 2;

		int arr[] = greaterOnLeft(array);
		int farr[] = greaterLeastKRight(array, arr, k);
		System.out.println(countSize(farr));
	}

	public static int countSize(int farr[]) {
		int count = 0;
		for (int index = 0; index < farr.length; index++) {
			if (farr[index] > 0) {
				count++;
			}
		}
		return count;
	}

	public static int[] greaterLeastKRight(int[] array, int arr[], int k) {
		int farr[] = new int[array.length];
		for (int index = 0; index < arr.length; index++) {
			int count = 0;
			if (arr[index] > 0) {
				int element = array[index];
				for (int jindex = array.length - 1; jindex >= 0; jindex--) {
					if (element > array[jindex]) {
						count = count + 1;
					}

					if (count >= k) {
						farr[index] = 1;
						break;
					}
				}
			}
		}
		return farr;
	}

	public static int[] greaterOnLeft(int[] array) {
		int arr[] = new int[array.length];
		int largest = Integer.MIN_VALUE;
		for (int index = 0; index < array.length; index++) {
			if (largest < array[index]) {
				largest = array[index];
				arr[index] = 1;
			}
		}
		return arr;
	}
}
