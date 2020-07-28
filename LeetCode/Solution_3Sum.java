import java.util.*;

public class Solution_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> answer = new ArrayList<>();

		int len = nums.length;

		for (int i = 0; i < len; ++i) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;

			int left = i + 1, right = len - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1])
						++left;

					while (left < right && nums[right] == nums[right - 1])
						--right;

					++left;
					--right;
				} else if (sum < 0)
					++left;
				else
					--right;
			}
		}

		return answer;
	}
}
