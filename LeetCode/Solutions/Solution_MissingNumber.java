
public class Solution_MissingNumber {

	public static int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = len * (len + 1) / 2;

		for (int i = 0; i < len; ++i)
			sum -= nums[i];

		return sum;
	}

	public static int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = len;

		for (int i = 0; i < len; ++i)
			sum ^= i ^ nums[i];

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}
}
