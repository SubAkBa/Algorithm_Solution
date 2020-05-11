import java.util.*;
import java.io.*;

public class Solution_gatherhoney {
	static int N, M, C;
	static int[][] map;

	public static int MaxCalc(int x, int y, int target, int sum, int total) {
		if (total > C)
			return 0;

		if (target == M)
			return sum;

		return Math.max(MaxCalc(x, y + 1, target + 1, sum + map[x][y] * map[x][y], total + map[x][y]),
				MaxCalc(x, y + 1, target + 1, sum, total));
	}

	public static int GatherHoney(int x, int y) {
		int max1 = MaxCalc(x, y, 0, 0, 0), max2 = 0;

		for (int i = x + 1; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++)
				max2 = Math.max(max2, MaxCalc(i, j, 0, 0, 0));
		}

		return max1 + max2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++)
					answer = Math.max(answer, GatherHoney(i, j));
			}

			bw.write("#" + count + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
