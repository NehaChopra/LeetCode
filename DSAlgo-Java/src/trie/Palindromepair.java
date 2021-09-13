//https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
/*
 * 1
6
geekf geeks or keeg abc bc

	

1
6
abc xyxcba geekst or keeg bc
 */
package trie;

import java.util.ArrayList;
import java.util.List;

public class Palindromepair {

	public static void main(String[] args) {
	}
}

class TrieNodePP {
	TrieNodePP children[] = new TrieNodePP[26];
	boolean endOfWord;
	List<Integer> indexes = null;

	TrieNodePP() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		indexes = new ArrayList<Integer>();
	}
}

class TriePP {
	TrieNodePP root;

	public void insert(String key, int kindex) {
		TrieNodePP cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNodePP();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
		cwral.indexes.add(kindex);
	}

	public boolean search(String key) {
		TrieNodePP cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral != null && cwral.endOfWord);
	}

	public boolean contains(String key, int kindex) {
		TrieNodePP cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return true;
	}
}