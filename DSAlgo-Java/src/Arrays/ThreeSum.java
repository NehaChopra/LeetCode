/*
 * https://leetcode.com/problems/3sum/
 * Example 1:
	
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	Example 2:
	
	Input: nums = []
	Output: []
	Example 3:
	
	Input: nums = [0]
	Output: []
	 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int target = 0;
//		
//		int[] nums = {};
//		int target = 0;
//		
//		int[] nums = {0};
//		int target = 0;
//		
		List<List<Integer>> array = threeSum(nums, target);
//		for(int index= 0; index< array.size(); index++) {
//			for(int jIndex= 0; jIndex< array.size(); jIndex++) {
//				System.out.println(array[index][jIndex]);
//			}
//		}
	}

	public static List<List<Integer>> threeSum(int[] nums, int target) {
		heapSort(nums);
		Set<List<Integer>> res = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int index = 0; index < nums.length; index++) {
			map.put(nums[index] + "_", index);
		}
		for (int index = 0, jIndex = nums.length- 1; index < nums.length && jIndex >= 0;) {
			if(index < jIndex) {
				int num = target - (-nums[index]) - (-nums[jIndex]);
				System.out.println(num);
				if (map.containsKey(num + "_") && map.get(num + "_") != index && map.get(num + "_") != jIndex) {
					res.add(Arrays.asList(nums[index], nums[jIndex], num));
				}
				jIndex--;
			}else {
				jIndex = nums.length- 1;
				index ++;
			}
		}
		result.addAll(res);
		return result;
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
