import java.util.*;
import java.io.*;

public class bfs_7576_solution {
	static int[][] map;
	static int row, col;
	static int max = 1;

	public static void BFS() {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny;
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1)
					q.offer(new Point(i, j));
			}
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (nx < 0 || row <= nx || ny < 0 || col <= ny)
					continue;

				if (map[nx][ny] != 0)
					continue;

				q.offer(new Point(nx, ny));
				map[nx][ny] = map[cur.x][cur.y] + 1;
				max = Math.max(max, map[nx][ny]);
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0)
					max = 0;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		BFS();

		bw.write((max - 1) + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}