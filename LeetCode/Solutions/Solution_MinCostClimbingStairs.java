
public class Solution_MinCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {
		int len = cost.length;

		if (len == 1)
			return cost[0];

		for (int i = 2; i < len; i++)
			cost[i] += Math.min(cost[i - 2], cost[i - 1]);

		return Math.min(cost[len - 2], cost[len - 1]);
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

	}

}
