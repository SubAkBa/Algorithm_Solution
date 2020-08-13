
public class Solution_자동완성 {
	static int SIZE = 26;

	public static class TrieNode {
		boolean isEndofWords;
		TrieNode[] children;
		int child_count;

		public TrieNode() {
			this.children = new TrieNode[SIZE];
			this.child_count = 0;
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void Insert(String word) {
			TrieNode temp = this.root;
			char[] ch = word.toCharArray();

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				++temp.children[idx].child_count;
				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}

		public int GetWordCount(String word) {
			TrieNode temp = this.root;
			char[] ch = word.toCharArray();
			int count = 0;

			for (char c : ch) {
				int idx = c - 'a';
				++count;

				if (temp.children[idx] == null)
					return count - 1;

				if (temp.children[idx].child_count == 1)
					return count;

				temp = temp.children[idx];
			}

			return count;
		}
	}

	public static int solution(String[] words) {
		int answer = 0;
		int word_count = words.length;

		Trie trie = new Trie();

		for (int i = 0; i < word_count; ++i)
			trie.Insert(words[i]);

		for (int i = 0; i < word_count; ++i)
			answer += trie.GetWordCount(words[i]);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "go", "gone", "guild" })); // 7
		System.out.println(solution(new String[] { "abc", "def", "ghi", "jklm" })); // 4
		System.out.println(solution(new String[] { "word", "war", "warrior", "world" })); // 15
	}
}
