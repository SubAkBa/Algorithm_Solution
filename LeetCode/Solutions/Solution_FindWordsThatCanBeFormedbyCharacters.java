
public class Solution_FindWordsThatCanBeFormedbyCharacters {

	public static int countCharacters(String[] words, String chars) {
		int[] counts = new int[26];
		int[] t_counts = new int[26];

		int clen = chars.length();
		for (char c : chars.toCharArray())
			++counts[c - 'a'];

		int words_counts = words.length;
		int answer = 0;

		for (int i = 0; i < words_counts; ++i) {
			int wlen = words[i].length();

			if (wlen > clen)
				continue;

			System.arraycopy(counts, 0, t_counts, 0, 26);

			int j;
			for (j = 0; j < wlen; ++j) {
				if ((--t_counts[words[i].charAt(j) - 'a']) < 0)
					break;
			}

			if (j == wlen)
				answer += wlen;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
		System.out.println(countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));
	}

}
