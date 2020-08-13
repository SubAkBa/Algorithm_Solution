
public class Solution_PartitionEqualSubsetSum {

	public static boolean canPartition(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return true;

		int sum = 0;
		for (int i = 0; i < len; ++i)
			sum += nums[i];

		if ((sum & 1) == 1 || len == 1)
			return false;

		int target = sum >> 1;
		boolean[] possible = new boolean[target + 1];

		possible[0] = true;
		for (int i = 0; i < len; ++i) {
			for (int j = target; j >= nums[i]; --j)
				possible[j] = possible[j] || possible[j - nums[i]];
		}

		return possible[target];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
	}
}
