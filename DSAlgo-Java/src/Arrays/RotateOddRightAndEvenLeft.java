//https://www.geeksforgeeks.org/rotate-all-odd-numbers-right-and-all-even-numbers-left-in-an-array-of-1-to-n/
package Arrays;

public class RotateOddRightAndEvenLeft {
	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int arr[] = rotateOddRightAndEvenLeft(array);
		for (int index = 0; index < arr.length; index++) {
			System.out.println(arr[index]);
		}
	}

	public static int[] rotateOddRightAndEvenLeft(int array[]) {
		int length = array.length;

		int oddIndex = Integer.MAX_VALUE;
		int evenIndex = Integer.MAX_VALUE;

		if (length % 2 == 0) {
			oddIndex = length - 1;
			evenIndex = length - 2;
		} else {
			oddIndex = length - 2;
			evenIndex = length - 1;
		}

		int oddElement = array[evenIndex];
		int evenElement = array[1];
		/*
		 * odd number - right rotate
		 */
		for (int index = evenIndex; index >= 2; index = index - 2) {
			array[index] = array[index - 2];
			if (index == 2) {
				array[0] = oddElement;
			}
		}
		/*
		 * even number - left rotate
		 */
		for (int index = 3; index < length; index = index + 2) {
			array[index - 2] = array[index];
			if (index == oddIndex) {
				array[index] = evenElement;
			}
		}
		return array;
	}

}
