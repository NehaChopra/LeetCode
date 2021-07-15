package trie;

import java.util.LinkedList;
import java.util.List;

class TrieNodeK {
	int MAX_LENGTH = 256;
	TrieNodeK[] children = new TrieNodeK[MAX_LENGTH];
	List<Integer> indexes = new LinkedList<Integer>();
	boolean endOfWord;

	TrieNodeK() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
		indexes = new LinkedList<Integer>();
	}
}

class TrieK {
	TrieNodeK root;

	public void insert(TrieNodeK root, String key, int index) {
		root.indexes.add(index);
		if (key.length() > 0) {
			char cindex = key.charAt(0);

			if (root.children[cindex] == null) {
				root.children[cindex] = new TrieNodeK();
			}

			insert(root.children[cindex], key.substring(1, key.length()), index + 1);
		}
	}

	public List<Integer> search(TrieNodeK root, String key) {
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
	static TrieK trie;

	public static void main(String[] args) {
		PatternSearching obj = new PatternSearching();
		obj.trie = new TrieK();
		TrieNodeK root = new TrieNodeK();
		trie.root = root;

		String str = "geeksforgeeks.org";
		insertSuffix(trie, str);
		String pattern = "ee";
		searchSuffix(trie, pattern);
	}

	public static void insertSuffix(TrieK trie, String str) {
		for (int index = 0; index < str.length(); index++) {
			trie.insert(trie.root, str.substring(index, str.length()), index);
		}
	}

	public static void searchSuffix(TrieK trie, String str) {
		List<Integer> indexes = trie.search(trie.root, str);
		if (indexes == null) {

		} else {
			indexes.stream().forEach(index -> System.out.println(index - str.length()));
		}
	}
}