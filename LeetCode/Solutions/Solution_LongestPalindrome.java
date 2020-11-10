
public class Solution_LongestPalindrome {
	public static int longestPalindrome(String s) {
		int SIZE = 127;
		int[] counts = new int[SIZE];

		int slen = s.length();
		for (int i = 0; i < slen; ++i)
			++counts[s.charAt(i)];

		boolean chkOdd = false;
		int answer = 0;
		for (int i = 0; i < SIZE; ++i) {
			if (!chkOdd && ((counts[i] & 1) == 1)) {
				++answer;
				chkOdd = true;
			}

			answer += (counts[i] / 2) * 2;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd")); // 7
		System.out.println(longestPalindrome("a")); // 1
		System.out.println(longestPalindrome("bb")); // 2
	}
}
