import java.util.*;
import java.io.*;

public class Solution_14502 {
	static int answer = 0, N, M;
	static List<Point> virus;
	static int[][] map, cpmap;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void SpreadVirus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (cpmap[nx][ny] == 0) {
					cpmap[nx][ny] = 2;
					SpreadVirus(nx, ny);
				}
			}
		}
	}

	public static int MaxSafeArea() {
		int area = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cpmap[i][j] == 0)
					area++;
			}
		}

		return area;
	}

	public static void ConstructWall(int cur, int k) {
		if (k == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					cpmap[i][j] = map[i][j];
			}

			for (Point v : virus)
				SpreadVirus(v.x, v.y);

			answer = Math.max(answer, MaxSafeArea());
			return;
		}

		for (int i = cur; i < N * M; i++) {
			int cx = i / M, cy = i % M;

			if (map[cx][cy] == 0) {
				map[cx][cy] = 1;

				ConstructWall(i + 1, k - 1);

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

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cpmap = new int[N][M];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().replaceAll(" ", "").toCharArray();

			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j] - '0';

				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		ConstructWall(0, 3);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}