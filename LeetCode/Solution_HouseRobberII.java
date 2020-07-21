
public class Solution_HouseRobberII {

	public static int rob(int[] nums) {
		int len = nums.length;

		if (len == 1)
			return nums[0];

		int[][] dp = new int[2][len];

		dp[0][0] = nums[0];
		dp[0][1] = Math.max(nums[0], nums[1]);

		dp[1][0] = nums[1];
		dp[1][1] = Math.max(nums[1], nums[2]);

		for (int i = 2; i < len - 1; ++i) {
			dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + nums[i]);
			dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i + 1]);
		}

		return Math.max(dp[0][len - 2], dp[1][len - 1]);
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 2, 3, 2 }));
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 4, 1, 2 }));
	}
}
