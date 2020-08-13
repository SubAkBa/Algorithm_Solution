
public class Solution_FindMinimuminRotatedSortedArray {

	public static int findMin(int[] nums) {
		int len = nums.length;
		int left = 0, right = len - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[left] < nums[right])
				return nums[left];

			if (nums[left] > nums[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return nums[right];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
	}

}
