
public class Solution_CoinChange2 {

	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];

		dp[0] = 1;
		for (int coin : coins) {
			for (int j = coin; j <= amount; ++j)
				dp[j] += dp[j - coin];
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 })); // 4
		System.out.println(change(3, new int[] { 2 })); // 0
		System.out.println(change(10, new int[] { 10 })); // 1
	}
}
