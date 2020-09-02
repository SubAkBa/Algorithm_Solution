import java.util.*;
import java.io.*;

public class Solution_1261 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static int EscapeMaze(int x, int y) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

		visited[x][y] = true;
		pq.offer(new Point(x, y, map[x][y]));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (cur.x == N && cur.y == M)
				return cur.value;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						if (map[nx][ny] == 0)
							pq.offer(new Point(nx, ny, cur.value));
						else
							pq.offer(new Point(nx, ny, cur.value + 1));
					}
				}
			}
		}
		
		return -1;
	}

	public static class Point implements Comparable<Point> {
		int x, y, value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Point p) {
			return this.value - p.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			char[] chr = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++)
				map[i][j] = chr[j - 1] - '0';
		}

		bw.write(EscapeMaze(1, 1) + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
