import java.util.*;

public class Solution_shortestpathgamemap {

	public static int solution(int[][] maps) {
		int n = maps.length, m = maps[0].length;
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		boolean[][] visited = new boolean[n][m];

		Queue<Point> queue = new LinkedList<>();

		visited[0][0] = true;
		queue.offer(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;

				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (!visited[nx][ny] && maps[nx][ny] != 0) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						maps[nx][ny] = maps[cur.x][cur.y] + 1;
					}
				}
			}
		}

		return (maps[n - 1][m - 1] == 1) ? -1 : maps[n - 1][m - 1];
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } }));
	}

}
