import java.util.*;

public class Solution_FindFirstandLastPositionofElementinSortedArray {

	public static int Upper_Bound(int[] nums, int N, int target) {
		int left = 0, right = N - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (target < nums[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int Lower_Bound(int[] nums, int N, int target) {
		int left = 0, right = N - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (target <= nums[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		int lowidx = Lower_Bound(nums, len, target);
		int upidx = Upper_Bound(nums, len, target);

		if (len == 0 || nums[lowidx] != target)
			return new int[] { -1, -1 };

		if (nums[upidx] > target)
			upidx--;

		return new int[] { lowidx, upidx };
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 10)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 12)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 5, 5, 5, 5, 5 }, 5)));
		System.out.println(Arrays.toString(searchRange(new int[] { 0 }, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] { 0 }, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
	}

}
