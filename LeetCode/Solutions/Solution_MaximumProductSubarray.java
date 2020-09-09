
public class Solution_MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		int len = nums.length;

		int min_calc = nums[0], max_calc = nums[0], answer = nums[0];
		for (int i = 1; i < len; ++i) {
			if (nums[i] < 0) {
				int temp = min_calc;
				min_calc = max_calc;
				max_calc = temp;
			}

			min_calc = Math.min(nums[i], min_calc * nums[i]);
			max_calc = Math.max(nums[i], max_calc * nums[i]);

			answer = Math.max(answer, max_calc);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 })); // 6
		System.out.println(maxProduct(new int[] { -2, 0, -1 })); // 0
		System.out.println(maxProduct(new int[] { 2, 3, -2, 1, -1, 8, 9 })); // 864
	}
}