import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_TwoSum {

	// O(N^2) / O(1)
	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		int[] answer = null;

		for (int i = 0; i < len - 1; ++i) {
			for (int j = i + 1; j < len; ++j) {
				if ((nums[i] + nums[j]) == target) {
					answer = new int[] { i, j };
					break;
				}
			}
		}

		return answer;
	}

	// O(N) / O(N)
	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int[] answer = null;

		for (int i = 0; i < len; ++i) {
			int diff = target - nums[i];

			if (map.containsKey(diff)) {
				answer = new int[] { map.get(diff), i };
				break;
			}

			map.put(nums[i], i);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
	}
}
