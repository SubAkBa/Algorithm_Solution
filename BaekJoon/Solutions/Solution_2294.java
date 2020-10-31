import java.util.*;
import java.io.*;

public class Solution_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		for (int i = 0; i < n; ++i)
			coins[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[k + 1];

		Arrays.fill(dp, k + 1);

		dp[0] = 0;
		for (int i = 1; i <= k; ++i) {
			for (int j = 0; j < n; ++j) {
				if (coins[j] <= i)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		bw.write((dp[k] == k + 1 ? -1 : dp[k]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
