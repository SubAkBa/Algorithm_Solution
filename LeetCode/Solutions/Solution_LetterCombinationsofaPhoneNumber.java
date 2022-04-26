import java.util.*;

public class Solution_LetterCombinationsofaPhoneNumber {

    static char[][] letters = {{}, {}, {'a', 'b', 'c'},
            {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    static List<String> answer;
    static int dLen;

    public static void Combination(String digits, char[] digit, int idx) {
        if (idx == dLen) {
            answer.add(new String(digit));
            return;
        }

        int letterIdx = digits.charAt(idx) - '0';
        for (int i = 0; i < letters[letterIdx].length; ++i) {
            digit[idx] = letters[letterIdx][i];
            Combination(digits, digit, idx + 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        dLen = digits.length();

        if (dLen > 0)
            Combination(digits, new char[dLen], 0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("")); // []
        System.out.println(letterCombinations("2")); // ["a","b","c"]
    }
}
