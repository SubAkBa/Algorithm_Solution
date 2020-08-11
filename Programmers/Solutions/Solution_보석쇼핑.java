import java.util.*;

public class Solution_jewelryshopping {
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		HashMap<String, Integer> hm = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		int left = 0, right = 0, length = Integer.MAX_VALUE, len = gems.length;

		for (int i = 0; i < len; ++i)
			set.add(gems[i]);

		int type = set.size();

		while (left < len && right < len) {

			if (hm.size() < type) {
				hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
				
				++right;
			} else if (hm.size() == type) {
				if (hm.get(gems[left]) == 1)
					hm.remove(gems[left]);
				else
					hm.put(gems[left], hm.get(gems[left]) - 1);

				++left;
			}

			if (hm.size() == type && (right - left) < length) {
				length = right - left;
				answer[0] = left + 1;
				answer[1] = right;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" })));
		System.out.println(Arrays.toString(solution(new String[] { "AA", "AB", "AC", "AA", "AC" })));
		System.out.println(Arrays.toString(solution(new String[] { "XYZ", "XYZ", "XYZ" })));
		System.out.println(Arrays.toString(solution(new String[] { "ZZZ", "YYY", "NNNN", "YYY", "BBB" })));
	}
}
