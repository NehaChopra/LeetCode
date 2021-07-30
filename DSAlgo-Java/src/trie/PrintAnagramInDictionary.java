/**
 * https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
 * 
 * Given an array of words, print all anagrams together. For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.
 * 
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAnagramInDictionary {

	public static void main(String[] args) {
		TrieWF obj = new TrieWF();
		TrieNodeWF root = new TrieNodeWF();
		obj.root = root;
		String wordArr[] = { "cat", "dog", "tac", "god", "act", "gdo" };
		for (String word : wordArr) {
			String sortedCharWord = sortCharArr(word);
			obj.insert(sortedCharWord, word);
		}
		String searchWord = "cat";
		List<String> anagramList = obj.search(sortCharArr(searchWord));
		anagramList.forEach(word -> System.out.println(word));
	}

	public static String sortCharArr(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		String newWord = String.valueOf(charArray);
		return newWord;
	}
}

class TrieNodeWF {
	TrieNodeWF children[] = new TrieNodeWF[26];
	boolean endOfWord;
	List<String> stringList = null;

	TrieNodeWF() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		stringList = new ArrayList<String>();
	}
}

class TrieWF {
	TrieNodeWF root;

	public void insert(String key, String word) {
		TrieNodeWF cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNodeWF();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
		cwral.stringList.add(word);
	}

	public List<String> search(String key) {
		TrieNodeWF cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				return null;
			}
			cwral = cwral.children[elementIndex];
		}
		if (cwral != null && cwral.endOfWord) {
			return cwral.stringList;
		}
		return null;
	}
}