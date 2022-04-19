import java.util.*;

public class Solution_FindandReplacePattern {
    static int pLen;

    public static boolean isMatch(String word, String pattern) {
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();

        for (int i = 0; i < pLen; ++i) {
            wordToPattern.putIfAbsent(word.charAt(i), pattern.charAt(i));
            patternToWord.putIfAbsent(pattern.charAt(i), word.charAt(i));

            if (wordToPattern.get(word.charAt(i)) != pattern.charAt(i)
                    || patternToWord.get(pattern.charAt(i)) != word.charAt(i))
                return false;
        }

        return true;
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        pLen = pattern.length();

        for (String word : words) {
            if (isMatch(word, pattern))
                answer.add(word);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")); // ["mee","aqq"]
        System.out.println(findAndReplacePattern(new String[]{"a", "b", "c"}, "a")); // ["a","b","c"]
    }
}
