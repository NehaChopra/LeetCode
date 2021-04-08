/*
 * 
 */
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
//		int[] nums = {1,1,1};
//		int k = 2;
//		
//		int[] nums = {1,2,3};
//		int k = 3;
//		
//		int[] nums = {3,4,7,2,-3,1,4,2};
//		int k = 7;
		
		int[] nums = {1,2,1,2,1};
		int k = 3;
		System.out.println(countSubarrySumEqualK(nums, k));
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

	public static int countSubarrySumEqualK(int []nums, int k){
		heapSort(nums);
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(sum, 1);
		for(int index= 0 ;index<nums.length; index++) {
			sum = sum + nums[index];
			if(map.containsKey(sum - k)) {
				count = count +  map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
