import java.util.*;

public class Solution_단어퍼즐 {
	static int size = 26, count;

	public static void Search(String s, Trie trie, TrieNode current, int idx, int cur_count, int[] counts) {
		if (idx == -1) {
			if (current.isEndofWords)
				count = Math.min(count, cur_count);
			return;
		}

		if (count <= cur_count)
			return;

		int cidx = s.charAt(idx) - 'a';

		if (current.children[cidx] == null)
			return;

		Search(s, trie, current.children[cidx], idx - 1, cur_count, counts);

		if (counts[idx] > cur_count && current.children[cidx].isEndofWords) {
			counts[idx] = cur_count;
			Search(s, trie, trie.root, idx - 1, cur_count + 1, counts);
		}
	}

	public static int solution(String[] strs, String t) {
		count = Integer.MAX_VALUE;

		Trie trie = new Trie();
		int slen = strs.length, len = t.length(), INF = 987654321;
		int[] counts = new int[len];

		Arrays.fill(counts, INF);

		for (int i = 0; i < slen; ++i)
			trie.Insert(strs[i]);

		Search(t, trie, trie.root, len - 1, 1, counts);

		return count == Integer.MAX_VALUE ? -1 : count;
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
			int len = str.length();
			TrieNode temp = this.root;

			for (int i = len - 1; i >= 0; --i) {
				int idx = str.charAt(i) - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "ba", "na", "n", "a" }, "banana")); // 3
		System.out.println(solution(new String[] { "app", "ap", "p", "l", "e", "ple", "pp" }, "apple")); // 2
		System.out.println(solution(new String[] { "ba", "an", "nan", "ban", "n" }, "banana")); // -1
	}
}
