//https://www.geeksforgeeks.org/find-the-first-missing-number/
package Arrays;

public class SmallestMissingNum {
	public static void main(String[] args) {
		// int array[] = { 0, 1, 2, 6, 9 };
		// int n = 5;
		// int m = 10;

		// int array[] = { 4, 5, 10, 11 };
		// int n = 4;
		// int m = 12;

		// int array[] = { 0, 1, 2, 3 };
		// int n = 4;
		// int m = 5;

		int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 10 };
		int n = 9;
		int m = 11;

		System.out.println(binarySearch(array, 0, n - 1, 0, m));
	}

	public static int binarySearch(int array[], int low, int high, int element, int m) {
		while (low <= high && element < m) {
			if (low == 0 && array[0] != 0) {
				return 0;
			}
			int middleIndex = low + (high - low) / 2;
			if (array[middleIndex] == element) {
				return binarySearch(array, 0, array.length - 1, element = element + 1, m);
			}
			if (array[middleIndex] < element) {
				return binarySearch(array, middleIndex + 1, high, element, m);
			} else if (array[middleIndex] > element) {
				return binarySearch(array, low, middleIndex - 1, element, m);
			}
		}
		return element;

	}
}
