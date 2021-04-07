/*
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Example 1:

	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	Example 2:
	
	Input: nums = [1]
	Output: 1
	Example 3:
	
	Input: nums = [5,4,-1,7,8]
	Output: 23

 
 */
package Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
//		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//
//		 int[] nums = {1};
		//
		 int[] nums = {5,4,-1,7,8};

		System.out.println(maxSubarray(nums));
	}

	// Kandane Algorithm
	public static int maxSubarray(int[] nums) {
		int maxSum = 0;
		int sum = 0;
		for (int index = 0; index < nums.length; index++) {
			sum = sum + nums[index];
			if (sum < 0) {
				sum = 0;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
}
