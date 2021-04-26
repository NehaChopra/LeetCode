/*
 * https://leetcode.com/problems/last-stone-weight/
 * 
 *	Input: [2,7,4,1,8,1]
 
	Output: 1
	Explanation: 
	We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
	we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
	we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
	we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
	
	* 
 */
package Arrays;

public class LastStoneWeight {
	public static void main(String[] args) {
//		int[] stones = { 2, 7, 4, 1, 8, 1 };
//		int[] stones = { 1, 3 };
		int[] stones = { 1 };
		int lastStoneWeight  = lastStoneWeight(stones);
		System.out.println(lastStoneWeight);
	}

	public static int lastStoneWeight(int[] stones) {
		if(stones.length > 1) {
			for (int index = 0; index < stones.length; index++) {
				heapSort(stones);
				stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
				stones[stones.length - 2] = 0;
			}
		}
		return stones[stones.length - 1];	
	}

	public static void heapSort(int[] inputArray) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray);
			heapify(0, index, inputArray);
		}
	}

	public static void heapify(int index, int end, int[] inputArray) {
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < end && inputArray[left] > inputArray[largest]) {
			largest = left;
		}
		if (right < end && inputArray[right] > inputArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest, inputArray);
			heapify(largest, end, inputArray);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] inputArray) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}
}
