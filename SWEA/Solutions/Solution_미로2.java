import java.util.*;
import java.io.*;

public class Solution_maze2 {
	static int len = 100;

	public static int BFS(int[][] maze, int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (maze[nx][ny] == 3)
					return 1;

				if (maze[nx][ny] == 0) {
					maze[nx][ny] = maze[cur.x][cur.y];
					queue.offer(new Point(nx, ny));
				}
			}
		}

		return 0;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		while ((T--) > 0) {
			int casenum = Integer.parseInt(br.readLine());
			int[][] maze = new int[len][len];

			for (int i = 0; i < len; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < len; j++)
					maze[i][j] = temp[j] - '0';
			}

			bw.write("#" + casenum + " " + BFS(maze, 1, 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
