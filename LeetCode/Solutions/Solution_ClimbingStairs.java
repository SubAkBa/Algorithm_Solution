
public class Solution_ClimbingStairs {
	public static int climbStairs(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;

		if (n > 1)
			dp[2] = 2;

		for (int i = 3; i <= n; ++i)
			dp[i] = dp[i - 1] + dp[i - 2];

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
	}

}
