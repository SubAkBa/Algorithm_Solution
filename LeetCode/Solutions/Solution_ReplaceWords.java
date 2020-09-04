import java.util.*;

public class Solution_ReplaceWords {
	static int size = 26;

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

		public String SearchRoot(String str) {
			TrieNode temp = this.root;
			int len = str.length();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < len; ++i) {
				int idx = str.charAt(i) - 'a';

				if (temp.children[idx] == null)
					return "";

				sb.append(str.charAt(i));
				
				if (temp.children[idx].isEndofWords)
					return sb.toString();

				temp = temp.children[idx];
			}

			return sb.toString();
		}
	}

	public static String replaceWords(List<String> dictionary, String sentence) {
		Trie trie = new Trie();

		for (String dict : dictionary)
			trie.Insert(dict);

		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		int wcounts = words.length;

		for (int i = 0; i < wcounts; ++i) {
			String result = trie.SearchRoot(words[i]);

			if (result.equals(""))
				sb.append(words[i] + " ");
			else
				sb.append(result + " ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("cat");
		list.add("bat");
		list.add("rat");
		System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
		// "the cat was rat by the bat"

		list.clear();

		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(replaceWords(list, "aadsfasf absbs bbab cadsfafs"));
		// "a a b c"
		
		list.clear();

		list.add("a");
		list.add("aa");
		list.add("aaa");
		list.add("aaaa");
		System.out.println(replaceWords(list, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
		// "a a a a a a a a bbb baba a"

		list.clear();

		list.add("catt");
		list.add("cat");
		list.add("bat");
		list.add("rat");
		System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
		// "the cat was rat by the bat"

		list.clear();

		list.add("ac");
		list.add("ab");
		System.out.println(replaceWords(list, "it is abnormal that this solution is accepted"));
		// "it is ab that this solution is ac"
	}
}
