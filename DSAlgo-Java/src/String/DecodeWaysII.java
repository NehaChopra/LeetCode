/*
 * https://leetcode.com/problems/decode-ways-ii/
 * 
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

Given a string s containing digits and the '*' character, return the number of ways to decode it.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: s = "*"
Output: 9
Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
Hence, there are a total of 9 ways to decode "*".
Example 2:

Input: s = "1*"
Output: 18
Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
Example 3:

Input: s = "2*"
Output: 15
Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
"21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".
 

Constraints:

1 <= s.length <= 105
s[i] is a digit or '*'.
 */
package String;

import java.util.ArrayList;
import java.util.List;

public class DecodeWaysII {
	public static int decodeWays(String str) {
		int count = 0;
		if (str == null || str.length() == 0) {
			return count;
		}
		int strLength = str.length();
		int array[] = new int[strLength + 1];
		array[0] = 1;
		if (str.charAt(0) == '*') {
			array[1] = str.charAt(0) == '*' ? 9 : 1;
		} else if (str.charAt(1) == '0') {
			array[1] = str.charAt(0) == '0' ? 0 : 1;
		}
		for (int index = 2; index <= strLength; index++) {
			String oneChar = str.substring(index - 1, index);
			String twoChar = str.substring(index - 2, index);
			if (oneChar.contains("*") || twoChar.contains("*")) {
				if (oneChar.contains("*")) {
					array[index] = array[index] + 9;
				}
				if (twoChar.contains("*")) {
					if (twoChar.charAt(0) == '*') {
						array[index] = array[index] + 2;
					}
					if (twoChar.charAt(0) == '*' && twoChar.charAt(1) == '*') {
						array[index] = array[index] + 15;
					} else {
						if (twoChar.charAt(1) == '*' && Integer.parseInt(twoChar.substring(0, 1)) < 3) {
							if (twoChar.charAt(0) == '1') {
								array[index] = array[index] + 9;
							}
							if (twoChar.charAt(0) == '2') {
								array[index] = array[index] + 6;
							}
						}
					}

				}

			} else {
				int oneCharElement = Integer.valueOf(oneChar);
				int twoCharElement = Integer.valueOf(twoChar);
				if (oneCharElement > 0 && oneCharElement < 10) {
					array[index] = array[index] + array[index - 1];
				}
				if (twoCharElement > 9 && twoCharElement < 27) {
					array[index] = array[index] + array[index - 2];
				}
			}
		}
		count = array[strLength];
		return count % 1000000007;

	}

	public static List<Integer> encryptionValidity(int instructionCount, int validityPeriod, List<Integer> keys) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		Integer strengthEnc = (Integer) maxDegreeOfDivisibility(keys) * (int) Math.pow(10, 5);
		Double hijProcess = (double) (instructionCount * validityPeriod);
		if (strengthEnc <= hijProcess) {
			result.add(1);
		} else if (strengthEnc > hijProcess) {
			result.add(0);
		}
		System.out.println(strengthEnc);
		result.add(strengthEnc);
		return result;
	}

	public static Integer maxDegreeOfDivisibility(List<Integer> keys) {
		Integer maxDegree = 0;
		for (int index = 0; index < keys.size(); index++) {
			int count = 0;
			for (int jindex = 0; jindex < keys.size(); jindex++) {
				if (keys.get(index) % keys.get(jindex) == 0) {
					count = count + 1;
				}
			}
			maxDegree = Integer.max(maxDegree, count);
		}

		return maxDegree;

	}

	public static void main(String[] args) {
		// String str = "*";
		// String str = "1*";
		// String str = "2*";
		// String str = "3*";
		String str = "**";
		// System.out.println(decodeWays(str));
		List<Integer> result = new ArrayList<>();
		result.add(83315);
		result.add(22089);
		result.add(19068);

		result.add(64911);

		result.add(67636);

		result.add(4640);

		result.add(98971);

		result.add(80192);

		encryptionValidity(9677958, 50058356, result);
	}
}
