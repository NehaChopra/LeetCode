/*
 * 	https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * Below are the permutations of string ABC. 
ABC ACB BAC BCA CBA CAB
 */

package Arrays;

public class PermuteString {
	public static void main(String[] args) {
		String input = "ABC";
		permute(input, 0, input.length());
	}

	public static void permute(String input, int start, int end) {
		if (start == end) {
			System.out.println(input);
		} else {
			for (int index = start; index < end; index++) {
				input = swap(input, start, index);
				permute(input, start + 1, end);
				input = swap(input, start, index);
			}
		}

	}

	public static String swap(String input, int x, int y) {
		char[] arr = input.toCharArray();
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return String.valueOf(arr);
	}
}
