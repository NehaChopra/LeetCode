//https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
//https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
package Arrays;

public class CyclicallyRotateArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int k = 1;
		int fArr[] = rotateArrayByK(arr, k);
		for (int index = 0; index < fArr.length; index++) {
			System.out.println(fArr[index]);
		}
	}

	public static void reverseArray(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static int[] rotateArrayByK(int arr[], int k) {
		reverseArray(arr, arr.length - k, arr.length - 1);
		reverseArray(arr, 0, arr.length - k - 1);
		reverseArray(arr, 0, arr.length - 1);
		return arr;
	}

	public static void printArray(int arr[], int k) {
		for (int index = k; index < arr.length; index++) {
			System.out.print(arr[index] + " ");
		}
		for (int index = 0; index < k; index++) {
			System.out.print(arr[index] + " ");
		}
	}
}
