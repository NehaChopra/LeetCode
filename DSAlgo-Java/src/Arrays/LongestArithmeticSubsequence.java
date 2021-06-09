package Arrays;

import java.util.HashMap;

public class LongestArithmeticSubsequence {
	public static void main(String[] args) {
//		 int[] nums = { 3, 6, 9, 12 };
//		int[] nums = { 9, 4, 7, 2, 10 };
//		 int[] nums = {20,1,15,3,10,5,8};
		int[] nums = {24,13,1,100,0,94,3,0,3};
		System.out.println(longestArithmeticSequenceLenght(nums));
	}

	public static int longestArithmeticSequenceLenght(int[] nums) {
		heapSort(nums);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(nums[0], 1);
		for (int index = 1; index < nums.length; index++) {
			for (int jindex = 0; jindex < index; jindex++) {
				int diff = nums[index] - nums[jindex];
				if (hm.containsKey(diff)) {
					hm.put(diff, hm.get(diff) + 1);
				} else {
					hm.put(diff, 1);
				}
			}
		}

		int maxCount = 0;
		for (int num : hm.values()) {
			int curr = num;
			maxCount = Math.max(maxCount, curr);
		}
		return maxCount;
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
