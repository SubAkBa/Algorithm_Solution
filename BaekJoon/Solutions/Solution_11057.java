import java.io.*;
import java.util.*;

public class Solution_11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		int MOD = 10007;

		// 1자리 : 1 + 1 + ... + 1 = 10
		// 2자리 : 10 + 9 + ... + 1 = 55

		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j < 10; ++j) {
				for (int k = j; k < 10; ++k)
					dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; ++i)
			sum = (sum + dp[N][i]) % MOD;

//		bw.write(Arrays.stream(dp[N]).sum() % MOD + "");
		bw.write(sum + "");
		bw.close();
		br.close();
	}
}
