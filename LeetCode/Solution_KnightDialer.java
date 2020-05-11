import java.util.*;

public class Solution_KnightDialer {

	public static int knightDialer(int N) {
		int len = 10, total = 0;
		long[][] dp = new long[2][len];
		int mod = (int) (Math.pow(10, 9) + 7);

		if (N == 1)
			return len;

		Arrays.fill(dp[0], 1);

		for (int i = 1; i < N; i++) {
			dp[1][0] = dp[0][4] + dp[0][6];
			dp[1][1] = dp[0][6] + dp[0][8];
			dp[1][2] = dp[0][7] + dp[0][9];
			dp[1][3] = dp[0][4] + dp[0][8];
			dp[1][4] = dp[0][0] + dp[0][3] + dp[0][9];

			dp[1][6] = dp[0][0] + dp[0][1] + dp[0][7];
			dp[1][7] = dp[0][2] + dp[0][6];
			dp[1][8] = dp[0][1] + dp[0][3];
			dp[1][9] = dp[0][2] + dp[0][4];

			for (int j = 0; j < len; j++) {
				dp[0][j] = dp[1][j] % mod;

				if (i == N - 1)
					total = total % mod + (int) dp[0][j];
			}
		}

		return total % mod;
	}

	public static void main(String[] args) {
		System.out.println(knightDialer(1));
		System.out.println(knightDialer(2));
		System.out.println(knightDialer(3));
		System.out.println(knightDialer(161)); // 533302150
		System.out.println(knightDialer(5000));
	}

}
