import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9202 {
	static int N = 4, SIZE = 26;
	static int score, count, boardId;
	static String longestWord;
	static boolean[][] visited;
	static char[][] map;
	static char[] wordCharArray;
	static int[] scores = new int[]{0, 0, 1, 1, 2, 3, 5, 11};
	static int[][] pos = new int[][]{{0, 1, 1, 1, 0, -1, -1, -1}, {1, 1, 0, -1, -1, -1, 0, 1}};
	static Trie trie;

	public static class Node {
		int wordIdx, stamped;
		Node[] children;

		public Node() {
			this.wordIdx = -1;
			this.stamped = -1;
			this.children = new Node[SIZE];
		}
	}

	public static class Trie {
		Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String word, int wordIdx) {
			Node current = root;

			for (int i = 0; i < word.length(); ++i) {
				int idx = word.charAt(i) - 'A';

				if (current.children[idx] == null) {
					current.children[idx] = new Node();
				}

				current = current.children[idx];
			}

			current.wordIdx = wordIdx;
		}
	}

	public static boolean isNewLongestWord(String wordPart) {
		return longestWord.length() < wordPart.length()
			|| (longestWord.length() == wordPart.length() && longestWord.compareTo(wordPart) > 0);
	}

	public static void dfs(int x, int y, int charIdx, Node current) {
		if (current.wordIdx != -1 && current.stamped != boardId) {
			current.stamped = boardId;
			++count;
			score += scores[charIdx];

			String newWord = new String(wordCharArray, 0, charIdx + 1);
			if (isNewLongestWord(newWord)) {
				longestWord = newWord;
			}
		}

		if (charIdx == 8) {
			return;
		}

		for (int k = 0; k < 8; ++k) {
			int nx = x + pos[0][k];
			int ny = y + pos[1][k];

			if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
				continue;
			}

			if (visited[nx][ny]) {
				continue;
			}

			int idx = map[nx][ny] - 'A';
			if (current.children[idx] == null) {
				continue;
			}

			visited[nx][ny] = true;
			wordCharArray[charIdx + 1] = map[nx][ny];
			dfs(nx, ny, charIdx + 1, current.children[idx]);
			visited[nx][ny] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int w = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		trie = new Trie();

		for (int i = 0; i < w; ++i) {
			trie.insert(br.readLine(), i);
		}

		br.readLine();

		int b = Integer.parseInt(br.readLine());
		for (int i = 0; i < b; ++i) {
			visited = new boolean[N][N];
			map = new char[N][N];
			wordCharArray = new char[8];
			score = 0;
			count = 0;
			boardId = i;
			longestWord = "";

			for (int j = 0; j < 4;++j) {
				map[j] = br.readLine().toCharArray();
			}

			for (int x = 0; x < N; ++x) {
				for (int y = 0; y < N; ++y) {
					int idx = map[x][y] - 'A';

					if (trie.root.children[idx] != null) {
						visited[x][y] = true;
						wordCharArray[0] = map[x][y];
						dfs(x, y, 0, trie.root.children[idx]);
						visited[x][y] = false;
					}
				}
			}

			sb.append(score + " " + longestWord + " " + count + "\n");

			if (i != b - 1) {
				br.readLine();
			}
		}

		System.out.println(sb);
	}
}
