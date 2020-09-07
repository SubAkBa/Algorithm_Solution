import java.util.*;

public class Solution_카카오프렌즈컬러링북 {

	public static int BFS(int m, int n, long[][] picture, long type, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		int[] d = { -1, 0, 1, 0, -1 };
		int area = 1;

		picture[x][y] = 0;
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (!(0 <= nx && nx < m && 0 <= ny && ny < n))
					continue;

				if (picture[nx][ny] == 0 || picture[nx][ny] != type)
					continue;

				picture[nx][ny] = 0;
				queue.offer(new int[] { nx, ny });
				++area;
			}
		}

		return area;
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int count = 0, maxarea = 0;
		long[][] lpicture = new long[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j)
				lpicture[i][j] = (long) picture[i][j];
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (lpicture[i][j] == 0)
					continue;

				maxarea = Math.max(maxarea, BFS(m, n, lpicture, lpicture[i][j], i, j));
				++count;
			}
		}

		return new int[] { count, maxarea };
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } })));
	}
}
