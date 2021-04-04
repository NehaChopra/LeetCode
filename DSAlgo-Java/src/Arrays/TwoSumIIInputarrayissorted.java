/* 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * Example 1:

	Input: numbers = [2,7,11,15], target = 9
	Output: [1,2]
	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	Example 2:
	
	Input: numbers = [2,3,4], target = 6
	Output: [1,3]
	Example 3:
	
	Input: numbers = [-1,0], target = -1
	Output: [1,2]


 */
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputarrayissorted {
	public static void main(String[] args) {
//		int[] nums = {2,7,11,15};
//		int target = 9;
//		
//		int[] nums = {3,2,4};
//		int target = 6;
//		
		int[] nums = {3,3};
		int target = 6;
//		
		int[] array = twoSum(nums, target);
		for(int index= 0; index< array.length; index++) {
			System.out.println(array[index]);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int index = 0; index < nums.length; index++) {
			map.put(nums[index], index);
		}
		for (int index = 0; index < nums.length; index++) {
			int num = target - nums[index];
			if (map.containsKey(num) && map.get(num) != index) {
				return new int[] { index+1, map.get(num)+1 };
			}
		}
		return new int[] { };
	}
}
