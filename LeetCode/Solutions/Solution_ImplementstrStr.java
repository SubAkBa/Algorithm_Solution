
public class Solution_ImplementstrStr {

	public static int[] getPi(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];

		for (int i = 1, j = 0; i < len; ++i) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];

			if (pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}

		return pi;
	}

	public static int strStr(String haystack, String needle) {
		int hlen = haystack.length(), nlen = needle.length();

		if (nlen == 0)
			return 0;

		if (hlen == 0)
			return -1;

		int[] pi = getPi(needle);

		for (int i = 0, j = 0; i < hlen; ++i) {
			while (j > 0 && haystack.charAt(i) != needle.charAt(j))
				j = pi[j - 1];

			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == nlen - 1)
					return i - nlen + 1;
				else
					++j;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("mississippi", "issip"));
	}
}
