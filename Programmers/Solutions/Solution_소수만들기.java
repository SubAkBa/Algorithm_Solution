
public class Solution_소수만들기 {
	static int count;

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;

		if (num == 2)
			return true;

		if (num % 2 == 0)
			return false;

		int sqrt = (int) Math.sqrt(num);

		for (int i = 3; i <= sqrt; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static void MakePrimeNumber(int[] nums, int len, int curSum, int r, int start) {
		if (r == 0) {
			if (isPrime(curSum))
				++count;
			return;
		}

		if (start == len)
			return;

		for (int i = start; i < len; ++i)
			MakePrimeNumber(nums, len, curSum + nums[i], r - 1, i + 1);
	}

	public static int solution(int[] nums) {
		count = 0;

		MakePrimeNumber(nums, nums.length, 0, 3, 0);

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 })); // 1
		System.out.println(solution(new int[] { 1, 2, 7, 6, 4 })); // 4
	}
}
