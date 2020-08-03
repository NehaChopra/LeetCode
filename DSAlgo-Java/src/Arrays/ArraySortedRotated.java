//https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated/
package Arrays;

public class ArraySortedRotated {
	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 1, 2 };
//		int arr[] = {7, 9, 11, 12, 5};
//		int arr[] = { 1, 2, 3 };
		boolean result = sortedRotated(arr);
		System.out.println(result);
	}

	public static boolean sortedRotated(int arr[]) {
		int minElement = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] < minElement) {
				minElement = arr[index];
				minIndex = index;
			}
		}

		if (minIndex == 0) {// never rotated
			return false;
		}

		boolean before = true;
		for (int index = 0; index < minIndex - 1; index++) {
			if (arr[index] > arr[index + 1]) {
				before = false;
				break;
			}
		}

		boolean after = true;
		for (int index = minIndex; index < arr.length - 1; index++) {
			if (arr[index] > arr[index + 1]) {
				after = false;
				break;
			}
		}

		return before && after;
	}
}
