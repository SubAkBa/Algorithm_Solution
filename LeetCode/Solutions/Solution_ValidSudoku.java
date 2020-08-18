
public class Solution_ValidSudoku {
	static int N = 9;

	public boolean isValid9x1(char[][] board, int i) {
		int key = 0;

		for (int j = 0; j < N; ++j) {
			if (board[j][i] == '.')
				continue;

			if ((key & (1 << (board[j][i] - '0'))) != 0)
				return false;

			key |= 1 << (board[j][i] - '0');
		}

		return true;
	}

	public boolean isValid1x9(char[][] board, int i) {
		int key = 0;

		for (int j = 0; j < N; ++j) {
			if (board[i][j] == '.')
				continue;

			if ((key & (1 << (board[i][j] - '0'))) != 0)
				return false;

			key |= 1 << (board[i][j] - '0');
		}

		return true;
	}

	public boolean isValid3x3(char[][] board, int x, int y) {
		int key = 0;

		for (int i = 3 * x; i < 3 * (x + 1); ++i) {
			for (int j = 3 * y; j < 3 * (y + 1); ++j) {
				if (board[i][j] == '.')
					continue;

				if ((key & (1 << (board[i][j] - '0'))) != 0)
					return false;

				key |= 1 << (board[i][j] - '0');
			}
		}

		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < N; ++i) {
			if (!isValid9x1(board, i) || !isValid1x9(board, i))
				return false;
		}

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (!isValid3x3(board, i, j))
					return false;
			}
		}

		return true;
	}
}
