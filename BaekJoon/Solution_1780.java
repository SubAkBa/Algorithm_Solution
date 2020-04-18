import java.io.*;
import java.util.*;

public class Solution_1780 {
	static int[][] map;
	static int[] counts;

	public static void Cut(int N, int y, int x) {
		if (N == 1) {
			counts[map[y][x] + 1]++;
			return;
		}

		int cur = map[y][x];
		boolean same = true;

		for (int i = y; i < y + N && same; i++) {
			for (int j = x; j < x + N && same; j++) {
				if (map[i][j] != cur) {
					same = false;
					continue;
				}

				if (i == (y + N - 1) && j == (x + N - 1)) {
					counts[cur + 1]++;
					return;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				Cut(N / 3, y + N / 3 * i, x + N / 3 * j);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		counts = new int[3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		Cut(N, 0, 0);

		for (int count : counts)
			bw.write(count + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
