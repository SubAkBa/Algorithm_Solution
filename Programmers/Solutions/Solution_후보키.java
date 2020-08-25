import java.util.*;

public class Solution_후보키 {

	public static boolean isUnique(int key, int row, int column, String[][] relation, List<Integer> candidate) {
		Set<String> set = new HashSet<>();

		for (int i = 0; i < row; ++i) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < column; ++j) {
				if ((key & (1 << j)) != 0)
					sb.append(relation[i][j]);
			}

			if (set.contains(sb.toString()))
				return false;
			else
				set.add(sb.toString());
		}

		return true;
	}

	public static boolean isMinimal(int key, List<Integer> candidate) {
		for (int c : candidate) {
			if ((key & c) == c)
				return false;
		}

		return true;
	}

	public static int solution(String[][] relation) {
		int row = relation.length;
		int column = relation[0].length;
		List<Integer> candidate = new ArrayList<>();

		for (int key = 1; key < (1 << column); ++key) {
			if (!isMinimal(key, candidate))
				continue;

			if (!isUnique(key, row, column, relation, candidate))
				continue;

			candidate.add(key);
		}

		return candidate.size();
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } }));
	}
}
