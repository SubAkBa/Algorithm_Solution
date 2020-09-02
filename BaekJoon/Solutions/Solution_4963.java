import java.util.*;
import java.io.*;

public class graph_4963_solution {
	static int[][] map;
	static boolean[][] visited;
	static int row, col;

	public static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, -1, 1, 1, -1, 1, 0, 0 }, dy = { 1, -1, 1, -1, 0, 0, 1, -1 };
		int nx, ny;

		queue.offer(new Point(x, y));
		visited[x][y] = true;
		map[x][y] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 8; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (0 <= nx && nx < row && 0 <= ny && ny < col) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						map[nx][ny] = 0;
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int island = 0;
			String[] info = br.readLine().split(" ");

			if (info[0].equals("0") && info[1].equals("0"))
				break;

			col = Integer.parseInt(info[0]);
			row = Integer.parseInt(info[1]);

			map = new int[row][col];
			visited = new boolean[row][col];

			for (int i = 0; i < row; i++) {
				String[] mapinfo = br.readLine().split(" ");
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(mapinfo[j]);
					visited[i][j] = false;
				}
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						BFS(i, j);
						island++;
					}
				}
			}
			
			sb.append(island + "\n");
		}
		
		System.out.print(sb.toString());
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}