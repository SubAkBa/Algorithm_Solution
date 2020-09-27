import java.util.*;

public class Solution_01Matrix {

	public static void BFS(Queue<int[]> queue, int[][] matrix, int[][] dist, int n, int m) {
		int[] d = new int[] { -1, 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (!(0 <= nx && nx < n && 0 <= ny && ny < m))
					continue;

				if (dist[nx][ny] <= dist[current[0]][current[1]] + 1)
					continue;

				dist[nx][ny] = dist[current[0]][current[1]] + 1;
				queue.offer(new int[] { nx, ny });
			}
		}

	}

	public static int[][] updateMatrix(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length, INF = 987654321;
		int[][] dist = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == 0)
					queue.offer(new int[] { i, j });
				else
					dist[i][j] = INF;
			}
		}

		BFS(queue, matrix, dist, n, m);

		return dist;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }))); // [[0,0,0],[0,1,0],[0,0,0]]
		System.out.println(Arrays.deepToString(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }))); // [[0,0,0],[0,1,0],[1,2,1]]
	}
}
