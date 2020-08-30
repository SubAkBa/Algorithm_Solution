import java.util.*;

public class Solution_LetterCombinationsofaPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
		int dlen = digits.length();

		if (dlen == 0)
			return answer;

		String[] pn = new String[] { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		int[] idx = new int[dlen];

		int total_counts = 1;

		for (int i = 0; i < dlen; ++i)
			total_counts *= pn[digits.charAt(i) - '1'].length();

		for (int i = 0; i < total_counts; ++i) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < dlen; ++j)
				sb.append(pn[digits.charAt(j) - '1'].charAt(idx[j]));

			answer.add(sb.toString());

			++idx[dlen - 1];
			for (int j = dlen - 1; j > 0; --j) {
				if (idx[j] == pn[digits.charAt(j) - '1'].length()) {
					idx[j] = 0;
					++idx[j - 1];
					continue;
				} else
					break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23")); // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
		System.out.println(letterCombinations("13")); // []
	}
}
