import java.util.*;

public class Solution_FindCommonCharacters {

	public static List<String> commonChars(String[] A) {
		int Alen = A.length, size = 26;
		int[][] counts = new int[Alen][size];
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < Alen; ++i) {
			for (char a : A[i].toCharArray())
				++counts[i][a - 'a'];
		}

		for (int i = 0; i < size; ++i) {
			int min_count = Integer.MAX_VALUE;

			for (int j = 0; j < Alen; ++j) {
				if (counts[j][i] == 0)
					break;

				min_count = Math.min(min_count, counts[j][i]);

				if (j == Alen - 1) {
					while ((--min_count) >= 0)
						answer.add(String.valueOf((char) (i + 'a')));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(commonChars(new String[] { "bella", "label", "roller" })); // ["e","l","l"]
		System.out.println(commonChars(new String[] { "cool", "lock", "cook" })); // ["c","o"]
	}
}
