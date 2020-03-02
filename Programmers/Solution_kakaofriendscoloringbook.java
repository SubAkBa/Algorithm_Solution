import java.util.*;

public class Solution_kakaofriendscoloringbook {

	public static int BFS(boolean[][] visited, int[][] picture, Point start) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int area = 1, nx, ny;

		visited[start.x][start.y] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (0 <= nx && nx < picture.length && 0 <= ny && ny < picture[0].length) {
					
					if (!visited[nx][ny] && picture[nx][ny] != 0 
							&& picture[cur.x][cur.y] == picture[nx][ny]) {
						
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						area++;
					}
				}
			}
		}

		return area;
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++)
			Arrays.fill(visited[i], false);

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {

				if (visited[x][y] || picture[x][y] == 0)
					continue;

				answer[1] = Math.max(answer[1], BFS(visited, picture, new Point(x, y)));
				answer[0]++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } })));
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}