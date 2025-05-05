import java.util.Arrays;

public class Solution_ThirdMaximumNumber {
	public static int thirdMax(int[] nums) {
		long[] resultArr = new long[3];

		Arrays.fill(resultArr, Long.MIN_VALUE);

		for (int num : nums) {
			if (resultArr[0] == num || resultArr[1] == num || resultArr[2] == num) {
				continue;
			}

			int idx = 1;
			while (idx < 3 && num > resultArr[idx]) {
				resultArr[idx - 1] = resultArr[idx];
				++idx;
			}

			if (resultArr[idx - 1] < num) {
				resultArr[idx - 1] = num;
			}
		}

		return resultArr[0] == Long.MIN_VALUE ? (int)resultArr[2] : (int)resultArr[0];
	}

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[]{3, 2, 1})); // 1
		System.out.println(thirdMax(new int[]{1, 2})); // 2
		System.out.println(thirdMax(new int[]{2, 2, 3, 1})); // 1
		System.out.println(thirdMax(new int[]{Integer.MIN_VALUE, 2, 3})); // Integer.MIN_VALUE
		System.out.println(thirdMax(new int[]{Integer.MAX_VALUE, 2, 3})); // 2
		System.out.println(thirdMax(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 3})); // 3
		System.out.println(thirdMax(new int[]{1, 2, 2, 5, 3, 5})); // 2
		System.out.println(thirdMax(new int[]{5, 2, 4, 1, 3, 6, 0})); // 4
	}
}
