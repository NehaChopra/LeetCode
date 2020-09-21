//https://www.geeksforgeeks.org/mth-element-after-k-right-rotations-of-an-array
package Arrays;

public class MElementAfterKRightRotations {
	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5 };
		int K = 3, M = 2;
		System.out.println(MElementAfterKRightRotation(array, K, M));
	}

	public static int MElementAfterKRightRotation(int array[], int K, int M) {
		K = K % array.length;
		if (K >= M) {
			int index = (array.length - K) + (M - 1);
			return array[index];
		}
		if (K < M) {
			int index = (M - K - 1);
			return array[index];
		}
		return -1;
	}
}
