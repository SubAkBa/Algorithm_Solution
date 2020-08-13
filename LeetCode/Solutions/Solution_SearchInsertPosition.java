
public class Solution_SearchInsertPosition {

	public static int Lower_Bounds(int[] nums, int len, int target) {
		int left = 0, right = len - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (target <= nums[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int idx = Lower_Bounds(nums, len, target);

		return nums[idx] < target ? idx + 1 : idx;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5)); // 2
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2)); // 1
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7)); // 4
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0)); // 0

	}

}
