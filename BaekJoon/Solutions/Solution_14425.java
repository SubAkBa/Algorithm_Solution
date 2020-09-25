import java.util.*;
import java.io.*;

public class Solution_14425 {
//	static int size = 26;
//
//	public static class TrieNode {
//		TrieNode[] children;
//		boolean isEndofWords;
//
//		public TrieNode() {
//			this.children = new TrieNode[size];
//			this.isEndofWords = false;
//		}
//	}
//
//	public static class Trie {
//		TrieNode root;
//
//		public Trie() {
//			this.root = new TrieNode();
//		}
//
//		public void Insert(String str) {
//			TrieNode temp = this.root;
//
//			int len = str.length();
//
//			for (int i = 0; i < len; ++i) {
//				int idx = str.charAt(i) - 'a';
//
//				if (temp.children[idx] == null)
//					temp.children[idx] = new TrieNode();
//
//				temp = temp.children[idx];
//			}
//
//			temp.isEndofWords = true;
//		}
//
//		public boolean Search(String str) {
//			TrieNode temp = this.root;
//
//			int len = str.length();
//
//			for (int i = 0; i < len; ++i) {
//				int idx = str.charAt(i) - 'a';
//
//				if (temp.children[idx] == null)
//					return false;
//
//				temp = temp.children[idx];
//			}
//
//			return temp.isEndofWords && temp != null;
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;

//		Trie trie = new Trie();
//
//		for (int i = 0; i < N; ++i)
//			trie.Insert(br.readLine());
//
//		for (int i = 0; i < M; ++i) {
//			if (trie.Search(br.readLine()))
//				++count;
//		}

		Set<String> cache = new HashSet<>();

		for (int i = 0; i < N; ++i)
			cache.add(br.readLine());

		for (int i = 0; i < M; ++i) {
			if (cache.contains(br.readLine()))
				++count;
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
