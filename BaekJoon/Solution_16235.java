import java.util.*;
import java.io.*;

public class Solution_16235 {
	static int N;
	static ArrayList<Integer>[][] trees;
	static int[][] map, S2D2;

	public static void SpringNSummer() {
		for (int idx = 0; idx < N * N; idx++) {
			int x = idx / N;
			int y = idx % N;

			for (int tidx = trees[x][y].size() - 1; tidx >= 0; tidx--) {
				if (trees[x][y].get(tidx) <= map[x][y]) {
					map[x][y] -= trees[x][y].get(tidx);
					trees[x][y].set(tidx, trees[x][y].get(tidx) + 1);
				} else {
					for (int age : trees[x][y].subList(0, tidx + 1))
						map[x][y] += age / 2;

					trees[x][y].subList(0, tidx + 1).clear();
					break;
				}
			}
		}
	}

	public static void FallNWinter() {
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 }, dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

		for (int idx = 0; idx < N * N; idx++) {
			int x = idx / N;
			int y = idx % N;

			for (int age : trees[x][y]) {
				if (age % 5 == 0) {
					for (int i = 0; i < 8; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if (0 <= nx && nx < N && 0 <= ny && ny < N)
							trees[nx][ny].add(1);
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] += S2D2[i][j];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		S2D2 = new int[N][N];
		map = new int[N][N];
		trees = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				trees[i][j] = new ArrayList<>();
				S2D2[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			trees[x - 1][y - 1].add(z);
		}

		for (int year = 0; year < K; year++) {
			SpringNSummer();
			FallNWinter();
		}

		int count = 0;

		for (int idx = 0; idx < N * N; idx++)
			count += trees[idx / N][idx % N].size();

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
