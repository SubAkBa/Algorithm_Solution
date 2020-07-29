
public class Solution_PowerofTwo {
	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

		return (n & n - 1) == 0;
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

		int answer = n - (n & -n);

		return answer == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1)); // true
		System.out.println(isPowerOfTwo(16)); // true
		System.out.println(isPowerOfTwo(218)); // false
		System.out.println(isPowerOfTwo(0)); // false
		System.out.println(isPowerOfTwo(-2147483648)); // false
		System.out.println(isPowerOfTwo(2147483647)); // false
	}
}
