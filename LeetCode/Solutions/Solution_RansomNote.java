import java.util.HashMap;
import java.util.Map;

public class Solution_RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> charCountMap = new HashMap<>();
		int rLen = ransomNote.length();
		int mLen = magazine.length();

		if (rLen > mLen) {
			return false;
		}

		for (int i = 0; i < mLen; ++i) {
			char ch = magazine.charAt(i);
			charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < rLen; ++i) {
			char ch = ransomNote.charAt(i);

			if (!charCountMap.containsKey(ch)) {
				return false;
			}

			charCountMap.put(ch, charCountMap.get(ch) - 1);

			if (charCountMap.get(ch) < 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		int rLen = ransomNote.length();
		int mLen = magazine.length();

		if (rLen > mLen) {
			return false;
		}

		for (int i = 0; i < mLen; ++i) {
			++count[magazine.charAt(i) - 'a'];
		}

		for (int i = 0; i < rLen; ++i) {
			int idx = ransomNote.charAt(i) - 'a';

			if ((--count[idx]) < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b")); // false
		System.out.println(canConstruct("aa", "ab")); // false
		System.out.println(canConstruct("aa", "aab")); // true
		System.out.println(canConstruct("aaa", "aa")); // false
		System.out.println(canConstruct("a", "a")); // true
	}
}
