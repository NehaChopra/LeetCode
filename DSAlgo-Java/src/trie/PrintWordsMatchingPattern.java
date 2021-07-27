/**
 * https://www.geeksforgeeks.org/print-words-matching-pattern-camelcase-notation-dictonary/
 * 
 * 
 * Given a dictionary of words where each word follows CamelCase notation, print all words in the dictionary that match with a given pattern consisting of uppercase characters only.
CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. Common examples include: “PowerPoint” and “WikiPedia”, “GeeksForGeeks”, “CodeBlocks”, etc.
Examples: 
 

Input: 
dict[] = ["Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", 
"HiTechWorld", "HiTechCity", "HiTechLab"]

For pattern "HT",
Output: ["HiTech", "HiTechWorld", "HiTechCity", "HiTechLab"]

For pattern "H",
Output: ["Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", 
    "HiTechWorld", "HiTechCity", "HiTechLab"]

For pattern "HTC",
Output: ["HiTechCity"]


Input: 
dict[] = ["WelcomeGeek","WelcomeToGeeksForGeeks", "GeeksForGeeks"]

For pattern "WTG",
Output: ["WelcomeToGeeksForGeeks"]

For pattern "GFG",
Output: [GeeksForGeeks]

For pattern "GG",
Output: No match found
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNodeMM {
	TrieNodeMM children[] = new TrieNodeMM[26];
	boolean endOfWord;
	List<String> words;

	TrieNodeMM() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		words = new ArrayList<String>();
	}
}

class TrieMM {
	TrieNodeMM root;

	public void insert(String key) {
		TrieNodeMM cwral = root;
		for (int index = 0; index < key.length(); index++) {
			if (Character.isLowerCase(key.charAt(index))) {
				continue;
			}
			int elementIndex = key.charAt(index) - 'A';
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNodeMM();
			}
			if (cwral.children[elementIndex].endOfWord) {
				cwral.children[elementIndex].words.add(key);
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
		cwral.words.add(key);
	}

	public List<String> search(String key) {
		TrieNodeMM cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'A';
			if (cwral.children[elementIndex] == null) {
				return null;
			}
			cwral = cwral.children[elementIndex];
		}
		return ((cwral != null && cwral.endOfWord) ? cwral.words : null);
	}
}

public class PrintWordsMatchingPattern {
	public static void main(String[] args) {
		TrieMM obj = new TrieMM();
		TrieNodeMM root = new TrieNodeMM();
		obj.root = root;

		List<String> dict = Arrays.asList("Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity",
				"HiTechLab");

		dict.stream().forEach(word -> obj.insert(word));
		// String pattern = "HT";
		String pattern = "H";
		List<String> words = obj.search(pattern);
		words.stream().forEach(word -> System.out.println(word));

	}
}
