import java.util.*;
import java.io.*;

public class Solution_11658 {
	static int N;
	static long[][] tree;

	public static void Update(int row, int col, long diff) {

		while (row <= N) {
			int tcol = col;

			while (tcol <= N) {
				tree[row][tcol] += diff;
				tcol += (tcol & -tcol);
			}

			row += (row & -row);
		}
	}

	public static long Query(int row, int col) {
		long calc = 0;

		while (row > 0) {
			int tcol = col;

			while (tcol > 0) {
				calc += tree[row][tcol];
				tcol -= (tcol & -tcol);
			}
			row -= (row & -row);
		}

		return calc;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] nums = new int[N + 1][N + 1];
		tree = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				Update(i, j, nums[i][j]);
			}
		}

		while ((M--) > 0) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());

			switch (w) {
			case 0:
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				long diff = c - nums[x][y];

				Update(x, y, diff);

				nums[x][y] = c;
				break;
			case 1:
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());

				if (x1 > x2) {
					int temp = x1;
					x1 = x2;
					x2 = temp;
				}

				if (y1 > y2) {
					int temp = y1;
					y1 = y2;
					y2 = temp;
				}

				long result = Query(x2, y2) + Query(x1 - 1, y1 - 1) - Query(x1 - 1, y2) - Query(x2, y1 - 1);

				bw.write(result + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
