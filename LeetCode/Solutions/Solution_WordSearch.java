
public class Solution_WordSearch {

	public static boolean DFS(char[][] board, String word, int len, int N, int M, int idx, int x, int y) {
		if (idx == len)
			return true;

		if (!(0 <= x && x < N && 0 <= y && y < M))
			return false;

		if (word.charAt(idx) != board[x][y])
			return false;

		char c = board[x][y];

		board[x][y] = '.';

		boolean result = DFS(board, word, len, N, M, idx + 1, x + 1, y)
				|| DFS(board, word, len, N, M, idx + 1, x - 1, y) || DFS(board, word, len, N, M, idx + 1, x, y - 1)
				|| DFS(board, word, len, N, M, idx + 1, x, y + 1);

		board[x][y] = c;

		return result;
	}

	public static boolean exist(char[][] board, String word) {
		int N = board.length, M = board[0].length;
		int len = word.length();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (word.charAt(0) == board[i][j] && DFS(board, word, len, N, M, 0, i, j))
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED")); // true
		System.out.println(
				exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE")); // true
		System.out.println(
				exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB")); // false
		System.out.println(exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCESEEEFS")); // true
	}
}