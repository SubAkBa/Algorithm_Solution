
public class Solution_FindPeakElement {
	public static int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[mid + 1])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 })); // 2
		System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })); // 5
	}

}
