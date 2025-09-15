import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14426 {

	public static class Node {
		Node[] children;

		public Node() {
			this.children = new Node[26];
		}
	}

	public static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public void insert(String str) {
			Node current = root;

			for (int i = 0; i < str.length(); ++i) {
				int idx = str.charAt(i) - 'a';

				if (current.children[idx] == null) {
					current.children[idx] = new Node();
				}

				current = current.children[idx];
			}
		}

		public boolean isPrefix(String str) {
			Node current = root;

			for (int i = 0; i < str.length(); ++i) {
				int idx = str.charAt(i) - 'a';

				if (current.children[idx] == null) {
					return false;
				}

				current = current.children[idx];
			}

			return current != null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();

		for (int i = 0; i < N; ++i) {
			trie.insert(br.readLine());
		}

		int count = 0;
		for (int i = 0; i < M; ++i) {
			if (trie.isPrefix(br.readLine())) {
				++count;
			}
		}

		System.out.println(count);
	}
}
