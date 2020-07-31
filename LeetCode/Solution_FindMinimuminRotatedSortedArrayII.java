
public class Solution_FindMinimuminRotatedSortedArrayII {

	public static int findMin(int[] nums) {
		int len = nums.length;
		int left = 0, right = len - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[left] < nums[right])
				return nums[left];

			if (nums[left] > nums[mid])
				right = mid;
			else if(nums[left] < nums[mid])
				left = mid + 1;
			else
				++left;
		}

		return nums[right];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 1, 3, 5 }));
		System.out.println(findMin(new int[] { 2, 2, 2, 0, 1 }));
		System.out.println(findMin(new int[] { 3, 1, 3 }));
		System.out.println(findMin(new int[] { 10, 1, 10, 10, 10 }));
		System.out.println(findMin(new int[] { 10, 10, 10, 1, 10 }));
		System.out.println(findMin(new int[] { 10, 10, 10, 10, 1 }));
		System.out.println(findMin(new int[] { 10, 10, 1, 10, 10, 10, 10, 10 }));
		System.out.println(findMin(new int[] { 10, 10, 10, 10, 10, 10, 1, 10 }));
		System.out.println(findMin(new int[] { 10, 10, 10, 10, 10, 1, 10, 10 }));
	}

}
