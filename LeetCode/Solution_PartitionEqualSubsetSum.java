public class Solution_PartitionEqualSubsetSum {

	public static boolean canPartition(int[] nums) {
		int len = nums.length;

		if (len == 0)
			return true;

		int sum = 0;
		for (int i = 0; i < len; i++)
			sum += nums[i];

		int target = sum / 2;

		if (sum % 2 != 0 || len == 1)
			return false;

		boolean[] possible = new boolean[target + 1];

		possible[0] = true;

		for (int i = 1; i <= len; i++) {
			for (int j = target; j >= nums[i - 1]; j--)
				possible[j] = possible[j] || possible[j - nums[i - 1]];
		}

		return possible[target];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { 2, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 97, 95 }));
	}

}
