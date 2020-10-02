import java.util.*;

public class Solution_KeyboardRow {

	public static String[] findWords(String[] words) {
		Map<Character, Integer> table = new HashMap<>();
		char[][] alphabets = new char[][] { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
				{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }, { 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };

		int len = 3;
		for (int i = 0; i < len; ++i) {
			for (char a : alphabets[i])
				table.put(a, i);
		}

		int wcount = words.length;

		List<Integer> idxs = new ArrayList<>();
		for (int i = 0; i < wcount; ++i) {
			String temp_word = words[i].toLowerCase();
			int wlen = temp_word.length(), j;

			int row = table.get(temp_word.charAt(0));
			for (j = 1; j < wlen; ++j) {
				if (row != table.get(temp_word.charAt(j)))
					break;
			}

			if (j == wlen)
				idxs.add(i);
		}

		int size = idxs.size();
		String[] answer = new String[size];

		for (int i = 0; i < size; ++i)
			answer[i] = words[idxs.get(i)];

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" }))); // ["Alaska",
																											// "Dad"]
		System.out.println(Arrays.toString(findWords(new String[] { "a", "b" }))); // ["a","b"]
	}
}
