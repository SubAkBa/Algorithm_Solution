import java.util.*;

public class Solution_SurroundedRegions {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int row, col;

	public void BFS(char[][] board, int x, int y, boolean[][] visited) {
		char[][] cpboard = new char[row][col];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < row; ++i)
			System.arraycopy(board[i], 0, cpboard[i], 0, col);

		visited[x][y] = true;
		cpboard[x][y] = 'X';
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
					return;

				if (cpboard[nx][ny] == 'X')
					continue;

				visited[nx][ny] = true;
				cpboard[nx][ny] = 'X';
				queue.offer(new int[] { nx, ny });
			}
		}

		for (int i = 0; i < row; ++i)
			System.arraycopy(cpboard[i], 0, board[i], 0, col);
	}

	public void solve(char[][] board) {
		row = board.length;

		if (row == 0)
			return;

		col = board[0].length;

		if (col == 0)
			return;

		boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (board[i][j] == 'X' || (board[i][j] == 'O' && visited[i][j]))
					continue;

				BFS(board, i, j, visited);
			}
		}
	}
}
