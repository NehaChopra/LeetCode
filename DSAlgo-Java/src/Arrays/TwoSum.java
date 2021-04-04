/* 
 * https://leetcode.com/problems/two-sum/
 * Example 1:

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:
	
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	Example 3:
	
	Input: nums = [3,3], target = 6
	Output: [0,1]

 */
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
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
				return new int[] { index, map.get(num) };
			}
		}
		return new int[] { -1, -1 };
	}
}
