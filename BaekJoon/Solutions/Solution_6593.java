import java.util.*;
import java.io.*;

public class Solution_6593 {
	static char[][][] building;
	static boolean[][][] visited;
	static int L, R, C;
	static int[] dx = { -1, 1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 }, dz = { 0, 0, 0, 0, -1, 1 };
	static Point start;

	public static int Escape() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int iter = queue.size();

			while ((iter--) > 0) {
				Point cur = queue.poll();

				if (building[cur.x][cur.y][cur.z] == 'E')
					return cur.time;

				for (int i = 0; i < 6; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					int nz = cur.z + dz[i];

					if (!(0 <= nx && nx < L && 0 <= ny && ny < R && 0 <= nz && nz < C))
						continue;

					if (building[nx][ny][nz] == '#')
						continue;

					if (visited[nx][ny][nz])
						continue;

					queue.offer(new Point(nx, ny, nz, cur.time + 1));
					visited[nx][ny][nz] = true;
				}
			}
		}

		return -1;
	}

	public static class Point {
		int x, y, z, time;

		public Point(int x, int y, int z, int time) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			building = new char[L][R][C];
			visited = new boolean[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] ch = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						building[i][j][k] = ch[k];

						if (building[i][j][k] == 'S')
							start = new Point(i, j, k, 0);
					}
				}

				br.read();
			}

			int answer = Escape();

			sb.append((answer == -1 ? "Trapped!\n" : "Escaped in " + answer + " minute(s).\n"));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
