public class Solution_PowerOfFour {
	public static boolean isPowerOfFour(int n) {
		if (n <= 0) {
			return false;
		}

		while (n % 4 == 0) {
			n /= 4;
		}

		return n == 1;
	}

	public static boolean isPowerOfFour(int n) {
		if (n == 1)
			return true;

		if (n <= 0)
			return false;

		double logBase4 = Math.log(n) / Math.log(4);

		return (logBase4 == (int)logBase4);
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16)); // true
		System.out.println(isPowerOfFour(5)); // false
		System.out.println(isPowerOfFour(1)); // true
	}
}
