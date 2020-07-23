import java.util.*;

public class Solution_NumberofIslands {

	public static void BFS(char[][] grid, int x, int y, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
					continue;

				if (grid[nx][ny] == '0')
					continue;

				grid[nx][ny] = '0';
				queue.offer(new int[] { nx, ny });
			}
		}
	}

	public static int numIslands(char[][] grid) {
		int row = grid.length, col = grid[0].length;
		int count = 0;

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (grid[i][j] == '1') {
					BFS(grid, i, j, row, col);
					++count;
				}
			}
		}

		return count;
	}
}
