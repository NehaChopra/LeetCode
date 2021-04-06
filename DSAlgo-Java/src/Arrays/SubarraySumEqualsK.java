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

	public static int countSubarrySumEqualK(int []nums, int k){
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
