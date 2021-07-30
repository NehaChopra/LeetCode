/**
 * https://www.geeksforgeeks.org/word-formation-using-concatenation-of-two-dictionary-words/
 * 
 * Given a dictionary find out if given word can be made by two words in the dictionary. 
Note: Words in the dictionary must be unique and the word to be formed should not be a repetition of same words that are present in the Trie.

Examples: 

Input : dictionary[] = {"news", "abcd", "tree", 
                              "geeks", "paper"}   
        word = "newspaper"
Output : Yes
We can form "newspaper" using "news" and "paper"

Input : dictionary[] = {"geeks", "code", "xyz", 
                           "forgeeks", "paper"}   
        word = "geeksforgeeks"
Output : Yes

Input : dictionary[] = {"geek", "code", "xyz", 
                           "forgeeks", "paper"}   
        word = "geeksforgeeks"
Output : No
 * 
 */
package trie;

import java.util.ArrayList;
import java.util.List;

public class WordFormationConcDictionary {

	public static void main(String[] args) {
		TrieLF obj = new TrieLF();
		TrieNodeLF root = new TrieNodeLF();
		obj.root = root;
		// String wordArr[] = { "news", "abcd", "tree", "geeks", "paper" };
		// String wordArr[] = { "geeks", "code", "xyz", "forgeeks", "paper" };
		String wordArr[] = { "geek", "code", "xyz", "forgeeks", "paper" };
		for (String word : wordArr) {
			obj.insert(word);
		}
		// String searchWord = "newspaper";
		// String searchWord = "geeksforgeeks";
		String searchWord = "geeksforgeeks";
		System.out.println(obj.search(searchWord, 0, searchWord.length(), true));
	}
}

class TrieNodeLF {
	TrieNodeLF children[] = new TrieNodeLF[26];
	boolean endOfWord;
	List<String> stringList = null;

	TrieNodeLF() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		stringList = new ArrayList<String>();
	}
}

class TrieLF {
	TrieNodeLF root;

	public void insert(String key) {
		TrieNodeLF cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNodeLF();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}

	public boolean search(String key, int jindex, int length, boolean isPresent) {
		TrieNodeLF cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				return false;
			}
			jindex++;
			cwral = cwral.children[elementIndex];
			if (cwral != null && cwral.endOfWord) {
				break;
			}
		}
		if (isPresent && jindex == length) {
			return true;
		}
		return isPresent && (cwral != null && cwral.endOfWord)
				&& search(key.substring(jindex, key.length()), jindex, length, true);
	}
}