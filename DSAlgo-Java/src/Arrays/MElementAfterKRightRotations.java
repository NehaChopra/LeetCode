//https://www.geeksforgeeks.org/find-the-mth-element-of-the-array-after-k-left-rotations/
package Arrays;

public class MElementAfterKRightRotations {
	public static void main(String[] args) {

		int array[] = { 3, 4, 5, 23 };
		int K = 2, M = 1;
		System.out.println(MElementAfterKLeftRotation(array, K, M));
	}

	public static int MElementAfterKLeftRotation(int array[], int K, int M) {
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
