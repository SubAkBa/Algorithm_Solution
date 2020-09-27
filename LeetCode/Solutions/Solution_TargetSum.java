import java.util.*;

public class Solution_TargetSum {

	public static int DFS(Map<String, Integer> table, int[] nums, int idx, int len, int curS, int S) {
		String str = idx + "," + curS;

		if (table.containsKey(str))
			return table.get(str);

		if (idx == len) {
			if (curS == S)
				return 1;
			else
				return 0;
		}

		int count = DFS(table, nums, idx + 1, len, curS + nums[idx], S)
				+ DFS(table, nums, idx + 1, len, curS - nums[idx], S);
		table.put(str, count);

		return count;
	}

	public static int findTargetSumWays(int[] nums, int S) {
		int len = nums.length;

		int sum = 0;
		for (int i = 0; i < len; ++i)
			sum += nums[i];

		if (sum < S)
			return 0;

		Map<String, Integer> table = new HashMap<>();

		return DFS(table, nums, 0, len, 0, S);
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}
}
