
public class Solution_WiggleSubsequence {

	public static int wiggleMaxLength(int[] nums) {
		int len = nums.length, answer = 1;

		if (len <= 1)
			return len;

		if (nums[0] != nums[1])
			++answer;

		int diff = nums[0] - nums[1];

		for (int i = 2; i < len; ++i) {

			if ((diff <= 0 && nums[i - 1] > nums[i]) || (diff >= 0 && nums[i - 1] < nums[i])) {
				diff = nums[i - 1] - nums[i];
				++answer;
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 })); // 6
		System.out.println(wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 })); // 7
		System.out.println(wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })); // 2
		System.out.println(wiggleMaxLength(new int[] { 0, 0, 0 })); // 1
		System.out.println(wiggleMaxLength(new int[] { 3, 3, 3, 2, 5 })); // 3
	}

}
