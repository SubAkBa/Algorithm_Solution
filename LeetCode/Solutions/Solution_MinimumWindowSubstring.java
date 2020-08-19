public class Solution_MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		int left = 0, right = 0;
		int slen = s.length(), type = t.length();

		if (slen < type || type == 0 || slen == 0)
			return "";

		int[] counts = new int[128];

		for (int i = 0; i < type; ++i)
			++counts[t.charAt(i)];

		int len = Integer.MAX_VALUE;
		String answer = "";

		while (right < slen) {
			if (type > 0) {
				--counts[s.charAt(right)];

				if (counts[s.charAt(right)] >= 0)
					--type;

				++right;
			}

			while (type == 0) {
				if (len > (right - left)) {
					len = right - left;
					answer = s.substring(left, right);
				}

				++counts[s.charAt(left)];

				if (counts[s.charAt(left)] > 0)
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
	}
}
