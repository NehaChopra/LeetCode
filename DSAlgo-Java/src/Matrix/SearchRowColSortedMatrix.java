/**
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * 
 * 
 * Input: mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output: Found at (2, 1)
Explanation: Element at (2,1) is 29

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found
Explanation: Element 100 is not found
 */
package Matrix;

public class SearchRowColSortedMatrix {
	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		searchInSortedMatrix(mat, 29);

	}

	public static void searchInSortedMatrix(int mat[][], int element) {
		for (int index = 0; index < mat.length; index++) {
			int colIndex = binarySearch(mat[index], 0, mat[index].length, element);
			if (colIndex != -1) {
				System.out.println(index + " , " + colIndex);
			}
		}
	}

	public static int binarySearch(int[] array, int start, int end, int ele) {
		if (start <= end) {
			int midIndex = start + (end - start) / 2;
			if (array[midIndex] == ele) {
				return midIndex;
			}
			if (array[midIndex] > ele) {// element at midIndex > ele (search in the left of the array)
				return binarySearch(array, start, (midIndex - 1), ele);
			}
			if (array[midIndex] < ele) {// element at midIndex < ele (search in the right of the array
				return binarySearch(array, (midIndex + 1), end, ele);
			}
		}
		return -1;
	}
}
