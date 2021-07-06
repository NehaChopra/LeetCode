/*
 * https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
 * 
 * Input: arr[] = {"zebra", "dog", "duck", "dove"}
Output: dog, dov, du, z
Explanation: dog => dog
             dove = dov 
             duck = du
             z   => zebra 

Input: arr[] =  {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
Output: geeksf, geeksg, geeksq}
 
 */
package trie;

import java.util.Arrays;

class TrieNodeZ {
	boolean isEndOfWord;
	int frequency;
	TrieNodeZ children[] = new TrieNodeZ[26];

	TrieNodeZ() {
		this.isEndOfWord = false;
		this.frequency = 1;
		for (int index = 0; index < 26; index++) {
			this.children[index] = null;
		}
	}
}

class TrieZ {
	TrieNodeZ root;

	public void insert(String key) {
		TrieNodeZ node_crawler = root;
		for (int index = 0; index < key.length(); index++) {
			int element_index = key.charAt(index) - 'a';
			if (node_crawler.children[element_index] == null) {
				node_crawler.children[element_index] = new TrieNodeZ();
			} else {
				node_crawler.children[element_index].frequency = node_crawler.children[element_index].frequency + 1;
			}
			node_crawler = node_crawler.children[element_index];
		}
		node_crawler.isEndOfWord = true;
	}

	public void shortUniquePrefixes(String[] keys) {
		Arrays.sort(keys);// sorted
		for (int kindex = 0; kindex < keys.length; kindex++) {
			insert(keys[kindex]);
		}
	}

	public boolean search(String key) {
		TrieNodeZ node_crawler = root;
		for (int index = 0; index < key.length(); index++) {
			int element_index = key.charAt(index) - 'a';
			if (node_crawler.children[element_index] == null) {
				return false;
			}
			node_crawler = node_crawler.children[element_index];
		}
		return ((node_crawler != null) && (node_crawler.isEndOfWord));
	}

	public void traverse(TrieNodeZ root, char[] prefixes, int index) {
		TrieNodeZ node_crawler = root;
		if (node_crawler == null) {
			return;
		}

		String output = String.valueOf(prefixes).trim();
		if (node_crawler.frequency == 1 && output.length() > 0) {
			output = output.substring(0, index);
			System.out.println(output);
			return;
		}

		for (int kindex = 0; kindex < 26; kindex++) {
			if (node_crawler.children[kindex] != null) {
				prefixes[index] = ((char) (kindex + 'a'));
				traverse(root.children[kindex], prefixes, index + 1);
			}
		}

	}
}

public class ShortestUniquePrefix {
	public static void main(String[] args) {
		TrieNodeZ root = new TrieNodeZ();
		TrieZ obj = new TrieZ();
		obj.root = root;
		String[] keys = { "zebra", "dog", "duck", "dove" };
		obj.shortUniquePrefixes(keys);
		obj.traverse(obj.root, new char[256], 0);
	}
}
