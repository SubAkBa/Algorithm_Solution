public class Solution_RepeatedSubstringPattern {
	public static boolean repeatedSubstringPattern(String s) {
		String doubleStr = s + s;

		return doubleStr.substring(1, doubleStr.length() - 1).contains(s);
	}

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab")); // true
		System.out.println(repeatedSubstringPattern("aba")); // false
		System.out.println(repeatedSubstringPattern("abcabcabcabc")); // true
		System.out.println(repeatedSubstringPattern("bb")); // true
		System.out.println(repeatedSubstringPattern("a")); // false
	}
}
