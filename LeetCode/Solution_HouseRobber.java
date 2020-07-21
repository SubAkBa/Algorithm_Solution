
public class Solution_HouseRobber {
//	public static int rob(int[] nums) {
//		int len = nums.length;
//		int[][] dp = new int[len + 1][2];
//
//		for (int i = 1; i <= len; ++i) {
//			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//			dp[i][1] = dp[i - 1][0] + nums[i - 1];
//		}
//
//		return Math.max(dp[len][0], dp[len][1]);
//	}

	public static int rob(int[] nums) {
		int s = 0, ns = 0;

		for (int n : nums) {
			int temp = ns;
			ns = Math.max(ns, s);
			s = n + temp;
		}

		return Math.max(ns, s);
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(rob(new int[] { 2, 1, 1, 2 }));
	}

}
