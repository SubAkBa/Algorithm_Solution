import java.util.*;
import java.io.*;

public class Solution_14502 {
	static int answer;

	public static int[][] SpreadVirus(int N, int M, int[][] map, ArrayList<Point> virus) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int[][] cpmap = new int[N][M];

		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, cpmap[i], 0, M);

		for (Point v : virus)
			queue.offer(new Point(v.x, v.y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (cpmap[nx][ny] == 0) {
						cpmap[nx][ny] = 2;
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}

		return cpmap;
	}

	public static int MaxSafeArea(int N, int M, int[][] map) {
		int area = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					area++;
			}
		}

		return area;
	}

	public static void ConstructWall(int cur, int k, int N, int M, int[][] map, ArrayList<Point> virus) {
		if (k == 0) {
			answer = Math.max(answer, MaxSafeArea(N, M, SpreadVirus(N, M, map, virus)));
			return;
		}

		for (int i = cur; i < N * M; i++) {
			int cx = i / M, cy = i % M;

			if (map[cx][cy] == 0) {
				map[cx][cy] = 1;

				ConstructWall(cur + 1, k - 1, N, M, map, virus);

				map[cx][cy] = 0;
			}
		}
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		ArrayList<Point> virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		ConstructWall(0, 3, N, M, map, virus);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
