import java.util.*;

public class Solution_TargetSum {
	static int PLUS = 1000;

	public static int DFS(int[][] dp, int[] nums, int curSum, int S, int idx, int N) {
		if (idx == N)
			return curSum == S ? 1 : 0;

		if (dp[idx][curSum + PLUS] != -1)
			return dp[idx][curSum + PLUS];

		return dp[idx][curSum + PLUS] = DFS(dp, nums, curSum + nums[idx], S, idx + 1, N)
				+ DFS(dp, nums, curSum - nums[idx], S, idx + 1, N);
	}

	public static int findTargetSumWays(int[] nums, int S) {
		int N = nums.length;
		int[][] dp = new int[N][2 * PLUS + 1];

		for (int i = 0; i < N; ++i)
			Arrays.fill(dp[i], -1);

		return DFS(dp, nums, 0, S, 0, N);
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3)); // 5
	}
}
