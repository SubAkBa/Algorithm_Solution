import java.util.*;
import java.io.*;

public class Solution_17136 {
	static int answer = Integer.MAX_VALUE;
	static int N = 10;

	public static void Attaching(int x, int y, int len, int[][] paper, int n) {
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++)
				paper[i][j] = n;
		}
	}

	public static boolean DoAttach(int x, int y, int len, int[][] paper, int[] pcount) {
		if (pcount[len - 1] == 0)
			return false;

		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (i >= N || j >= N || paper[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	public static void AttachPaper(int x, int y, int[][] paper, int[] pcount, int curcount) {
		int i = x * N + y;
		for (; i < N * N; i++) {
			x = i / N;
			y = i % N;

			if (paper[x][y] == 1)
				break;
		}

		if (i == N * N) {
			answer = Math.min(answer, curcount);
			return;
		}

		if (curcount >= answer)
			return;

		for (int l = 5; l >= 1; l--) {
			if (DoAttach(x, y, l, paper, pcount)) {
				pcount[l - 1]--;
				Attaching(x, y, l, paper, 0);

				AttachPaper(x, y, paper, pcount, curcount + 1);

				pcount[l - 1]++;
				Attaching(x, y, l, paper, 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] paper = new int[N][N];
		int[] pcount = { 5, 5, 5, 5, 5 };
		int fullcovered = 0;
		boolean zero = true;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());

				if (paper[i][j] == 1) {
					zero = false;
					fullcovered++;
				}
			}
		}

		if (zero)
			bw.write(0 + " ");
		else if (fullcovered == N * N)
			bw.write(4 + " ");
		else {
			AttachPaper(0, 0, paper, pcount, 0);

			bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
