import java.util.*;

public class Solution_WordSearchII {
	static int row, col;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static HashSet<String> set;

	public static class TrieNode {
		int ALPHABET_SIZE = 26;
		boolean isEndofWords;
		TrieNode[] children;

		public TrieNode() {
			this.isEndofWords = false;
			this.children = new TrieNode[this.ALPHABET_SIZE];
		}
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void Insert(String str) {
			char[] ch = str.toCharArray();
			TrieNode temp = root;

			for (char c : ch) {
				int idx = c - 'a';

				if (temp.children[idx] == null)
					temp.children[idx] = new TrieNode();

				temp = temp.children[idx];
			}

			temp.isEndofWords = true;
		}
	}

	public static void DFS(char[][] board, boolean[][] visited, TrieNode temp, StringBuilder sb, int cx, int cy) {
		if (temp.isEndofWords)
			set.add(sb.toString());

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
				continue;

			if (visited[nx][ny])
				continue;

			TrieNode tempnode = temp.children[board[nx][ny] - 'a'];

			if (tempnode == null)
				continue;

			sb.append(board[nx][ny]);
			visited[nx][ny] = true;

			DFS(board, visited, tempnode, sb, nx, ny);

			sb.deleteCharAt(sb.length() - 1);
			visited[nx][ny] = false;
		}
	}

	public static List<String> findWords(char[][] board, String[] words) {
		row = board.length;
		col = board[0].length;
		set = new HashSet<>();

		Trie trie = new Trie();
		int wlen = words.length;

		for (int i = 0; i < wlen; i++)
			trie.Insert(words[i]);

		boolean[][] visited = new boolean[row][col];
		StringBuilder sb = new StringBuilder();
		TrieNode root = trie.root;

		for (int i = 0; i < row * col; i++) {
			int x = i / col;
			int y = i % col;
			TrieNode temp = root.children[board[x][y] - 'a'];

			if (temp != null) {
				for (int j = 0; j < row; j++)
					Arrays.fill(visited[j], false);

				sb.setLength(0);
				visited[x][y] = true;
				sb.append(board[x][y]);
				DFS(board, visited, temp, sb, x, y);
			}
		}

		List<String> result = new ArrayList<>();
		result.addAll(set);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
		System.out.println(findWords(new char[][] { { 'a', 'a' } }, new String[] { "a" }));
		System.out.println(findWords(new char[][] { { 'a', 'b' }, { 'a', 'a' } },
				new String[] { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" }));
		System.out.println(
				findWords(new char[][] { { 'a', 'b' }, { 'a', 'a' } }, new String[] { "aaab", "aaaa", "aaba" }));
	}

}
