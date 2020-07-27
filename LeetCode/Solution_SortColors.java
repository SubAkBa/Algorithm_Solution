
public class Solution_SortColors {

	public void Swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public void sortColors(int[] nums) {
		int slow = 0, fast = 0, len = nums.length;

		while (fast < len) {
			if (nums[fast] == 0) {
				Swap(nums, slow, fast);
				++slow;
			}

			++fast;
		}

		fast = slow;

		while (fast < len) {
			if (nums[fast] == 1) {
				Swap(nums, slow, fast);
				++slow;
			}

			++fast;
		}
	}
}
