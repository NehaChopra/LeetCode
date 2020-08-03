//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
package BinarySearch;

public class SearchAnElementSortedArray {
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
//		int arr[] = { 30, 40, 50, 10, 20 };
		int k = 3;
		System.out.println(binarySearch(arr, k, 0, arr.length));

	}

	public static int binarySearch(int arr[], int k, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == k) {
				return mid;
			}
			if (arr[mid] > k) {
				return binarySearch(arr, k, start, mid);
			} else {
				return binarySearch(arr, k, mid + 1, end);
			}
		}
		return -1;

	}
}
