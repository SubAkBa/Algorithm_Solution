import java.util.*;

public class Solution_TrappingRainWaterII {
	static int row, col;

	public static int GetWater(PriorityQueue<Cell> pq, int[][] heightMap, boolean[][] visited) {
		int water = 0;
		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		while (!pq.isEmpty()) {
			Cell current = pq.poll();

			for (int[] dir : dirs) {
				int nx = current.x + dir[0];
				int ny = current.y + dir[1];

				if (!(0 <= nx && nx < row && 0 <= ny && ny < col) || visited[nx][ny])
					continue;

				water += Math.max(0, current.height - heightMap[nx][ny]);
				visited[nx][ny] = true;
				pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], current.height)));
			}
		}

		return water;
	}

	public static void Init(PriorityQueue<Cell> pq, int[][] heightMap, boolean[][] visited) {
		for (int i = 0; i < col; ++i) {
			visited[0][i] = true;
			visited[row - 1][i] = true;
			pq.offer(new Cell(0, i, heightMap[0][i]));
			pq.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
		}

		for (int i = 0; i < row; ++i) {
			visited[i][0] = true;
			visited[i][col - 1] = true;
			pq.offer(new Cell(i, 0, heightMap[i][0]));
			pq.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
		}
	}

	public static int trapRainWater(int[][] heightMap) {
		row = heightMap.length;
		col = heightMap[0].length;

		if (heightMap == null || row == 0 || heightMap[0] == null || col == 0)
			return 0;

		boolean[][] visited = new boolean[row][col];
		PriorityQueue<Cell> pq = new PriorityQueue<>();

		Init(pq, heightMap, visited);

		return GetWater(pq, heightMap, visited);
	}

	public static class Cell implements Comparable<Cell> {
		int x, y, height;

		public Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Cell o) {
			return this.height - o.height;
		}
	}

	public static void main(String[] args) {
		System.out.println(
				trapRainWater(new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } }));
	}

}
