import java.io.*;

public class Solution_1309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int MOD = 9901;

		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 3;

		for (int i = 2; i <= N; ++i)
			dp[i] = (2 * dp[i - 1] + dp[i - 2]) % MOD;

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
