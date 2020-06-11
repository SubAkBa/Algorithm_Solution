import java.util.*;

public class Solution_RottingOranges {
	static int row, col;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int Rotting(ArrayList<Point> rot_orange, int[][] grid, int fresh_count) {
		int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
		int time = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.addAll(rot_orange);

		while (!queue.isEmpty()) {
			
			if (fresh_count == 0)
				return time;

			time++;

			int size = queue.size();

			while ((size--) > 0) {
				Point current = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];

					if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
						continue;

					if (grid[nx][ny] != 0)
						continue;

					queue.offer(new Point(nx, ny));
					grid[nx][ny] = grid[current.x][current.y] + 1;
					fresh_count--;
				}
			}
		}

		return -1;
	}

	public static int orangesRotting(int[][] grid) {
		ArrayList<Point> rot_orange = new ArrayList<>();
		row = grid.length;
		col = grid[0].length;
		boolean isExist = false;
		int fresh_count = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				switch (grid[i][j]) {
				case 0:
					grid[i][j] = -1;
					break;
				case 1:
					grid[i][j] = 0;
					isExist = true;
					fresh_count++;
					break;
				case 2:
					rot_orange.add(new Point(i, j));
					grid[i][j] = 1;
					break;
				}
			}
		}

		if (!isExist)
			return 0;

		if (rot_orange.size() == 0)
			return -1;

		return Rotting(rot_orange, grid, fresh_count);
	}

	public static void main(String[] args) {
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 0, 2 } }));
		System.out.println(orangesRotting(new int[][] { { 0 } }));
	}

}
