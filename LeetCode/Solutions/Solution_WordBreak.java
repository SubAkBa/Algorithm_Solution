import java.util.*;

public class Solution_WordBreak {
	static int size = 26;

	public static boolean isConcatenated(String s, boolean[] visited, Trie trie, TrieNode current, int sidx, int len) {
		if (sidx == len)
			return current.isEndofWords;

		int cidx = s.charAt(sidx) - 'a';

		if (current.children[cidx] == null)
			return false;

		if (!visited[sidx] && current.children[cidx].isEndofWords) {
			visited[sidx] = true;
			return isConcatenated(s, visited, trie, current.children[cidx], sidx + 1, len)
					|| isConcatenated(s, visited, trie, trie.root, sidx + 1, len);
		}

		return isConcatenated(s, visited, trie, current.children[cidx], sidx + 1, len);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Trie trie = new Trie();
		int len = s.length();

		for (String word : wordDict)
			trie.Insert(word);

		return isConcatenated(s, new boolean[len], trie, trie.root, 0, len);
	}

	public static class TrieNode {
		TrieNode[] children;
		boolean isEndofWords;

		public TrieNode() {
			this.children = new TrieNode[size];
			this.isEndofWords = false;
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void Insert(String str) {
			TrieNode temp = this.root;
			int len = str.length();

			for (int i = 0; i < len; ++i) {
				int idx = str.charAt(i) - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("leet");
		list.add("code");
		System.out.println(wordBreak("leetcode", list)); // true

		list.clear();

		list.add("apple");
		list.add("pen");
		System.out.println(wordBreak("applepenapple", list)); // true

		list.clear();

		list.add("cats");
		list.add("dog");
		list.add("sand");
		list.add("and");
		list.add("cat");
		System.out.println(wordBreak("catsandog", list)); // false
	}
}
