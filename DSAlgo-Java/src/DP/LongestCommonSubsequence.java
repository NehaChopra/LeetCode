//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
package DP;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(longestCommonSubsequence(s1, s2));

	}

	public static int longestCommonSubsequence(String str1, String str2) {
		int strLength1 = str1.length();
		int strLength2 = str2.length();

		int arr[][] = new int[strLength1 + 1][strLength2 + 1];
		for (int index = 0; index <= strLength1; index++) {
			for (int jindex = 0; jindex <= strLength2; jindex++) {
				if (index == 0 || jindex == 0) {
					arr[index][jindex] = 0;
				} else if (str1.charAt(index - 1) == str2.charAt(jindex - 1)) {
					arr[index][jindex] = arr[index - 1][jindex - 1] + 1;
				} else {
					arr[index][jindex] = Math.max(arr[index - 1][jindex], arr[index][jindex - 1]);
				}
			}
		}
		return arr[strLength1][strLength2];
	}

}
