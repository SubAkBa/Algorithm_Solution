import java.util.*;

public class Solution_TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();

		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);

		List<String> answer = new ArrayList<>(map.keySet());

		Collections.sort(answer,
				(s1, s2) -> map.get(s1) == map.get(s2) ? s1.compareTo(s2) : Integer.compare(map.get(s2), map.get(s1)));

		return answer.subList(0, k);
	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}
}
