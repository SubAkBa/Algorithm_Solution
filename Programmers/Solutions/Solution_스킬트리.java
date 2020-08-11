import java.util.*;

public class Solution_스킬트리 {

	public static int solution(String skill, String[] skill_trees) {
		int slen = skill.length();
		HashSet<Character> set = new HashSet<>();

		for (int i = 0; i < slen; ++i)
			set.add(skill.charAt(i));

		int answer = 0;
		int stlen = skill_trees.length;
		for (int i = 0; i < stlen; ++i) {
			char[] ch = skill_trees[i].toCharArray();
			boolean isPossible = true;
			int sidx = 0;

			for (char c : ch) {
				if (sidx == slen)
					break;

				if (skill.charAt(sidx) != c && set.contains(c)) {
					isPossible = false;
					break;
				}

				if (skill.charAt(sidx) == c)
					++sidx;

			}

			if (isPossible)
				++answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" })); // 2
	}
}
