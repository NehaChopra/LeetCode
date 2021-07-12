//http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
package trie;

class TrieNode {
	TrieNode children[] = new TrieNode[26];
	boolean endOfWord;

	TrieNode() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class Trie {
	TrieNode root;

	public void insert(String key) {
		TrieNode cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNode();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}

	public String search(String key) {
		StringBuffer finalString = new StringBuffer("");
		TrieNode cwral = root;
		for (int index = 0; index < key.length(); index++) {
			int elementIndex = key.charAt(index) - 'a';
			if (cwral.endOfWord) {
				finalString = new StringBuffer(key.substring(0, index));
			}
			if (cwral.children[elementIndex] == null) {
				break;
			}
			cwral = cwral.children[elementIndex];
		}
		return finalString.toString();
	}

	public static boolean lastNode(TrieNode root) {
		for (int index = 0; index < 26; index++) {
			if (root.children[index] != null) {
				return false;
			}
		}
		return true;
	}
}

class LongestPrefixMatching {
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		Trie obj = new Trie();
		obj.root = root;
		obj.insert("are");
		obj.insert("area");
		obj.insert("base");
		obj.insert("cat");
		obj.insert("cater");
		obj.insert("children");
		obj.insert("basement");

		System.out.println(obj.search("caterer"));
		System.out.println(obj.search("basemexy"));
		System.out.println(obj.search("child"));
	}
}
