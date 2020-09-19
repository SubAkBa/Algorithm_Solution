public class Solution_MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		int slen = s.length(), tlen = t.length();

		if (slen < tlen || slen == 0 || tlen == 0)
			return "";

		int[] counts = new int[128];
		int type = tlen;
		for (int i = 0; i < tlen; ++i)
			++counts[t.charAt(i)];

		int left = 0, right = 0;
		String answer = s;
		while (right < slen) {
			if ((--counts[s.charAt(right)]) >= 0)
				--type;

			++right;

			while (type == 0) {
				if (answer.length() > (right - left))
					answer = s.substring(left, right);

				if ((++counts[s.charAt(left)]) > 0)
					++type;

				++left;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
		System.out.println(minWindow("AAAAAAAAABC", "ABAC")); // "AABC"
		System.out.println(minWindow("$$#$$%", "#%")); // "#$$%"
		System.out.println(minWindow("ADDDDDDDDABC", "AABC")); // "ADDDDDDDDDDDDABC"
		System.out.println(minWindow("acbbaca", "aba")); // "baca"
		System.out.println(minWindow("a", "a")); // "a"
		System.out.println(minWindow("a", "b")); // ""
	}
}
