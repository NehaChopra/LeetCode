/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
	Example 1:
	
	Input: nums = [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
	Example 2:
	
	Input: nums = [-2,0,-1]
	Output: 0
	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
package Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
//		 int[] nums = { 2,3,-2,4 };
//		 int[] nums = {-2,0,-1};
//		 int[] nums = {-3,-1,-1};
//		 int[] nums = {0,2};
//		 int[] nums = {0};
//		int[] nums = { 3, -1, 4 };
		int[] nums = { -2, 3, -4};
//
		System.out.println(maxSubarray(nums));
	}

	public static int maxSubarray(int[] nums) {
		int max = nums[0];
		int maxProd = max;
		int minProd = max;

		for (int index = 1; index < nums.length; index++) {
			// swap because neg*neg becoms positive
			if (nums[index] < 0) {
				int temp = maxProd;
				maxProd = minProd;
				minProd = temp;
			}
			maxProd = Math.max(nums[index], maxProd * nums[index]);
			minProd = Math.min(nums[index], minProd * nums[index]);
			
			max = Math.max(max, maxProd);
		}
		return max;
	}
}
