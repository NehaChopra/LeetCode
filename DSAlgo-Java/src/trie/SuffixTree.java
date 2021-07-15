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

public class SuffixTree {
	static Trie trie;

	public static void main(String[] args) {
		SuffixTree obj = new SuffixTree();
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