import java.util.*;

public class Solution_MinimumCostForTickets {

	public static int mincostTickets(int[] days, int[] costs) {
		int dlen = days.length;
		int[] dp = new int[days[dlen - 1] + 1];

		int idx = 0;
		for (int day = 1; day <= days[dlen - 1]; ++day) {
			if (days[idx] != day) {
				dp[day] = dp[day - 1];
				continue;
			}

			dp[day] = dp[day - 1] + costs[0];
			dp[day] = Math.min(dp[day], dp[Math.max(0, day - 7)] + costs[1]);
			dp[day] = Math.min(dp[day], dp[Math.max(0, day - 30)] + costs[2]);

			++idx;
		}

		System.out.println(Arrays.toString(dp));

		return dp[days[dlen - 1]];
	}

	public static void main(String[] args) {
		System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 })); // 11
		System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 })); // 17
		System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 7, 2, 15 })); // 6
	}
}
