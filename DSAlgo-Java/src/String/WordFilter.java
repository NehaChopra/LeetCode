//https://leetcode.com/problems/prefix-and-suffix-search/
/*
 * 
 * ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
[[["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]

 */
package String;

public class WordFilter {

	public static class TrieNode {
		private TrieNode[] children;
		private int weight;
		private boolean endOfWord;;

		TrieNode() {
			children =  new TrieNode[27];
			weight = 0;
			endOfWord = false;
		}

	}

	private TrieNode trie;
	private String seperator = "{";

	public WordFilter(String[] words) {
        trie = new TrieNode();
		for (int index = 0; index < words.length; index++) {
			String word = words[index] + seperator;
			for (int jIndex = 0; jIndex < word.length(); jIndex++) {
				TrieNode currentNode = trie;
				currentNode.weight = index;
				for (int kIndex = jIndex; kIndex < 2 * word.length() - 1; kIndex++) {
					int elementNode = (word.charAt(kIndex % word.length()) - 'a');
					if (currentNode.children[elementNode] == null) {
						currentNode.children[elementNode] = new TrieNode();
                        
					}	
					currentNode = currentNode.children[elementNode];
                    currentNode.weight = index;
				}
			}
		}
	}

	public int f(String prefix, String suffix) {
		TrieNode currentNode = trie;
		String word = suffix + seperator + prefix;
		for (char ch : word.toCharArray()) {
			int elementNode = (ch - 'a');
			if(currentNode.children[elementNode] == null) {
				return -1;
			}
			currentNode = currentNode.children[elementNode];
		}
		return currentNode.weight;
	}

	public static void main(String[] args) {
		String[] input = { "apple" };
		WordFilter wordFilter = new WordFilter(input);
		System.out.println(wordFilter.f("a", "e"));
	}
}
