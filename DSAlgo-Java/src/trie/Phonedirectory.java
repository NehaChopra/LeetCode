package trie;

/**
 * https://www.geeksforgeeks.org/implement-a-phone-directory/
 * 
 * Implement a Phone Directory Difficulty Level : Hard Last Updated : 03 Jan,
 * 2020 Given a list of contacts which exist in a phone directory. The task is
 * to implement search query for the phone directory. The search query on a
 * string ‘str’ displays all the contacts which prefix as ‘str’. One special
 * property of the search function is that, when a user searches for a contact
 * from the contact list then suggestions (Contacts with prefix as the string
 * entered so for) are shown after user enters each character.
 * 
 * Note : Contacts in the list consist of only lower case alphabets.
 * 
 * Example:
 * 
 * Input : contacts [] = {“gforgeeks” , “geeksquiz” } Query String = “gekk”
 * 
 * Output : Suggestions based on "g" are geeksquiz gforgeeks
 * 
 * Suggestions based on "ge" are geeksquiz
 * 
 * No Results Found for "gek"
 * 
 * No Results Found for "gekk"
 *
 */
class TrieNodeL {
	boolean isEndOfWord;
	TrieNodeL children[] = new TrieNodeL[26];

	TrieNodeL() {
		this.isEndOfWord = false;
		for (int index = 0; index < 26; index++) {
			this.children[index] = null;
		}
	}
}

class TrieL {
	TrieNodeL root;

	public void insert(String key) {
		TrieNodeL node_crawler = root;
		for (int index = 0; index < key.length(); index++) {
			int element_index = key.charAt(index) - 'a';
			if (node_crawler.children[element_index] == null) {
				node_crawler.children[element_index] = new TrieNodeL();
			}
			node_crawler = node_crawler.children[element_index];
		}
		node_crawler.isEndOfWord = true;
	}

	public boolean search(String key) {
		TrieNodeL node_crawler = root;
		for (int index = 0; index < key.length(); index++) {
			int element_index = key.charAt(index) - 'a';
			if (node_crawler.children[element_index] == null) {
				return false;
			}
			node_crawler = node_crawler.children[element_index];
		}
		return ((node_crawler != null) && (node_crawler.isEndOfWord));
	}

	public void printAutoSuggestList(String key) {
		TrieNodeL node_crawler = root;
		for (int index = 0; index < key.length(); index++) {
			int element_index = key.charAt(index) - 'a';
			if (node_crawler.children[element_index] != null) {
				node_crawler = node_crawler.children[element_index];
			} else {
				return;
			}
		}
		if (node_crawler.isEndOfWord && lastNode(node_crawler)) {
			System.out.println(key);
		} else if (node_crawler != null && !lastNode(node_crawler)) {
			suggestRecords(node_crawler, key);
		}
	}

	public static void suggestRecords(TrieNodeL root, String key) {
		if (root.isEndOfWord) {
			System.out.println(key);
		}
		if (lastNode(root)) {
			return;
		}
		for (int index = 0; index < 26; index++) {
			if (root.children[index] != null) {
				suggestRecords(root.children[index], key + String.valueOf((char) ('a' + index)));
			}
		}
	}

	public static boolean lastNode(TrieNodeL root) {
		for (int index = 0; index < 26; index++) {
			if (root.children[index] != null) {
				return false;
			}
		}
		return true;
	}
}

public class Phonedirectory {
	public static void main(String[] args) {
		TrieNodeL root = new TrieNodeL();
		TrieL obj = new TrieL();
		obj.root = root;
		obj.insert("gforgeeks");
		obj.insert("geeksquiz");

		obj.printAutoSuggestList("g");

		System.out.println("==========================================================");
		obj.printAutoSuggestList("ge");
		//
		// System.out.println("==========================================================");
		obj.printAutoSuggestList("gek");

		System.out.println("==========================================================");
		obj.printAutoSuggestList("gekk");
	}
}