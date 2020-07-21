import java.util.*;

public class Solution_LetterCasePermutation {

	public static void Permutation(char[] s, StringBuilder sb, int idx, List<String> answer) {
		if (idx == s.length) {
			answer.add(sb.toString());
			return;
		}

		sb.append(s[idx]);
		Permutation(s, sb, idx + 1, answer);
		sb.deleteCharAt(sb.length() - 1);

		if (!('0' <= s[idx] && s[idx] <= '9')) {
			s[idx] ^= (1 << 5);

			sb.append(s[idx]);
			Permutation(s, sb, idx + 1, answer);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> answer = new ArrayList<>();

		Permutation(S.toCharArray(), new StringBuilder(), 0, answer);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("3z4"));
		System.out.println(letterCasePermutation("a1b2"));
		System.out.println(letterCasePermutation("12345"));
	}

}
