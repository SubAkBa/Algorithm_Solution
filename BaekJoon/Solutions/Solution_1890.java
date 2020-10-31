import java.util.*;
import java.io.*;

public class Solution_1890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		long[][] path = new long[N][N];
		path[0][0] = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (path[i][j] == 0 || (i == N - 1 && j == N - 1))
					continue;

				int nx = i + map[i][j];

				if (nx < N)
					path[nx][j] += path[i][j];

				int ny = j + map[i][j];

				if (ny < N)
					path[i][ny] += path[i][j];
			}
		}

		bw.write(path[N - 1][N - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
