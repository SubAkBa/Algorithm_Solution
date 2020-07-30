
public class Solution_SearchinRotatedSortedArray {

	public static int search(int[] nums, int target) {
		int len = nums.length;
		int left = 0, right = len - 1;

		while (left <= right) {
			int mid = (left + right) >> 1;

			if (nums[mid] == target)
				return mid;

			if (nums[left] < nums[mid]) {
				if (nums[left] == target)
					return left;

				if (nums[left] <= target && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (nums[right] == target)
					return right;

				if (nums[mid] < target && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)); // -1
		System.out.println(search(new int[] { 5, 1, 3 }, 5)); // 0
	}
}
