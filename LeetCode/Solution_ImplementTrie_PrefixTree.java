
public class Solution_ImplementTrie_PrefixTree {

	public static class TrieNode {
		boolean isEndofWords;
		TrieNode[] children;
		int ALPHABET_SIZE = 26;

		public TrieNode() {
			this.isEndofWords = false;

			children = new TrieNode[this.ALPHABET_SIZE];
		}
	}

	public static class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			char[] ch = word.toCharArray();
			TrieNode temp = root;

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			char[] ch = word.toCharArray();
			TrieNode temp = root;

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					return false;

				temp = temp.children[idx];
			}

			return temp.isEndofWords && temp != null;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			char[] ch = prefix.toCharArray();
			TrieNode temp = root;

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					return false;

				temp = temp.children[idx];
			}

			return temp != null;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}

}
