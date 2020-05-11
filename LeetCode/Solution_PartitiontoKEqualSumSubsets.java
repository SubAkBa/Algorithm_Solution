
public class Solution_PartitiontoKEqualSumSubsets {

	public static boolean Partitions(int[] nums, int nidx, int k, int len, boolean[] visited, int target, int cursum) {
		if (k == 0)
			return true;

		if (cursum == target && Partitions(nums, 0, k - 1, len, visited, target, 0))
			return true;

		for (int i = nidx; i < len; i++) {
			if (!visited[i] && cursum + nums[i] <= target) {
				visited[i] = true;

				if (Partitions(nums, i + 1, k, len, visited, target, cursum + nums[i]))
					return true;

				visited[i] = false;
			}
		}

		return false;
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int len = nums.length;
		int sum = 0, max = 0;

		for (int i = 0; i < len; i++) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}

		int target = sum / k;

		if (max > target || sum % k != 0 || k > len)
			return false;

		return Partitions(nums, 0, k, len, new boolean[len], target, 0);
	}

	public static void main(String[] args) {
		System.out.println(canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
	}

}
