import java.util.*;

public class Solution_ConcatenatedWords {

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> answer = new ArrayList<>();

		Trie trie = new Trie();

		for (String word : words) {
			if (word.length() == 0)
				continue;

			trie.Insert(word);
		}

		for (String word : words) {
			if (word.length() > 0 && trie.isConcatWords(word, 0, 0))
				answer.add(word);
		}

		return answer;
	}

	public static class TrieNode {
		int ALPHABET_SIZE = 26;
		boolean isEndofWords;
		TrieNode[] children;

		public TrieNode() {
			this.isEndofWords = false;
			this.children = new TrieNode[ALPHABET_SIZE];
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void Insert(String str) {
			TrieNode temp = root;
			char[] ch = str.toCharArray();

			for (char c : ch) {
				if (temp.children[c - 'a'] == null)
					temp.children[c - 'a'] = new TrieNode();

				temp = temp.children[c - 'a'];
			}

			temp.isEndofWords = true;
		}

		public boolean isConcatWords(String str, int idx, int countwords) {
			if (idx == str.length())
				return countwords >= 2;

			TrieNode temp = root;

			for (int i = idx; i < str.length(); i++) {
				char c = str.charAt(i);

				if (temp.children[c - 'a'] == null)
					return false;

				temp = temp.children[c - 'a'];

				if (temp.isEndofWords) {
					if (isConcatWords(str, i + 1, countwords + 1))
						return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog",
				"dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "a", "b", "ab", "abc" })); // ab
	}

}
