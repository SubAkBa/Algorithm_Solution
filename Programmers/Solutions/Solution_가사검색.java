import java.util.*;

public class Solution_가사검색 {
	static int size = 26;

	public static class TrieNode {
		TrieNode[] children;
		boolean isEndofWords;
		int count;

		public TrieNode() {
			this.children = new TrieNode[size];
			this.count = 0;
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void Insert(String str) {
			TrieNode temp = root;
			int len = str.length();

			for (int i = 0; i < len; ++i) {
				int idx = str.charAt(i) - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				++temp.count;
				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}

		public int Search(String str) {
			TrieNode temp = root;
			int len = str.length();

			for (int i = 0; i < len; ++i) {
				int idx = str.charAt(i) - 'a';

				if (str.charAt(i) == '?')
					return temp.count;

				if (temp.children[idx] == null)
					return 0;

				temp = temp.children[idx];
			}

			return temp.count;
		}
	}

	public static int[] solution(String[] words, String[] queries) {
		int wordcount = words.length;

		int tlen = 10001;
		Trie[] trie = new Trie[tlen];
		Trie[] rev_trie = new Trie[tlen];

		for (int i = 1; i < tlen; ++i) {
			trie[i] = new Trie();
			rev_trie[i] = new Trie();
		}

		for (int i = 0; i < wordcount; ++i) {
			int wlen = words[i].length();

			trie[wlen].Insert(words[i]);
			rev_trie[wlen].Insert(Reverse(words[i]));
		}

		Map<String, Integer> map = new HashMap<>();
		int qcount = queries.length;
		int[] answer = new int[qcount];

		for (int i = 0; i < qcount; ++i) {
			if (map.containsKey(queries[i])) {
				answer[i] = map.get(queries[i]);
				continue;
			}

			int qlen = queries[i].length();

			if (queries[i].charAt(0) == '?')
				answer[i] = rev_trie[qlen].Search(Reverse(queries[i]));
			else
				answer[i] = trie[qlen].Search(queries[i]);

			map.put(queries[i], answer[i]);
		}

		return answer;
	}

	public static String Reverse(String str) {
		char[] ch = str.toCharArray();
		int len = str.length();

		for (int i = 0; i < len / 2; ++i) {
			char temp = ch[i];
			ch[i] = ch[len - i - 1];
			ch[len - i - 1] = temp;
		}

		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(solution(new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
						new String[] { "fro??", "????o", "fr???", "fro???", "pro?", "?????" })));
	}
}
