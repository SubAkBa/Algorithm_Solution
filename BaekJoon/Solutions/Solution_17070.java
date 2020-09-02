import java.util.*;
import java.io.*;

public class Solution_17070 {
	static int[] dx = { 0, 1, 1 }, dy = { 1, 1, 0 };
	static int[][][] path;

	public static int PipePath(int[][] map, int N, int x, int y, int dir) {

		if (!(0 <= x && x < N && 0 <= y && y < N) || map[x][y] == 1)
			return 0;

		if (dir == 1 && (map[x - 1][y] == 1 || map[x][y - 1] == 1))
			return 0;

		if (path[x][y][dir] != -1)
			return path[x][y][dir];

		if (x == N - 1 && y == N - 1)
			return 1;

		int sum = 0;

		for (int i = 0; i < 3; i++) {
			if ((dir == 0 && i == 2) || (dir == 2 && i == 0))
				continue;

			int nx = x + dx[i];
			int ny = y + dy[i];

			sum += PipePath(map, N, nx, ny, i);
		}

		return path[x][y][dir] = sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		path = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				for (int k = 0; k < 3; k++)
					path[i][j][k] = -1;
			}
		}

		int answer = PipePath(map, N, 0, 1, 0);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
