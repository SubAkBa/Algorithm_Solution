import java.util.*;
import java.io.*;

public class Solution_2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MOD = 1000000000;

		int[][] dp = new int[K + 1][N + 1];

		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= K; ++i) {
			for (int j = 0; j <= N; ++j) {
				for (int k = 0; k <= j; ++k)
					dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
			}
		}

		bw.write(dp[K][N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
