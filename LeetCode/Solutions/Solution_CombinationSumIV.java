import java.util.*;

public class Solution_CombinationSumIV {

	public static int DFS(int[] dp, int[] nums, int target, int len) {
		if (target == 0)
			return 1;

		if (target < 0)
			return 0;

		if (dp[target] != -1)
			return dp[target];

		int count = 0;
		for (int i = 0; i < len; ++i)
			count += DFS(dp, nums, target - nums[i], len);

		return dp[target] = count;
	}

	public static int combinationSum4(int[] nums, int target) {
		int len = nums.length;
		int[] dp = new int[target + 1];

		Arrays.fill(dp, -1);

		return DFS(dp, nums, target, len);
	}

	public static void main(String[] args) {
		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4)); // 7
	}
}
