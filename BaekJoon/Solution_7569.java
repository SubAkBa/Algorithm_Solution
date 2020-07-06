import java.util.*;
import java.io.*;

public class Solution_7569 {
	static int H, N, M;
	static int[][][] map;
	static List<Point> tomato;

	public static int BFS(int not) {
		int time = 0;
		int[] dx = { -1, 1, 0, 0, 0, 0 }, dy = { 0, 0, -1, 1, 0, 0 }, dz = { 0, 0, 0, 0, -1, 1 };
		Queue<Point> queue = new LinkedList<>();
		queue.addAll(tomato);

		while (!queue.isEmpty()) {
			int size = queue.size();

			++time;

			while ((--size) >= 0) {
				Point cur = queue.poll();

				for (int i = 0; i < 6; i++) {
					int nx = dx[i] + cur.x;
					int ny = dy[i] + cur.y;
					int nz = dz[i] + cur.z;

					if (!(0 <= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M))
						continue;

					if (map[nx][ny][nz] != 0)
						continue;

					map[nx][ny][nz] = 1;
					queue.offer(new Point(nx, ny, nz));
					--not;
				}
			}
		}

		if (not > 0)
			return -1;

		return time - 1;
	}

	public static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		tomato = new ArrayList<Point>();
		int not = 0;

		for (int i = 0; i < N * H; ++i) {
			st = new StringTokenizer(br.readLine());

			int f = i / N;
			int r = i % N;

			for (int j = 0; j < M; ++j) {
				map[f][r][j] = Integer.parseInt(st.nextToken());

				if (map[f][r][j] == 1)
					tomato.add(new Point(f, r, j));
				else if (map[f][r][j] == 0)
					++not;
			}
		}

		bw.write((not == 0 ? 0 : BFS(not)) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
