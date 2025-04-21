public class Solution_PalindromeNumber {
	public static boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int left = 0, right = str.length() - 1;

		while (left < right) {
			char leftChar = str.charAt(left);
			char rightChar = str.charAt(right);

			if (leftChar != rightChar) {
				return false;
			}

			++left;
			--right;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(121)); // true
		System.out.println(isPalindrome(-121)); // false
		System.out.println(isPalindrome(10)); // false
	}
}
