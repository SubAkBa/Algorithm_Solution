import java.util.*;

public class Solution_CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		int INF = 987654321, clen = coins.length;

		Arrays.fill(dp, INF);

		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < clen; j++) {
				if (coins[j] <= i)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		return dp[amount] == INF ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11)); // 3
		System.out.println(coinChange(new int[] { 2 }, 3)); // -1
		System.out.println(coinChange(new int[] { 2, 5, 10, 1 }, 27)); // 4
		System.out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249)); // 20
	}

}
