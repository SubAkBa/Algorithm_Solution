
public class Solution_PartitiontoKEqualSumSubsets {

	public static boolean canPartition(int[] nums, int k, int idx, int len, int target, int curSum,
			boolean[] selected) {
		if (k == 0)
			return true;

		if (curSum == target && canPartition(nums, k - 1, 0, len, target, 0, selected))
			return true;

		for (int i = idx; i < len; ++i) {
			if (selected[i] || curSum + nums[i] > target)
				continue;

			selected[i] = true;
			if (canPartition(nums, k, i + 1, len, target, curSum + nums[i], selected))
				return true;

			selected[i] = false;
		}

		return false;
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0, len = nums.length, max = 0;

		for (int i = 0; i < len; ++i) {
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}

		int target = sum / k;

		if (sum % k != 0 || max > target || k > len)
			return false;

		return canPartition(nums, k, 0, len, target, 0, new boolean[len]);
	}

	public static void main(String[] args) {
		System.out.println(canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4)); // true
		System.out.println(canPartitionKSubsets(new int[] { 1, 2, 3, 4 }, 3)); // false
		System.out.println(canPartitionKSubsets(
				new int[] { 605, 454, 322, 218, 8, 19, 651, 2220, 175, 710, 2666, 350, 252, 2264, 327, 1843 }, 4)); // true
		System.out.println(canPartitionKSubsets(new int[] { 2, 2, 2, 2, 3, 4, 5 }, 4)); // false
	}
}
