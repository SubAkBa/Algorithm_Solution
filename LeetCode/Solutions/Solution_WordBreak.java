import java.util.*;

public class Solution_WordBreak {
//	public static boolean wordBreak(String s, List<String> wordDict) {
//		int slen = s.length();
//		boolean[] existed = new boolean[slen + 1];
//		HashSet<String> word_set = new HashSet<>();
//
//		word_set.addAll(wordDict);
//
//		existed[0] = true;
//		for (int i = 1; i <= slen; ++i) {
//			for (int j = 0; j < i; ++j) {
//				if (existed[j] && word_set.contains(s.substring(j, i))) {
//					existed[i] = true;
//					break;
//				}
//			}
//		}
//
//		return existed[slen];
//	}

	static int slen;
	static Trie trie;

	public static boolean Find(TrieNode current, String s, int idx, boolean[] visited) {
		if (idx == slen)
			return current.isEndofWord;

		TrieNode temp = current.children[s.charAt(idx) - 'a'];

		if (temp == null)
			return false;

		if (temp.isEndofWord && !visited[idx]) {
			visited[idx] = true;
			return Find(trie.root, s, idx + 1, visited) || Find(temp, s, idx + 1, visited);
		}

		return Find(temp, s, idx + 1, visited);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		int word_count = wordDict.size();
		slen = s.length();
		trie = new Trie();

		for (int i = 0; i < word_count; ++i)
			trie.Insert(wordDict.get(i));

		return Find(trie.root, s, 0, new boolean[slen]);
	}

	public static class TrieNode {
		TrieNode[] children;
		int ALPHABET_SIZE = 26;
		boolean isEndofWord;

		public TrieNode() {
			this.children = new TrieNode[this.ALPHABET_SIZE];
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void Insert(String word) {
			TrieNode temp = this.root;
			char[] w = word.toCharArray();
			int wlen = w.length;

			for (int i = 0; i < wlen; ++i) {
				int idx = w[i] - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWord = true;
		}
	}

	public static void main(String[] args) {
		List<String> test = new ArrayList<>();
		test.add("leet");
		test.add("code");
		System.out.println(wordBreak("leetcode", test));
	}

}
