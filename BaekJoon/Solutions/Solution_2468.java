import java.util.*;
import java.io.*;

public class bfs_2468_solution {
	static int[][] map;
	static boolean[][] visited;
	static int num, height;

	public static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny;

		queue.offer(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (0 <= nx && nx < num && 0 <= ny && ny < num) {
					if (!visited[nx][ny] && map[nx][ny] >= height) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
					}

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = Integer.parseInt(br.readLine());
		height = 0;
		int maxheight = 0;
		int count = 0, maxcount = 0;

		map = new int[num][num];
		visited = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			String[] mapinfo = br.readLine().split(" ");

			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.parseInt(mapinfo[j]);
				maxheight = Math.max(map[i][j], maxheight);
			}
		}

		while ((height++) <= maxheight) {

			for (int i = 0; i < num; i++)
				Arrays.fill(visited[i], false);

			count = 0;

			for (int i = 0; i < num; i++) {

				for (int j = 0; j < num; j++) {

					if (!visited[i][j] && map[i][j] >= height) {
						BFS(i, j);

						count++;
					}
				}
			}
			
			maxcount = Math.max(maxcount, count);
		}

		System.out.println(maxcount);

	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}