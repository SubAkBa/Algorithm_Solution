import java.util.*;

public class Solution_LongestIncreasingSubsequence {

	public static int Lower_Bounds(List<Integer> list, int target, int len) {
		int left = 0, right = len - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (target <= list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int lengthOfLIS(int[] nums) {
		int len = nums.length;
		List<Integer> list = new ArrayList<>();

		if (len == 0)
			return list.size();

		list.add(nums[0]);
		for (int i = 0; i < len; ++i) {
			int size = list.size();
			if (nums[i] <= list.get(size - 1))
				list.set(Lower_Bounds(list, nums[i], size), nums[i]);
			else
				list.add(nums[i]);
		}

		return list.size();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 4
		System.out.println(lengthOfLIS(new int[] { -2, -1 })); // 2
	}
}
