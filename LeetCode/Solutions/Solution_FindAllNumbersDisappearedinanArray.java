import java.util.ArrayList;
import java.util.List;

public class Solution_FindAllNumbersDisappearedinanArray {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int[] counts = new int[nums.length + 1];

		for (int num : nums) {
			++counts[num];
		}

		for (int i = 1; i <= nums.length; ++i) {
			if (counts[i] == 0) {
				result.add(i);
			}
		}

		return result;
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; ++i) {
			int idx = Math.abs(nums[i]) - 1;

			if (nums[idx] < 0) {
				continue;
			}

			nums[idx] *= -1;
		}

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // [5, 6]
		System.out.println(findDisappearedNumbers(new int[]{1, 1})); // [2]
	}
}
