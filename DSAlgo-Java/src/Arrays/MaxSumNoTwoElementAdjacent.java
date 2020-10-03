//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
package Arrays;

public class MaxSumNoTwoElementAdjacent {
	public static void main(String[] args) {
		// int arr[] = {5, 5, 10, 100, 10, 5};
		// int arr[] = { 1, 2, 3 };
		int arr[] = { 1, 20, 3 };
		System.out.println(maxSumWithNoAdjacentElements(arr));

	}

	public static int maxSumWithNoAdjacentElements(int arr[]) {
		int sum = 0;
		int incl = arr[0];
		int excl = 0;
		for (int index = 1; index < arr.length; index++) {
			int exlNew = Integer.max(incl, excl);
			incl = excl + arr[index];
			excl = exlNew;
		}
		sum = Integer.max(incl, excl);
		return sum;
	}
}
