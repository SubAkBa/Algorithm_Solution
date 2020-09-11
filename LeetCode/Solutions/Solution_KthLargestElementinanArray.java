import java.util.*;

public class Solution_KthLargestElementinanArray {

	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length - k];
	}

	// Quick Selection
	public static void Swap(int[] nums, int n1, int n2) {
		int temp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = temp;
	}

	public static int Partition(int[] nums, int left, int right) {
		int mid = (left + right) / 2;

		Swap(nums, left, mid);
		int pivot = nums[left];

		while (left < right) {
			while (left < right && nums[right] <= pivot)
				--right;

			nums[left] = nums[right];

			while (left < right && nums[left] >= pivot)
				++left;

			nums[right] = nums[left];
		}

		nums[left] = pivot;

		return right;
	}

	public static int QuickSelection(int[] nums, int left, int right, int k) {
		if (left < right) {
			int idx = Partition(nums, left, right);

			System.out.println(Arrays.toString(nums));
			if (idx < k)
				QuickSelection(nums, idx + 1, right, k);
			else if (idx > k)
				QuickSelection(nums, left, idx - 1, k);
			else
				return nums[idx];
		}

		return nums[k];
	}

	public static int findKthLargest(int[] nums, int k) {
		return QuickSelection(nums, 0, nums.length - 1, --k);
	}

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)); // 4
	}
}
