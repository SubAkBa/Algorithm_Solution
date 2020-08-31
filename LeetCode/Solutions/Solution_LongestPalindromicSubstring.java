public class Solution_LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		int len = s.length();

		if (len == 0)
			return "";

		int clen = 2 * len + 1;
		char[] ch = new char[clen];

		ch[0] = '#';
		for (int i = 0; i < len; ++i) {
			ch[2 * i + 1] = s.charAt(i);
			ch[2 * i + 2] = '#';
		}

		int[] rad = new int[clen];
		int r = 0, p = 0;
		int maxlen = 0;

		for (int i = 1; i < clen; ++i) {
			if (r >= i)
				rad[i] = Math.min(r - i, rad[2 * p - i]);

			while (0 <= i - rad[i] - 1 && i + rad[i] + 1 < clen && ch[i - rad[i] - 1] == ch[i + rad[i] + 1])
				++rad[i];

			maxlen = Math.max(maxlen, rad[i]);

			if (r < i + rad[i]) {
				r = i + rad[i];
				p = i;
			}
		}

		String str = "";
		for (int i = 0; i < clen; ++i) {
			if (maxlen > rad[i])
				continue;

			StringBuilder sb = new StringBuilder();

			for (int j = i - rad[i] + 1; j < i + rad[i] + 1; ++j) {
				if (j % 2 == 0)
					continue;

				sb.append(ch[j]);
			}

			if (str.length() < sb.toString().length())
				str = sb.toString();
		}

		return str;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad")); // "bab"
		System.out.println(longestPalindrome("cbbd")); // "bb"
		System.out.println(longestPalindrome("a")); // "a"
	}
}
