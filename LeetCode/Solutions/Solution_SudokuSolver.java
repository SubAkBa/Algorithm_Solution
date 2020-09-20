import java.util.*;

public class Solution_SudokuSolver {
	static int size = 9;
	static int answer = ((1 << 10) - 1) - 1;
	static boolean isFinished;

	public static boolean canNumbering(int[][] keys, int c, int x, int y) {
		if ((keys[0][x] & (1 << c)) != 0)
			return false;

		if ((keys[1][y] & (1 << c)) != 0)
			return false;

		if ((keys[2][(x / 3) * 3 + y / 3] & (1 << c)) != 0)
			return false;

		return true;
	}

	public static void KeyCheck(int[][] keys, int c, int x, int y) {
		keys[0][x] ^= (1 << c);
		keys[1][y] ^= (1 << c);
		keys[2][(x / 3) * 3 + y / 3] ^= (1 << c);
	}

	public static boolean isFinish(int[][] keys) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < size; ++j)
				if (keys[i][j] != answer)
					return false;
		}

		return true;
	}

	public static void DFS(char[][] f_board, char[][] board, int[][] keys, int pos) {
		if (isFinished)
			return;

		if (pos == size * size) {
			if (isFinish(keys)) {
				isFinished = true;
				CopyBoard(board, f_board);
			}
			return;
		}

		int nx = pos / size;
		int ny = pos % size;

		if (board[nx][ny] != '.') {
			DFS(f_board, board, keys, pos + 1);
			return;
		}

		for (int i = 1; i <= size; ++i) {
			if (!canNumbering(keys, i, nx, ny))
				continue;

			board[nx][ny] = (char) (i + '0');
			KeyCheck(keys, i, nx, ny);

			DFS(f_board, board, keys, pos + 1);

			board[nx][ny] = '.';
			KeyCheck(keys, i, nx, ny);
		}
	}

	public static void solveSudoku(char[][] board) {
		int[][] keys = new int[size / 3][size]; // 가로, 세로, 3x3
		char[][] f_board = new char[size][size];
		isFinished = false;

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (board[i][j] == '.')
					continue;

				keys[0][i] |= (1 << (board[i][j] - '0'));
				keys[1][j] |= (1 << (board[i][j] - '0'));
				keys[2][(i / 3) * 3 + j / 3] |= (1 << (board[i][j] - '0'));
			}
		}

		DFS(f_board, board, keys, 0);

		CopyBoard(f_board, board);
	}

	public static void CopyBoard(char[][] f_board, char[][] board) {
		for (int i = 0; i < size; ++i)
			System.arraycopy(f_board[i], 0, board[i], 0, size);
	}

//	public static void KeyPrint(int[][] keys) {
//		for (int i = 0; i < 3; ++i) {
//			for (int j = 0; j < size; ++j)
//				System.out.println("i : " + i + " j : " + j + " " + Integer.toBinaryString(keys[i][j]));
//		}
//	}
//
//	public static void Print(char[][] board) {
//		for (int i = 0; i < size; ++i)
//			System.out.println(Arrays.toString(board[i]));
//		System.out.println();
//	}

	public static void main(String[] args) {
		solveSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });
	}
}
