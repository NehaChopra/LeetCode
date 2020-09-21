//https://www.geeksforgeeks.org/how-to-left-or-right-rotate-an-array-in-java/
package Arrays;

public class LeftRightRotateArray {
	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5 };
		int D = 2;
		int arr[] = rotateByIndex(array, D);
		for (int index = 0; index < arr.length; index++) {
			System.out.println(arr[index]);
		}
	}

	public static int[] rotateByIndex(int array[], int D) {
		int element = Integer.MAX_VALUE;
		if (D == array.length) {
			return array;
		}
		for (int index = 1, jindex = 0; index <= array.length - 1 && jindex < D; index++) {
			if (element == Integer.MAX_VALUE) {
				element = array[0];
			}

			array[index - 1] = array[index];
			if (index == array.length - 1) {
				array[index] = element;
				jindex++;
				index = 0;
				element = Integer.MAX_VALUE;
			}

		}

		return array;
	}

}
