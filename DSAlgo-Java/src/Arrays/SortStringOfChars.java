/*
 * 	https://www.geeksforgeeks.org/sort-string-characters/
	Input : bbccdefbbaa 
	Output : aabbbbccdef
	
	Input : geeksforgeeks
	Output : eeeefggkkorss
 */
package Arrays;

import java.util.Scanner;

public class SortStringOfChars {
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

	public static void main(String[] args) {
//		String input = "bbccdefbbaa";
		String input = "geeksforgeeks";
		String output = sortStringOfChars(input);
		System.out.println(output);
	}

	public static String sortStringOfChars(String input) {
		int[] inputArr = new int[input.length()];
		for (int index = 0; index < input.length(); index++) {
			inputArr[index] = input.charAt(index) - 'a';
		}
		heapSort(inputArr);
		StringBuilder output = new StringBuilder("");
		for (int index = 0; index < input.length(); index++) {
			output.append((char)(inputArr[index] + 'a'));
		}
		return output.toString();
	}
}
