public class Solution_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		int idx = 0;
		int minLen = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			minLen = Math.min(minLen, str.length());
		}

		while (minLen > 0 && idx < minLen) {
			char c = strs[0].charAt(idx);

			for (String str : strs) {
				if (c != str.charAt(idx)) {
					return sb.toString();
				}
			}

			sb.append(c);
			++idx;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); // "fl"
		System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"})); // ""
		System.out.println(longestCommonPrefix(new String[]{""})); // ""
		System.out.println(longestCommonPrefix(new String[]{"a"})); // "a"
	}
}
