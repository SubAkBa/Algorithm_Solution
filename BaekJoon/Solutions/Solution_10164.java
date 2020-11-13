import java.util.*;
import java.io.*;

public class Solution_10164 {

	public static boolean isRange(int N, int M, int r, int c) {
		if (0 <= r && r <= N && 0 <= c && c <= M)
			return true;

		return false;
	}

	public static int DFS(int N, int M, int[][] dp, int r, int c) {
		if (r == N && c == M)
			return 1;

		if (!isRange(N, M, r, c))
			return 0;

		if (dp[r][c] != 0)
			return dp[r][c];

		return dp[r][c] = DFS(N, M, dp, r + 1, c) + DFS(N, M, dp, r, c + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N][M];

		if (K == 0)
			bw.write(DFS(N - 1, M - 1, dp, 0, 0) + "");
		else {
			--K;
			int[] kPos = new int[] { K / M, K % M };
			bw.write(DFS(kPos[0], kPos[1], dp, 0, 0) * DFS(N - 1, M - 1, dp, kPos[0], kPos[1]) + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
