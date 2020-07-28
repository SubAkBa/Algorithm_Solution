import java.util.*;

public class Solution_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int len = nums.length, diff = Integer.MAX_VALUE;

		for (int i = 0; i < len && diff != 0; ++i) {
			int left = i + 1, right = len - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (Math.abs(target - sum) < Math.abs(diff))
					diff = target - sum;

				if (sum < target)
					++left;
				else
					--right;
			}
		}

		return target - diff;
	}
}
