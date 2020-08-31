
public class Solution_GetEqualSubstringsWithinBudget {

	public static int equalSubstring(String s, String t, int maxCost) {
		int len = s.length(), min_value = Integer.MAX_VALUE;
		int[] dist = new int[len];

		for (int i = 0; i < len; ++i) {
			dist[i] = Math.abs(s.charAt(i) - t.charAt(i));
			min_value = Math.min(min_value, dist[i]);
		}

		if (min_value > maxCost)
			return 0;

		int left = 0, right = 0, current_cost = 0;

		while (right < len) {
			current_cost += dist[right];

			if (current_cost > maxCost) {
				current_cost -= dist[left];
				++left;
			}

			++right;
		}

		return right - left;
	}

	public static void main(String[] args) {
		System.out.println(equalSubstring("abcd", "bcdf", 3)); // 3
		System.out.println(equalSubstring("abcd", "cdef", 3)); // 1
		System.out.println(equalSubstring("abcd", "acde", 0)); // 1
		System.out.println(equalSubstring("abcd", "bcde", 0)); // 0
		System.out.println(equalSubstring("abcd", "belz", 30)); // 3
		System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14)); // 4
		System.out.println(equalSubstring("fkfnkrfunni", "jyufzxzfbsa", 18)); // 2
	}
}
