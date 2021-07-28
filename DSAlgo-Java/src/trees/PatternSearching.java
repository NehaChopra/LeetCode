/*
 * https://www.geeksforgeeks.org/pattern-searching-using-suffix-tree/
 * 
 * https://www.geeksforgeeks.org/pattern-searching-using-suffix-tree/
 * 
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

Preprocess Pattern or Preoprocess Text?
We have discussed the following algorithms in the previous posts:

KMP Algorithm
Rabin Karp Algorithm
Finite Automata based Algorithm
Boyer Moore Algorithm

All of the above algorithms preprocess the pattern to make the pattern searching faster. The best time complexity that we could get by preprocessing pattern is O(n) where n is length of the text. In this post, we will discuss an approach that preprocesses the text. A suffix tree is built of the text. After preprocessing text (building suffix tree of text), we can search any pattern in O(m) time where m is length of the pattern.
Imagine you have stored complete work of William Shakespeare and preprocessed it. You can search any string in the complete work in time just proportional to length of the pattern. This is really a great improvement because length of pattern is generally much smaller than text.
Preprocessing of text may become costly if the text changes frequently. It is good for fixed text or less frequently changing text though.

A Suffix Tree for a given text is a compressed trie for all suffixes of the given text. We have discussed Standard Trie. Let us understand Compressed Trie with the following array of words.



{bear, bell, bid, bull, buy, sell, stock, stop}


1) Starting from the first character of the pattern and root of Suffix Tree, do following for every character.
…..a) For the current character of pattern, if there is an edge from the current node of suffix tree, follow the edge.
…..b) If there is no edge, print “pattern doesn’t exist in text” and return.
2) If all characters of pattern have been processed, i.e., there is a path from root for characters of the given pattern, then print “Pattern found”.

 */

package trie;

import java.util.LinkedList;
import java.util.List;

class TrieNode {
	int MAX_LENGTH = 256;
	TrieNode[] children = new TrieNode[MAX_LENGTH];
	List<Integer> indexes = new LinkedList<Integer>();
	boolean endOfWord;

	TrieNode() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		indexes = new LinkedList<Integer>();
	}
}

class Trie {
	TrieNode root;

	public void insert(TrieNode root, String key, int index) {
		root.indexes.add(index);
		if (key.length() > 0) {
			char cindex = key.charAt(0);

			if (root.children[cindex] == null) {
				root.children[cindex] = new TrieNode();
			}

			insert(root.children[cindex], key.substring(1, key.length()), index + 1);
		}
	}

	public List<Integer> search(TrieNode root, String key) {
		if (key.length() == 0) {
			return root.indexes;
		}
		char cindex = key.charAt(0);

		if (root.children[cindex] == null) {
			return null;
		} else {
			return search(root.children[cindex], key.substring(1, key.length()));
		}

	}
}

public class PatternSearching {
	static Trie trie;

	public static void main(String[] args) {
		PatternSearching obj = new PatternSearching();
		obj.trie = new Trie();
		TrieNode root = new TrieNode();
		trie.root = root;

		String str = "geeksforgeeks.org";
		insertSuffix(trie, str);
		String pattern = "ee";
		searchSuffix(trie, pattern);
	}

	public static void insertSuffix(Trie trie, String str) {
		for (int index = 0; index < str.length(); index++) {
			trie.insert(trie.root, str.substring(index, str.length()), index);
		}
	}

	public static void searchSuffix(Trie trie, String str) {
		List<Integer> indexes = trie.search(trie.root, str);
		if (indexes == null) {

		} else {
			indexes.stream().forEach(index -> System.out.println(index - str.length()));
		}
	}
}