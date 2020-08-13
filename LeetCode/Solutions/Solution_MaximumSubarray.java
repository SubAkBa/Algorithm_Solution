
public class Solution_MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		int max = nums[0], len = nums.length, calc = nums[0];

		for (int i = 1; i < len; ++i) {
			calc = Math.max(nums[i], calc + nums[i]);
			max = Math.max(max, calc);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
