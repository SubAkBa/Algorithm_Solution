import java.util.*;
import java.io.*;

public class Solution_1520 {
	static int[][] count;
	static int[] d = { -1, 0, 1, 0, -1 };

	public static int DFS(int[][] map, int M, int N, int x, int y) {
		if (x == M - 1 && y == N - 1)
			return 1;

		if (count[x][y] != -1)
			return count[x][y];

		count[x][y] = 0;
		for (int i = 0; i < 4; ++i) {
			int nx = x + d[i];
			int ny = y + d[i + 1];

			if (!(0 <= nx && nx < M && 0 <= ny && ny < N))
				continue;

			if (map[nx][ny] >= map[x][y])
				continue;

			count[x][y] += DFS(map, M, N, nx, ny);
		}

		return count[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		count = new int[M][N];

		int[][] map = new int[M][N];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(count[i], -1);

			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		DFS(map, M, N, 0, 0);

		bw.write(count[0][0] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
