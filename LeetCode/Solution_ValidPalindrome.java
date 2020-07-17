
public class Solution_ValidPalindrome {
	public static boolean isPalindrome(String s) {
		int len = s.length();

		if (len == 0)
			return true;

		int left = 0, right = len - 1;
		char lc = s.charAt(left), rc = s.charAt(right);
		s = s.toLowerCase();

		while (left < right) {
			while (left < right && !Character.isLetterOrDigit((lc = s.charAt(left))))
				++left;

			while (left < right && !Character.isLetterOrDigit((rc = s.charAt(right))))
				--right;

			if (left < right) {
				if (lc != rc)
					return false;

				++left;
				--right;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

}
