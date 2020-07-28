import java.util.*;

public class Solution_TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; ++i) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
			}

			map.put(nums[i], i);
		}

		return result;
	}
}
