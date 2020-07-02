
public class Solution_AddandSearchWord_Datastructuredesign {
	static int ALPHABET_SIZE = 26;

	public static class TrieNode {
		TrieNode[] children;
		boolean isEndofWord;

		public TrieNode() {
			this.children = new TrieNode[ALPHABET_SIZE];
			this.isEndofWord = false;
		}
	}

	public static class WordDictionary {
		TrieNode root;

		/** Initialize your data structure here. */
		public WordDictionary() {
			this.root = new TrieNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			TrieNode temp = this.root;
			char[] ch = word.toCharArray();

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWord = true;
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(String word) {
			return Searching(word.toCharArray(), 0, this.root);
		}

		public boolean Searching(char[] ch, int idx, TrieNode curNode) {
			if (idx == ch.length)
				return curNode.isEndofWord;

			if (ch[idx] != '.')
				return curNode.children[ch[idx] - 'a'] != null
						&& Searching(ch, idx + 1, curNode.children[ch[idx] - 'a']);

			if (ch[idx] == '.') {
				for (int i = 0; i < ALPHABET_SIZE; i++) {
					if (curNode.children[i] != null) {
						if (Searching(ch, idx + 1, curNode.children[i]))
							return true;
					}
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();

		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");

		System.out.println(obj.search("pad")); // false
		System.out.println(obj.search("bad")); // true
		System.out.println(obj.search(".ad")); // true
		System.out.println(obj.search("b..")); // true
	}
}
