import java.util.HashMap;
import java.util.Map;

public class Solution_WordPattern {
	public static boolean wordPattern(String pattern, String s) {
		Map<Character, String> charToPatternMap = new HashMap<>();
		Map<String, Character> patternToCharacterMap = new HashMap<>();

		char[] charArray = pattern.toCharArray();
		String[] sArray = s.split(" ");

		if (charArray.length != sArray.length) {
			return false;
		}

		for (int i = 0; i < sArray.length; ++i) {
			char c = charArray[i];

			if (!charToPatternMap.containsKey(c)) {
				charToPatternMap.put(c, sArray[i]);
			} else if (!sArray[i].equals(charToPatternMap.get(c))) {
				return false;
			}

			if (!patternToCharacterMap.containsKey(sArray[i])) {
				patternToCharacterMap.put(sArray[i], c);
			} else if (patternToCharacterMap.get(sArray[i]) != c) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog")); // true
		System.out.println(wordPattern("abba", "dog cat cat fish")); // false
		System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
		System.out.println(wordPattern("abba", "dog dog dog dog")); // false
		System.out.println(wordPattern("aaa", "aa aa aa aa")); // false
	}
}
