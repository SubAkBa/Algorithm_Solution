import java.util.*;

public class Solution_GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		int strlen = strs.length, size = 26;

		if (strlen == 0)
			return new ArrayList<>();

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		int[] counts = new int[size];
		for (int i = 0; i < strlen; ++i) {
			Arrays.fill(counts, 0);

			int len = strs[i].length();
			for (int j = 0; j < len; ++j)
				++counts[strs[i].charAt(j) - 'a'];

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; ++j)
				sb.append(counts[j]);

			map.computeIfAbsent(sb.toString(), (a) -> new ArrayList<>()).add(strs[i]);
		}

		return new ArrayList(map.values());
	}

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}
}
