//https://www.geeksforgeeks.org/print-all-possible-rotations-of-a-given-array/
package Arrays;

public class PossibleRotations {
	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4 };
		int length = array.length;
		posibleRotation(array, length);
	}

	public static void posibleRotation(int array[], int length) {
		int element = Integer.MAX_VALUE;
		for (int index = length - 1, jindex = 0; index > 0 && jindex < length; index--) {
			if (element == Integer.MAX_VALUE) {
				element = array[length - 1];
			}
			array[index] = array[index - 1];
			if (index == 1) {
				array[0] = element;
				element = Integer.MAX_VALUE;
				index = length;
				jindex++;
				print(array);
			}
		}
	}

	public static void print(int array[]) {
		for (int index = 0; index < array.length; index++) {
			System.out.print(array[index] + " ");
		}

		System.out.println();
	}
}
