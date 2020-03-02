import java.util.*;

public class Solution_skillstreat {

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		final int ALPHABET_SIZE = 26;
		boolean[] possible = new boolean[ALPHABET_SIZE];

		Arrays.fill(possible, true);

		for (int i = 1; i < skill.length(); i++)
			possible[skill.charAt(i) - 'A'] = false;

		for (int i = 0; i < skill_trees.length; i++) {
			boolean ispos = true;
			boolean[] cppossible = Arrays.copyOf(possible, ALPHABET_SIZE);
			int idx = 0;

			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (cppossible[skill_trees[i].charAt(j) - 'A']) {
					if (skill_trees[i].charAt(j) == skill.charAt(idx)) {
						if (idx < skill.length() - 1) {
							idx++;
							cppossible[skill.charAt(idx) - 'A'] = true;
						}
					}
				} else {
					ispos = false;
					break;
				}
			}

			if (ispos)
				answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

}
