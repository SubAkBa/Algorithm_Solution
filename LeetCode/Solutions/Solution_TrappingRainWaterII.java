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

				// 현재 지점의 높이와 현재 지점과 인접지점 (동서남북) 의 높이 차이를 계산하여 water에 더하기 (음수 일 경우 0)
				// 27번째 코드에서 Heap에 삽입될 때 현재지점 높이와 인접지점 높이 중 더 높은 것이 선택되어 다음 지점으로 진행되기 때문에
				// TrappingRainWaterI과 마찬가지로 물을 가둘 수 있는 큰 높이를 유지할 수 있다.
				// 또한, 물이 최대로 고이는 높이보다 더 높은 높이 (이 높이까지는 물이 고이지 못한다. -> 이 셀을 제외하고 주변 다른 셀들의 높이가 낮기 때문에 고일 수 없음)
				// 가 나타날 수 있지만, Heap을 통해 낮은 높이부터 BFS를 탐색하며 결국 높이가 더 높은 셀들이 나왔을 때는 visited = true가 되어 있기 때문에 방문하지 못한다.
				water += Math.max(0, current.height - heightMap[nx][ny]);
				visited[nx][ny] = true;
				pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], current.height)));
			}
		}

		return water;
	}

	// 맵의 가장자리에서 높이가 낮은 셀부터 BFS를 수행하기 위해 Heap에 삽입
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
