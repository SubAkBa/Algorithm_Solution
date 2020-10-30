import java.io.*;

public class Solution_2133 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 2];
		
		if (N % 2 == 0) {
			dp[0] = 1;
			dp[2] = 3;

			for (int i = 4; i <= N; i += 2) {
				dp[i] = dp[i - 2] * 3;
				for (int j = 4; j <= i; j += 2)
					dp[i] += dp[i - j] * 2;
			}
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
